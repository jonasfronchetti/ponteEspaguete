/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Avaliacoes;
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
public class Controla_Avaliacoes {

    public static Avaliacoes objAvaliacao = null;
    JTable dtgAvaliacoes = null;
    ResultSet result = null;

    public Controla_Avaliacoes(Avaliacoes objAvaliacao, JTable dtgAvaliacoes) {
        this.objAvaliacao = objAvaliacao;
        this.dtgAvaliacoes = dtgAvaliacoes;
    }

    public int gravarAvaliacao() {
        try {
                    String wSQL = "";

                    wSQL = "SELECT MAX(COALESCE(Id_Avaliacao,0))+1 FROM c_avaliacoes";
                    result = Tela_Login.stmt.executeQuery(wSQL);

                    while (result.next()) {
                        objAvaliacao.definirId_Avaliacao(result.getInt(1));
                    }
                    if (objAvaliacao.obterId_Avaliacao() == 0){
                        objAvaliacao.definirId_Avaliacao(1);
                    }
                    
                    System.out.println("MAX ID_AVALIACAO: " + objAvaliacao.obterId_Avaliacao());

                    wSQL ="";
                    wSQL  += " INSERT INTO c_avaliacoes ";
                    wSQL  += " (Data_Criacao,";
                    wSQL  += " Usuario_Criacao,";
                    wSQL  += " Data_Exclusao,";
                    wSQL  += " Usuario_Exclusao,";
                    wSQL  += " id_avaliacao,";
                    wSQL  += " data_avaliacao";
                    wSQL  += " ) VALUES(";
                    wSQL  += "'" + objAvaliacao.obterData_Criacao() + "',";
                    wSQL  += "'" + objAvaliacao.obterUsuario_Criacao() + "',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "'" + objAvaliacao.obterId_Avaliacao() + "',";
                    wSQL  += "'" + objAvaliacao.obterData_Avaliacao()+ "')";
            System.out.println("INSERT AVALIAÇÃO: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return objAvaliacao.obterId_Avaliacao();
            }
        } catch (Exception e) {
        }
        return 0;
        //return objAvaliacao.obterId_Avaliacao();
    }

    public int alterarAvaliacao() {
        try {
            /*
                    String wSQL = "";
                    wSQL  += " UPDATE C_Avaliacaos ";
                    wSQL  += " SET Nome_Avaliacao = '" + objAvaliacao.obterNome_Avaliacao() + "',";
                    wSQL  += " Telefone = '" + objAvaliacao.obterTelefone() + "'";
                    wSQL  += " WHERE Id_Avaliacao = " + objAvaliacao.obterId_Avaliacao();
            System.out.println("UPDATE CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        */
        } catch (Exception e) {
        }
        
        return 0;
    }

    public int excluirAvaliacao() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Avaliacaos ";
                    wSQL  += " SET Data_Exclusao = '"+ objAvaliacao.obterData_Exclusao() +"',";
                    wSQL  += " Usuario_Exclusao = '"+ objAvaliacao.obterUsuario_Exclusao() +"'";
                    wSQL  += " WHERE Id_Avaliacao = " + objAvaliacao.obterId_Avaliacao();
            System.out.println("UPDATE EXC AVALIACAO: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void PreencheAvaliacoes(String pPesquisaPor, String pValor, String pTipoSelecao) {

        String wPesquisa = "";
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id_Avaliacao");
        cabecalhos.add("Data_Avaliacao");
        cabecalhos.add(" ");
        if("Id_Avaliacao".equals(pPesquisaPor)){
            pPesquisaPor = "CAST(Id_Avaliacao AS VARCHAR)";
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
            SQL = "SELECT Id_Avaliacao, Data_Avaliacao ";
            SQL += " FROM C_Avaliacoes ";
            SQL += " WHERE Data_Exclusao is null ";
            SQL += wPesquisa;
            
            result = Tela_Login.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add("X");
                dadosTabela.add(linha);
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        dtgAvaliacoes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        dtgAvaliacoes.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 3; i++) {
            column = dtgAvaliacoes.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(250);
                    break;
                case 2:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        dtgAvaliacoes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public int buscarAvaliacao()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT Data_Criacao, Usuario_Criacao, Usuario_Exclusao, Data_Exclusao, Id_Avaliacao, Data_Avaliacao ";
         SQL += " FROM C_Avaliacoes ";
         SQL += " WHERE Id_Avaliacao = " + objAvaliacao.obterId_Avaliacao();
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarAvaliacao");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarAvaliacao");

          try
            {
            while (rs.next())
            {
                objAvaliacao.definirData_Criacao(rs.getString(1));
                objAvaliacao.definirUsuario_Criacao(rs.getInt(2));
                objAvaliacao.definirUsuario_Exclusao(rs.getInt(3));
                objAvaliacao.definirData_Exclusao(rs.getString(4));
                objAvaliacao.definirId_Avaliacao(rs.getInt(5));
                objAvaliacao.definirData_Avaliacao(rs.getString(6));
                }
            if (objAvaliacao.obterId_Avaliacao() == 0){
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
         System.out.println ("Executou buscarAvaliacao com sucesso");
         return (0);
     }
}
