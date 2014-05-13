/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuarios;
import Interface.Tela_Login;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jonas
 */
public class Controla_Usuarios {

    Usuarios objUsuario = null;
    JTable dtgUsuarios = null;
    ResultSet result = null;

    public Controla_Usuarios(Usuarios objUsuario, JTable dtgUsuarios) {
        this.objUsuario = objUsuario;
        this.dtgUsuarios = dtgUsuarios;
    }

    public int gravarUsuario() {
        try {
                    String wSQL = "";

                    wSQL = "SELECT MAX(COALESCE(Id_Usuario,0))+1 FROM C_Usuarios";
                    result = Tela_Login.stmt.executeQuery(wSQL);

                    while (result.next()) {
                        objUsuario.definirId_Usuario(result.getInt(1));
                    }
                    if (objUsuario.obterId_Usuario() == 0){
                        objUsuario.definirId_Usuario(1);
                    }
                    
                    System.out.println("MAX ID_Usuario: " + objUsuario.obterId_Usuario());

                    wSQL ="";
                    wSQL  += " INSERT INTO C_Usuarios ";
                    wSQL  += " (Data_Criacao,";
                    wSQL  += " Usuario_Criacao,";
                    wSQL  += " Data_Exclusao,";
                    wSQL  += " Usuario_Exclusao,";
                    wSQL  += " Id_Usuario,";
                    wSQL  += " Nome_Usuario,";
                    wSQL  += " Login_Usuario,";
                    wSQL  += " Senha_Usuario,";
                    wSQL  += " Situacao_Usuario) VALUES(";
                    wSQL  += "'" + objUsuario.obterData_Criacao() + "',";
                    wSQL  += "'" + objUsuario.obterUsuario_Criacao() + "',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "'" + objUsuario.obterId_Usuario() + "',";
                    wSQL  += "'" + objUsuario.obterNome_Usuario() + "',";
                    wSQL  += "'" + objUsuario.obterlogin_Usuario() + "',";
                    wSQL  += "'" + objUsuario.obterSenha_Usuario() + "',";
                    wSQL  += "'" + objUsuario.obterSituacao_Usuario() + "')";
            System.out.println("INSERT Usuarios: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int alterarUsuario() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Usuarios ";
                    wSQL  += " SET Nome_Usuario = '" + objUsuario.obterNome_Usuario() + "',";
                    wSQL  += " Login_Usuario = '" + objUsuario.obterlogin_Usuario() + "',";
                    wSQL  += " Senha_Usuario = '" + objUsuario.obterSenha_Usuario() + "'";
                    wSQL  += " WHERE Id_Usuario = " + objUsuario.obterId_Usuario();
            System.out.println("UPDATE Usuarios: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int excluirUsuario() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Usuarios ";
                    wSQL  += " SET Data_Exclusao = '"+ objUsuario.obterData_Exclusao() +"',";
                    wSQL  += " Usuario_Exclusao = '"+ objUsuario.obterUsuario_Exclusao() +"'";
                    wSQL  += " Situacao_Usuario = 'E'";
                    wSQL  += " WHERE Id_Usuario = " + objUsuario.obterId_Usuario();
            System.out.println("UPDATE EXC Usuarios: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void PreencheUsuarios(String pPesquisaPor, String pValor, String pTipoSelecao) {

        String wPesquisa = "";
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Id_Usuario");
        cabecalhos.add("Nome_Usuario");
        cabecalhos.add("Login_Usuario");
        cabecalhos.add(" ");
        if("Id_Usuario".equals(pPesquisaPor)){
            pPesquisaPor = "CAST(Id_Usuario AS VARCHAR)";
        }
        if (!pPesquisaPor.equals("") && !pValor.equals("")){
            if (pTipoSelecao == "CP")
            wPesquisa = " AND " + pPesquisaPor + " like '"+ pValor.replace("'", "") +"%'";
            else if(pTipoSelecao == "CT")
            wPesquisa = " AND " + pPesquisaPor + " like '%"+ pValor.replace("'", "") +"%'";
            else
            wPesquisa = " AND " + pPesquisaPor + " = '"+ pValor.replace("'", "") +"'";
        }
        
        
        try {

            String SQL = "";
            SQL = "SELECT Id_Usuario, Nome_Usuario, Login_Usuario ";
            SQL += " FROM C_Usuarios ";
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

        dtgUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        dtgUsuarios.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = dtgUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(80);
                    break;
                case 1:
                    column.setPreferredWidth(190);
                    break;
                case 2:
                    column.setPreferredWidth(150);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        dtgUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public int buscarUsuario()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT Data_Criacao, Usuario_Criacao, Data_Exclusao, Usuario_Exclusao, Id_Usuario, Nome_Usuario, ";
         SQL += " Login_Usuario, Senha_Usuario, Situacao_Usuario ";
         SQL += " FROM C_Usuarios ";
         SQL += " WHERE Id_Usuario = " + objUsuario.obterId_Usuario();
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarUsuario");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarUsuario");

          try
            {
            while (rs.next())
            {
                objUsuario.definirData_Criacao(rs.getString(1));
                objUsuario.definirUsuario_Criacao(rs.getInt(2));
                objUsuario.definirData_Exclusao(rs.getString(3));
                objUsuario.definirUsuario_Exclusao(rs.getInt(4));
                objUsuario.definirId_Usuario(rs.getInt(5));
                objUsuario.definirNome_Usuario(rs.getString(6));
                objUsuario.definirLogin_Usuario(rs.getString(7));
                objUsuario.definirSenha_Usuario(rs.getString(8));
                objUsuario.definirSituacao_Usuario(rs.getString(9));
                }
            if (objUsuario.obterId_Usuario() == 0){
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
         System.out.println ("Executou buscarUsuario com sucesso");
         return (0);
     }
}
