/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jonas
 */
public class Clientes {
   
    private String Data_Criacao = "";
    private int Usuario_Criacao = 0;
    private String Data_Exclusao = "";
    private int Usuario_Exclusao = 0;
    private int Id_Cliente = 0; // chave primaria
    private String Nome_Cliente = "";
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
     * @return the Id_Cliente
     */
    public int obterId_Cliente() {
        return Id_Cliente;
    }

    /**
     * @param Id_Cliente the Id_Cliente to set
     */
    public void definirId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    /**
     * @return the Nome_Cliente
     */
    public String obterNome_Cliente() {
        return Nome_Cliente;
    }

    /**
     * @param Nome_Cliente the Nome_Cliente to set
     */
    public void definirNome_Cliente(String Nome_Cliente) {
        this.Nome_Cliente = Nome_Cliente;
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
