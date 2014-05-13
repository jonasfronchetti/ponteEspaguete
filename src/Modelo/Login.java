/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Interface.Tela_Login;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jonas
 */
public class Login {

    private int Id_Usuario = 0; // chave primaria
    private String Login_Usuario = "";
    private String Nome_Usuario = "";
    private String Senha_Usuario = "";
    private String Situacao_Usuario = "";
   
    /**
     * @return the código
     */
    public int obterId_Usuario()
    {
        return Id_Usuario;
    }
    
    /**
     * @return the código
     */
    public String obterNome_Usuario()
    {
        return Nome_Usuario;
    }

    /**
     * @return the código
     */
    public String obterLogin_Usuario()
    {
        return Login_Usuario;
    }

        /**
     * @return the código
     */
    public String obterSenha_Usuario()
    {
        return Senha_Usuario;
    }

        /**
     * @return the código
     */
    public String obterSituacao_Usuario()
    {
        return Situacao_Usuario;
    }

    
     /**
     * @return the código
     */
    public void definirId_Usuario(int Id_Usuario)
    {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the código
     */
    public void definirNome_Usuario(String Nome_Usuario)
    {
        this.Nome_Usuario = Nome_Usuario;
    }

    /**
     * @return the código
     */
    public void definirLogin_Usuario(String Login_Usuario)
    {
        this.Login_Usuario = Login_Usuario;
    }

        /**
     * @return the código
     */
    public void definirSenha_Usuario(String Senha_Usuario)
    {
        this.Senha_Usuario = Senha_Usuario;
    }

        /**
     * @return the código
     */
    public void definirSituacao_Usuario(String Situacao_Usuario)
    {
        this.Situacao_Usuario = Situacao_Usuario;
    }

        /**
     * @return the código
     */
    
    public int buscarUsuario(String xLogin, String xSenha)
     {
       try {
         ResultSet rs = null;

         String SQL = "";
         SQL = "SELECT id_Usuario, Login_Usuario, Nome_Usuario, Senha_Usuario, Situacao_Usuario FROM c_usuarios ";
         SQL+= "WHERE Login_Usuario = '" + xLogin + "'";
         SQL+= "AND Senha_Usuario = '"+ xSenha + "'";
         SQL+= "AND Situacao_Usuario = 'A'";
         //stm.executeQuery(SQL);

         System.out.println ("Vai Executar Conexão em Login");
         rs = Tela_Login.stmt.executeQuery(SQL);
         System.out.println ("Executou Conexão em Login");

          try
            {
            while (rs.next())
            {
                definirId_Usuario(rs.getInt(1));
                definirLogin_Usuario(rs.getString(2));
                definirNome_Usuario(rs.getString(3));
                System.out.println (rs.getString(3));
                definirSenha_Usuario(rs.getString(4));
                definirSituacao_Usuario(rs.getString(5));
            }
            if (obterId_Usuario() == 0){
              return (1);
            }
            }

            catch ( SQLException ex )
            {
            System.err.println( "SQLException: " + ex.getMessage() );
            }
            
         } catch (Exception e) {
              e.printStackTrace();
               return (-1);
         }

         return (0);
     }

}