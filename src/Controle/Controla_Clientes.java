/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Clientes;
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
public class Controla_Clientes {

    public static Clientes objCliente = null;
    JTable dtgClientes = null;
    ResultSet result = null;

    public Controla_Clientes(Clientes objCliente, JTable dtgClientes) {
        this.objCliente = objCliente;
        this.dtgClientes = dtgClientes;
    }

    public int gravarCliente() {
        try {
                    String wSQL = "";

                    wSQL = "SELECT MAX(COALESCE(Id_Cliente,0))+1 FROM C_Clientes";
                    result = Tela_Login.stmt.executeQuery(wSQL);

                    while (result.next()) {
                        objCliente.definirId_Cliente(result.getInt(1));
                    }
                    if (objCliente.obterId_Cliente() == 0){
                        objCliente.definirId_Cliente(1);
                    }
                    
                    System.out.println("MAX ID_CLIENTE: " + objCliente.obterId_Cliente());

                    wSQL ="";
                    wSQL  += " INSERT INTO C_Clientes ";
                    wSQL  += " (Data_Criacao,";
                    wSQL  += " Usuario_Criacao,";
                    wSQL  += " Data_Exclusao,";
                    wSQL  += " Usuario_Exclusao,";
                    wSQL  += " Id_Cliente,";
                    wSQL  += " Nome_Cliente,";
                    wSQL  += " Telefone) VALUES(";
                    wSQL  += "'" + objCliente.obterData_Criacao() + "',";
                    wSQL  += "'" + objCliente.obterUsuario_Criacao() + "',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "'" + objCliente.obterId_Cliente() + "',";
                    wSQL  += "'" + objCliente.obterNome_Cliente() + "',";
                    wSQL  += "'" + objCliente.obterTelefone() + "')";
            System.out.println("INSERT CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int alterarCliente() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Clientes ";
                    wSQL  += " SET Nome_Cliente = '" + objCliente.obterNome_Cliente() + "',";
                    wSQL  += " Telefone = '" + objCliente.obterTelefone() + "'";
                    wSQL  += " WHERE Id_Cliente = " + objCliente.obterId_Cliente();
            System.out.println("UPDATE CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int excluirCliente() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Clientes ";
                    wSQL  += " SET Data_Exclusao = '"+ objCliente.obterData_Exclusao() +"',";
                    wSQL  += " Usuario_Exclusao = '"+ objCliente.obterUsuario_Exclusao() +"'";
                    wSQL  += " WHERE Id_Cliente = " + objCliente.obterId_Cliente();
            System.out.println("UPDATE EXC CLIENTES: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void PreencheClientes(String pPesquisaPor, String pValor, String pTipoSelecao) {

        String wPesquisa = "";
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id_Cliente");
        cabecalhos.add("Nome_Cliente");
        cabecalhos.add("Telefone");
        cabecalhos.add(" ");
        if("Id_Cliente".equals(pPesquisaPor)){
            pPesquisaPor = "CAST(Id_Cliente AS VARCHAR)";
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
            SQL = "SELECT Id_Cliente, Nome_Cliente, Telefone ";
            SQL += " FROM C_Clientes ";
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

        dtgClientes.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        dtgClientes.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = dtgClientes.getColumnModel().getColumn(i);
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
        dtgClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public int buscarCliente()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT Data_Criacao, Usuario_Criacao, Usuario_Exclusao, Data_Exclusao, Id_Cliente, Nome_Cliente, Telefone ";
         SQL += " FROM C_Clientes ";
         SQL += " WHERE Id_Cliente = " + objCliente.obterId_Cliente();
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarCliente");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarCliente");

          try
            {
            while (rs.next())
            {
                objCliente.definirData_Criacao(rs.getString(1));
                objCliente.definirUsuario_Criacao(rs.getInt(2));
                objCliente.definirUsuario_Exclusao(rs.getInt(3));
                objCliente.definirData_Exclusao(rs.getString(4));
                objCliente.definirId_Cliente(rs.getInt(5));
                objCliente.definirNome_Cliente(rs.getString(6));
                objCliente.definirTelefone(rs.getString(7));
                }
            if (objCliente.obterId_Cliente() == 0){
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
         System.out.println ("Executou buscarCliente com sucesso");
         return (0);
     }
}
