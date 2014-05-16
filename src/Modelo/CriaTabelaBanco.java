/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interface.Tela_Login;

/**
 *
 * @author jonasf
 */
public class CriaTabelaBanco {

    public void criaTabelaUsuario() {
        try {
            String sql = "CREATE TABLE c_usuarios ("
                    + "  data_criacao timestamp without time zone,"
                    + "  usuario_criacao integer,"
                    + "  data_exclusao timestamp without time zone,"
                    + "  usuario_exclusao integer,"
                    + "  id_usuario integer NOT NULL,"
                    + "  nome_usuario character varying(50),"
                    + "  login_usuario character varying(20),"
                    + "  senha_usuario character varying(20),"
                    + "  situacao_usuario character varying(1),"
                    + "  CONSTRAINT pk_id_usuario PRIMARY KEY (id_usuario),"
                    + "  CONSTRAINT c_usuarios_usuario_criacao_fkey FOREIGN KEY (usuario_criacao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION,"
                    + "  CONSTRAINT c_usuarios_usuario_exclusao_fkey FOREIGN KEY (usuario_exclusao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION"
                    + ");";

            Tela_Login.stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": ERRO " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabela c_usuarios criada com sucesso");
    }

    public void criaTabelaEquipes() {
        try {
            String sql = "CREATE TABLE c_equipes"
                    + "("
                    + "  data_criacao timestamp without time zone,"
                    + "  usuario_criacao integer,"
                    + "  data_exclusao timestamp without time zone,"
                    + "  usuario_exclusao integer,"
                    + "  id_equipe integer NOT NULL,"
                    + "  nome_equipe character varying(50),"
                    + "  telefone character varying(20),"
                    + "  CONSTRAINT pk_id_equipe PRIMARY KEY (id_equipe),"
                    + "  CONSTRAINT c_equipe_usuario_criacao_fkey FOREIGN KEY (usuario_criacao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION,"
                    + "  CONSTRAINT c_clientes_usuario_exclusao_fkey FOREIGN KEY (usuario_exclusao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION"
                    + ");";

            Tela_Login.stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": ERRO " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabela c_equipes criada com sucesso");
    }
    public void criaTabelaAvaliacoes() {
        try {
            String sql = "CREATE TABLE c_avaliacoes"
                    + "("
                    + "  data_criacao timestamp without time zone,"
                    + "  usuario_criacao integer,"
                    + "  data_exclusao timestamp without time zone,"
                    + "  usuario_exclusao integer,"
                    + "  id_avaliacao integer NOT NULL,"
                    + "  data_avaliacao timestamp without time zone,"
                    + "  CONSTRAINT pk_id_avaliacao PRIMARY KEY (id_avaliacao),"
                    + "  CONSTRAINT c_equipe_usuario_criacao_fkey FOREIGN KEY (usuario_criacao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION,"
                    + "  CONSTRAINT c_clientes_usuario_exclusao_fkey FOREIGN KEY (usuario_exclusao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION"
                    + ");";

            Tela_Login.stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": ERRO " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabela c_avaliacoes criada com sucesso");
    }
    public void criaTabelaAvaliacoesEquipe() {
        try {
            String sql = "CREATE TABLE c_avaliacoes_equipe"
                    + "("
                    + "  data_criacao timestamp without time zone,"
                    + "  usuario_criacao integer,"
                    + "  data_exclusao timestamp without time zone,"
                    + "  usuario_exclusao integer,"
                    + "  id_avaliacao integer NOT NULL,"
                    + "  id_equipe integer NOT NULL,"
                    + "  pontuacao double,"
                    + "  peso_ponte double,"
                    + "  problema character varying(200),"
                    + "  aprovado bit,"
                    + "  CONSTRAINT pk_id_avaliacao_equipe PRIMARY KEY (id_equipe, id_avaliacao),"
                    + "  CONSTRAINT c_equipe_usuario_criacao_fkey FOREIGN KEY (usuario_criacao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION,"
                    + "  CONSTRAINT c_clientes_usuario_exclusao_fkey FOREIGN KEY (usuario_exclusao)"
                    + "      REFERENCES c_usuarios (id_usuario) MATCH SIMPLE"
                    + "      ON UPDATE NO ACTION ON DELETE NO ACTION"
                    + ");";

            Tela_Login.stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": ERRO " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Tabela c_avaliacoes_equipe criada com sucesso");
    }
    public void criaUsuarioPadrao() {
        try {
                    String wSQL = "";

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
                    wSQL  += "'" + "" + "',";
                    wSQL  += "'ponte',";
                    wSQL  += "Null,";
                    wSQL  += "Null,";
                    wSQL  += "'1',";
                    wSQL  += "'ponte',";
                    wSQL  += "'ponte',";
                    wSQL  += "'ponte',";
                    wSQL  += "'A')";
            System.out.println("INSERT Usuarios: " + wSQL);
            Tela_Login.stmt.execute(wSQL);
        } catch (Exception e) {
        }
    }

}
