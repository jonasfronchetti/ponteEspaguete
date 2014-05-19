/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jonas
 */
public class Avaliacoes_Equipe {
   
    private String Data_Criacao = "";
    private int Usuario_Criacao = 0;
    private String Data_Exclusao = "";
    private int Usuario_Exclusao = 0;
    private int Id_Avaliacao = 0; // chave primaria
    private int Id_Equipe = 0; // chave primaria
    private double peso_ponte = 0;  
    private double pontuacao = 0;  
    private String problema = "";
    private String nome_Equipe = "";
    private int aprovado = 0;
   
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
     * @return the Id_Equipe
     */
    public int obterId_Equipe() {
        return Id_Equipe;
    }

    /**
     * @param Id_Avaliacao the Id_Equipe to set
     */
    public void definirId_Equipe(int Id_Equipe) {
        this.Id_Equipe = Id_Equipe;
    }
    
         /**
     * @return the Id_Equipe
     */
    public int obterAprovado() {
        return aprovado;
    }

    /**
     * @param Id_Avaliacao the Id_Equipe to set
     */
    public void definirAprovado(int aprovado) {
        this.aprovado = aprovado;
    }
    
          /**
     * @return the Id_Equipe
     */
    public double obterPeso_Ponte() {
        return peso_ponte;
    }

    /**
     * @param Id_Avaliacao the Id_Equipe to set
     */
    public void definirPeso_Ponte(double Peso_Ponte) {
        this.peso_ponte = Peso_Ponte;
    }
    
              /**
     * @return the pontuacao
     */
    public double obterPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the Id_Equipe to set
     */
    public void definirPontuacao(double Pontuacao) {
        this.pontuacao = Pontuacao;
    }
    

    /**
     * @return the Data_Avaliacao
     */
    public String obterProblema() {
        return problema;
    }

    /**
     * @param Problema the Data_Avaliacao to set
     */
    public void definirProblema(String Problema) {
        this.problema = Problema;
    }
    
    public String obterNome_Equipe() {
        return nome_Equipe;
    }
        
    public void definirNomeEquipe(String nome_Equipe) {
        this.nome_Equipe = nome_Equipe;
    }

    
}
