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
        System.out.println("Tabela criada com sucesso");
    }

    public void criaTabelaClientes() {
        try {
            String sql = "CREATE TABLE c_clientes"
                    + "("
                    + "  data_criacao timestamp without time zone,"
                    + "  usuario_criacao integer,"
                    + "  data_exclusao timestamp without time zone,"
                    + "  usuario_exclusao integer,"
                    + "  id_cliente integer NOT NULL,"
                    + "  nome_cliente character varying(50),"
                    + "  telefone character varying(20),"
                    + "  CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente),"
                    + "  CONSTRAINT c_clientes_usuario_criacao_fkey FOREIGN KEY (usuario_criacao)"
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
        System.out.println("Tabela criada com sucesso");
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
