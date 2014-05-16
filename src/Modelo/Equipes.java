/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jonas
 */
public class Equipes {
   
    private String Data_Criacao = "";
    private int Usuario_Criacao = 0;
    private String Data_Exclusao = "";
    private int Usuario_Exclusao = 0;
    private int Id_Equipe = 0; // chave primaria
    private String Nome_Equipe = "";
    private String Telefone = "";

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
     * @return the Id_Equipe
     */
    public int obterId_Equipe() {
        return Id_Equipe;
    }

    /**
     * @param Id_Equipe the Id_Equipe to set
     */
    public void definirId_Equipe(int Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }

    /**
     * @return the Nome_Equipe
     */
    public String obterNome_Equipe() {
        return Nome_Equipe;
    }

    /**
     * @param Nome_Equipe the Nome_Equipe to set
     */
    public void definirNome_Equipe(String Nome_Equipe) {
        this.Nome_Equipe = Nome_Equipe;
    }

    /**
     * @return the Telefone
     */
    public String obterTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void definirTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    
}
