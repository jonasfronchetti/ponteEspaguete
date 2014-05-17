/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Equipes;
import Interface.Tela_Login;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jonas
 */
public class Controla_Equipes {

    public static Equipes objEquipe = null;
    JTable dtgEquipes = null;
    ResultSet result = null;

    public Controla_Equipes(Equipes objEquipe, JTable dtgEquipes) {
        this.objEquipe = objEquipe;
        this.dtgEquipes = dtgEquipes;
    }

    public int gravarEquipe() {
        try {
                    String wSQL = "";

                    wSQL = "SELECT MAX(COALESCE(Id_Equipe,0))+1 FROM C_Equipes";
                    result = Tela_Login.stmt.executeQuery(wSQL);

                    while (result.next()) {
                        objEquipe.definirId_Equipe(result.getInt(1));
                    }
                    if (objEquipe.obterId_Equipe() == 0){
                        objEquipe.definirId_Equipe(1);
                    }
                    
                    System.out.println("MAX ID_CLIENTE: " + objEquipe.obterId_Equipe());

                    wSQL ="";
                    wSQL  += " INSERT INTO c_equipes ";
                    wSQL  += " (Data_Criacao,";
                    wSQL  += " Usuario_Criacao,";
                    wSQL  += " Data_Exclusao,";
                    wSQL  += " Usuario_Exclusao,";
                    wSQL  += " Id_Equipe,";
                    wSQL  += " Nome_Equipe,";
                    wSQL  += " Telefone) VALUES(";
                    wSQL  += "'" + objEquipe.obterData_Criacao() + "',";
                    wSQL  += "'" + objEquipe.obterUsuario_Criacao() + "',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "'" + objEquipe.obterId_Equipe() + "',";
                    wSQL  += "'" + objEquipe.obterNome_Equipe() + "',";
                    wSQL  += "'" + objEquipe.obterTelefone() + "')";
            System.out.println("INSERT CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int alterarEquipe() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Equipes ";
                    wSQL  += " SET Nome_Equipe = '" + objEquipe.obterNome_Equipe() + "',";
                    wSQL  += " Telefone = '" + objEquipe.obterTelefone() + "'";
                    wSQL  += " WHERE Id_Equipe = " + objEquipe.obterId_Equipe();
            System.out.println("UPDATE CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int excluirEquipe() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Equipes ";
                    wSQL  += " SET Data_Exclusao = '"+ objEquipe.obterData_Exclusao() +"',";
                    wSQL  += " Usuario_Exclusao = '"+ objEquipe.obterUsuario_Exclusao() +"'";
                    wSQL  += " WHERE Id_Equipe = " + objEquipe.obterId_Equipe();
            System.out.println("UPDATE EXC CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void PreencheEquipes(String pPesquisaPor, String pValor, String pTipoSelecao) {

        String wPesquisa = "";
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id_Equipe");
        cabecalhos.add("Nome_Equipe");
        cabecalhos.add("Telefone");
        cabecalhos.add(" ");
        if("Id_Equipe".equals(pPesquisaPor)){
            pPesquisaPor = "CAST(Id_Equipe AS VARCHAR)";
        }
        if (!pPesquisaPor.equals("") && !pValor.equals("")){
            if (pTipoSelecao == "CP")
            wPesquisa = " AND " + pPesquisaPor + " like '"+ pValor.replace("'", "") +"%'";
            else if(pTipoSelecao == "CT")
            wPesquisa = " AND " + pPesquisaPor + " like '%"+ pValor.replace("'", "") +"%'";
            else
            wPesquisa = " AND " + pPesquisaPor + " = '"+ pValor.replace("'", "") +"'";
        }
        
        System.out.println("AND =" + wPesquisa);
        
        try {

            String SQL = "";
            SQL = "SELECT Id_Equipe, Nome_Equipe, Telefone ";
            SQL += " FROM C_Equipes ";
            SQL += " WHERE Data_Exclusao is null ";
            SQL += wPesquisa;
            
            result = Tela_Login.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getString(3));
                linha.add("X");
                dadosTabela.add(linha);
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        dtgEquipes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        dtgEquipes.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = dtgEquipes.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(250);
                    break;
                case 2:
                    column.setPreferredWidth(200);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        dtgEquipes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.CYAN);
                } else {
                    setBackground(Color.WHITE);
                }
                return this;
            }
        });
        //return (true);
    }

    public int buscarEquipe()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT Data_Criacao, Usuario_Criacao, Usuario_Exclusao, Data_Exclusao, Id_Equipe, Nome_Equipe, Telefone ";
         SQL += " FROM C_Equipes ";
         SQL += " WHERE Id_Equipe = " + objEquipe.obterId_Equipe();
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarEquipe");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarEquipe");

          try
            {
            while (rs.next())
            {
                objEquipe.definirData_Criacao(rs.getString(1));
                objEquipe.definirUsuario_Criacao(rs.getInt(2));
                objEquipe.definirUsuario_Exclusao(rs.getInt(3));
                objEquipe.definirData_Exclusao(rs.getString(4));
                objEquipe.definirId_Equipe(rs.getInt(5));
                objEquipe.definirNome_Equipe(rs.getString(6));
                objEquipe.definirTelefone(rs.getString(7));
                }
            if (objEquipe.obterId_Equipe() == 0){
              return (1);
            }
            }

            catch (SQLException ex )
            {
            System.err.println( "SQLException: " + ex.getMessage() );
            }

         } catch (Exception e) {
              e.printStackTrace();
               return (-1);
         }
         System.out.println ("Executou buscarEquipe com sucesso");
         return (0);
     }
}
