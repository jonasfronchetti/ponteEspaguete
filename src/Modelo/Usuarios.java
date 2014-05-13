/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jonas
 */
public class Usuarios {
   
    private String Data_Criacao = "";
    private int Usuario_Criacao = 0;
    private String Data_Exclusao = "";
    private int Usuario_Exclusao = 0;
    private int Id_Usuario = 0; // chave primaria
    private String Nome_Usuario = "";
    private String Login_Usuario = "";
    private String Senha_Usuario = "";
    private String Situacao_Usuario = "";

    /**
     * @return the Data_Criacao
     */
    public String obterData_Criacao() {
        return Data_Criacao;
    }

    /**
     * @param Data_Criacao the Data_Criacao to set
     */
    public void definirData_Criacao(String Data_Criacao) {
        this.Data_Criacao = Data_Criacao;
    }

    /**
     * @return the Usuario_Criacao
     */
    public int obterUsuario_Criacao() {
        return Usuario_Criacao;
    }

    /**
     * @param Usuario_Criacao the Usuario_Criacao to set
     */
    public void definirUsuario_Criacao(int Usuario_Criacao) {
        this.Usuario_Criacao = Usuario_Criacao;
    }

    /**
     * @return the Data_Exclusao
     */
    public String obterData_Exclusao() {
        return Data_Exclusao;
    }

    /**
     * @param Data_Exclusao the Data_Exclusao to set
     */
    public void definirData_Exclusao(String Data_Exclusao) {
        this.Data_Exclusao = Data_Exclusao;
    }

    /**
     * @return the Usuario_Exclusao
     */
    public int obterUsuario_Exclusao() {
        return Usuario_Exclusao;
    }

    /**
     * @param Usuario_Exclusao the Usuario_Exclusao to set
     */
    public void definirUsuario_Exclusao(int Usuario_Exclusao) {
        this.Usuario_Exclusao = Usuario_Exclusao;
    }

    /**
     * @return the Id_Cliente
     */
    public int obterId_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Cliente the Id_Cliente to set
     */
    public void definirId_Usuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Nome_Cliente
     */
    public String obterNome_Usuario() {
        return Nome_Usuario;
    }

    /**
     * @param Nome_Cliente the Nome_Cliente to set
     */
    public void definirNome_Usuario(String Nome_Usuario) {
        this.Nome_Usuario = Nome_Usuario;
    }

    /**
     * @param Nome_Cliente the Nome_Cliente to set
     */
    public String obterlogin_Usuario() {
         return Login_Usuario;
    }

     /**
     * @param Nome_Cliente the Nome_Cliente to set
     */
    public void definirLogin_Usuario(String Login_Usuario) {
        this.Login_Usuario = Login_Usuario;
    }

    /**
     * @return the Telefone
     */
    public String obterSenha_Usuario() {
        return Senha_Usuario;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void definirSenha_Usuario(String Senha_Usuario) {
        this.Senha_Usuario = Senha_Usuario;
    }

    /**
     * @return the Telefone
     */
    public String obterSituacao_Usuario() {
        return Situacao_Usuario;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void definirSituacao_Usuario(String Situacao_Usuario) {
        this.Situacao_Usuario = Situacao_Usuario;
    }

    
}
