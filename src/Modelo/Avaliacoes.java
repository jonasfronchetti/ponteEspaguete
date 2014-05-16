/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jonas
 */
public class Avaliacoes {
   
    private String Data_Criacao = "";
    private int Usuario_Criacao = 0;
    private String Data_Exclusao = "";
    private int Usuario_Exclusao = 0;
    private int Id_Avaliacao = 0; // chave primaria
    private String Data_Avaliacao = "";
   
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
     * @return the Id_Avaliacao
     */
    public int obterId_Avaliacao() {
        return Id_Avaliacao;
    }

    /**
     * @param Id_Avaliacao the Id_Avaliacao to set
     */
    public void definirId_Avaliacao(int Id_Avaliacao) {
        this.Id_Avaliacao = Id_Avaliacao;
    }

    /**
     * @return the Data_Avaliacao
     */
    public String obterData_Avaliacao() {
        return Data_Avaliacao;
    }

    /**
     * @param Data_Avaliacao the Data_Avaliacao to set
     */
    public void definirData_Avaliacao(String Data_Avaliacao) {
        this.Data_Avaliacao = Data_Avaliacao;
    }

    
}
