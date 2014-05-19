/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Avaliacoes_Equipe;
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
public class Controla_Avaliacoes_Equipe {

    public static Avaliacoes_Equipe objAvaliacao_Equipe = null;
    JTable dtgAvaliacoes_Equipe = null;
    ResultSet result = null;

    public Controla_Avaliacoes_Equipe(Avaliacoes_Equipe objAvaliacao_Equipe, JTable dtgAvaliacoes_Equipe) {
        this.objAvaliacao_Equipe = objAvaliacao_Equipe;
        this.dtgAvaliacoes_Equipe = dtgAvaliacoes_Equipe;
    }

    public int gravarAvaliacao_Equipe() {
        try {
                    String wSQL = "";

                    /*wSQL = "SELECT MAX(COALESCE(Id_Avaliacao,0))+1 FROM c_avaliacoes";
                    result = Tela_Login.stmt.executeQuery(wSQL);

                    while (result.next()) {
                        objAvaliacao.definirId_Avaliacao(result.getInt(1));
                    }
                    if (objAvaliacao.obterId_Avaliacao() == 0){
                        objAvaliacao.definirId_Avaliacao(1);
                    }*/
                    
                    //System.out.println("MAX ID_AVALIACAO: " + objAvaliacao.obterId_Avaliacao());

                    wSQL ="";
                    wSQL  += " INSERT INTO C_Avaliacoes_Equipe ";
                    wSQL  += " (Data_Criacao,";
                    wSQL  += " Usuario_Criacao,";
                    wSQL  += " Data_Exclusao,";
                    wSQL  += " Usuario_Exclusao,";
                    wSQL  += " Id_Avaliacao,";
                    wSQL  += " Id_Equipe,";
                    wSQL  += " pontuacao,";
                    wSQL  += " peso_ponte,";
                    wSQL  += " problema,";
                    wSQL  += " aprovado ";
                    wSQL  += " ) VALUES(";
                    wSQL  += "'" + objAvaliacao_Equipe.obterData_Criacao() + "',";
                    wSQL  += "'" + objAvaliacao_Equipe.obterUsuario_Criacao() + "',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "" + objAvaliacao_Equipe.obterId_Avaliacao() + ",";
                    wSQL  += "" + objAvaliacao_Equipe.obterId_Equipe() + ",";
                    wSQL  += "" + objAvaliacao_Equipe.obterPontuacao() + ",";
                    wSQL  += "" + objAvaliacao_Equipe.obterPeso_Ponte() + ",";
                    wSQL  += "'" + objAvaliacao_Equipe.obterProblema() + "',";
                    wSQL  += "" + objAvaliacao_Equipe.obterAprovado() + ")";
            System.out.println("INSERT AVALIAÇÃO: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int alterarAvaliacao_Equipe() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Avaliacaos_Equipe ";
                    wSQL  += " SET peso_ponte = " + objAvaliacao_Equipe.obterPeso_Ponte()+ ",";
                    wSQL  += " pontuacao = " + objAvaliacao_Equipe.obterPontuacao()+ ",";
                    wSQL  += " aprovado = " + objAvaliacao_Equipe.obterAprovado() + " ";
                    wSQL  += " WHERE Id_Avaliacao = " + objAvaliacao_Equipe.obterId_Avaliacao();
                    wSQL  += " AND Id_Equipe = " + objAvaliacao_Equipe.obterId_Equipe();
                    
            System.out.println("UPDATE C_Avaliacaos_Equipe: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        
        return 0;
    }

    public int excluirAvaliacao_Equipe() {
        try {
                    String wSQL = "";
                    wSQL  += " UPDATE C_Avaliacaos_Equipe ";
                    wSQL  += " SET Data_Exclusao = '"+ objAvaliacao_Equipe.obterData_Exclusao() +"',";
                    wSQL  += " Usuario_Exclusao = '"+ objAvaliacao_Equipe.obterUsuario_Exclusao() +"'";
                    wSQL  += " WHERE Id_Avaliacao = " + objAvaliacao_Equipe.obterId_Avaliacao();
                    wSQL  += " AND Id_Equipe = " + objAvaliacao_Equipe.obterId_Equipe();
                 
                    System.out.println("UPDATE EXC C_Avaliacaos_Equipe: " + wSQL);
            boolean resultado = Tela_Login.stmt.execute(wSQL);
            if (resultado != true) {
                return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void PreencheAvaliacoes_Equipe(int id_avaliacao) {

        //String wPesquisa = "";
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("Código");
        cabecalhos.add("Nome");
        cabecalhos.add("Total");
        cabecalhos.add(" ");
        
        try {

            String SQL = "";
            SQL = "SELECT A.id_equipe, E.nome_equipe, A.pontuacao ";
            SQL += " FROM c_avaliacoes_equipe A, c_equipes E ";
            SQL += " WHERE A.Data_Exclusao is null ";
            SQL += " AND A.id_Avaliacao = " + id_avaliacao;
            SQL += " AND A.Id_Equipe = E.Id_Equipe";
            SQL += " AND A.aprovado = 1";
            SQL += " ORDER BY A.pontuacao, A.peso_ponte, E.nome_equipe ";
            
            result = Tela_Login.stmt.executeQuery(SQL);

            while (result.next()) {
                Vector<Object> linha = new Vector<Object>();
                linha.add(result.getInt(1));
                linha.add(result.getString(2));
                linha.add(result.getDouble(3));
                linha.add("X");
                dadosTabela.add(linha);
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        dtgAvaliacoes_Equipe.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        dtgAvaliacoes_Equipe.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = dtgAvaliacoes_Equipe.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(50);
                    break;
                case 1:
                    column.setPreferredWidth(90);
                    break;
                case 2:
                    column.setPreferredWidth(90);
                    break;
                case 3:
                    column.setPreferredWidth(10);
                    break;
            }
        }
        dtgAvaliacoes_Equipe.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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

    public int buscarAvaliacao_Equipe()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT A.Data_Criacao, A.Usuario_Criacao, A.Usuario_Exclusao, A.Data_Exclusao, A.id_avaliacao, A.id_equipe, A.pontuacao, A.peso_ponte, A.problema, A.aprovado, E.Nome_Equipe ";
         SQL += " FROM C_Avaliacoes_Equipe A, c_equipes E ";
         SQL += " WHERE A.Id_Equipe = E.Id_Equipe ";
         SQL += " AND A.Id_Avaliacao = " + objAvaliacao_Equipe.obterId_Avaliacao();
         SQL += " AND A.Id_Equipe = " + objAvaliacao_Equipe.obterId_Equipe();
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarAvaliacao");
         System.out.println ("SQL = " + SQL);
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarAvaliacao");

          try
            {
            while (rs.next())
            {
                objAvaliacao_Equipe.definirData_Criacao(rs.getString(1));
                objAvaliacao_Equipe.definirUsuario_Criacao(rs.getInt(2));
                objAvaliacao_Equipe.definirUsuario_Exclusao(rs.getInt(3));
                objAvaliacao_Equipe.definirData_Exclusao(rs.getString(4));
                objAvaliacao_Equipe.definirId_Avaliacao(rs.getInt(5));
                objAvaliacao_Equipe.definirId_Equipe(rs.getInt(6));
                objAvaliacao_Equipe.definirPontuacao(rs.getDouble(7));
                objAvaliacao_Equipe.definirPeso_Ponte(rs.getDouble(8));
                objAvaliacao_Equipe.definirProblema(rs.getString(9));
                objAvaliacao_Equipe.definirAprovado(rs.getInt(10));
                objAvaliacao_Equipe.definirNomeEquipe(rs.getString(11));
            }
            if (objAvaliacao_Equipe.obterId_Avaliacao() == 0){
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
         System.out.println ("Executou buscarAvaliacao_Equipe com sucesso");
         return (0);
     }
    
    public int buscarPosicaoAvaliacao_Equipe()
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT Quantidade = COUNT(*) ";
         SQL += " FROM c_avaliacoes_equipe ";
         SQL += " WHERE Id_Avaliacao = " + objAvaliacao_Equipe.obterId_Avaliacao();
         SQL += " AND pontuacao >= " + objAvaliacao_Equipe.obterPontuacao();
         SQL += " AND aprovado = 1";
         SQL += " ORDER BY pontuacao, peso_ponte ";
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em buscarPosicaoAvaliacao_Equipe");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em buscarPosicaoAvaliacao_Equipe");

          try
            {
            while (rs.next())
            {
                int wPos = rs.getInt(1) + 1;
                return (wPos);
                }
            if (objAvaliacao_Equipe.obterId_Avaliacao() == 0){
              return (0);
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
         System.out.println ("Executou buscarPosicaoAvaliacao_Equipe com sucesso");
         return (0);
     }
}
