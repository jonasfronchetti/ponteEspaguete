/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Form.java
 *
 * Created on 23/02/2011, 13:29:37
 */
package Interface;

import Relatorios.Relatorio_OS;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Jonas
 */
public class Menu extends javax.swing.JFrame {

    public int mIdUsuarioLogin;
    public String mLoginUsuario;
    Tela_Equipes objEquipes;
    Tela_Avaliacoes objAvaliacoes;
    Relatorio_OS objRelatorio_OS;
    Component objUsuarios;
    String mJanela = "";
    
    //JFrame.setBackgroundImage(new Image("./images/seupng.png"));
    
    /** Creates new form Form */
    public Menu() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnAvaliacoes = new javax.swing.JMenuItem();
        mnEquipes = new javax.swing.JMenuItem();
        mnUsuarios = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        mnRelatorio_OS = new javax.swing.JMenuItem();
        mnJanelas = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();
        mnSairTela = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/fundo.jpg"))); // NOI18N

        mnCadastros.setText("Cadastros");

        mnAvaliacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/prova.png"))); // NOI18N
        mnAvaliacoes.setText("Avaliações");
        mnAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAvaliacoesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnAvaliacoes);

        mnEquipes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Funcionario.PNG"))); // NOI18N
        mnEquipes.setText("Equipes");
        mnEquipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEquipesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnEquipes);

        mnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Especialidades.png"))); // NOI18N
        mnUsuarios.setText("Usuários");
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnUsuarios);

        jMenuBar1.add(mnCadastros);

        mnRelatorios.setText("Relatórios");

        mnRelatorio_OS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Relatorios.png"))); // NOI18N
        mnRelatorio_OS.setText("Relatório Ordem Serviço");
        mnRelatorio_OS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRelatorio_OSActionPerformed(evt);
            }
        });
        mnRelatorios.add(mnRelatorio_OS);

        jMenuBar1.add(mnRelatorios);

        mnJanelas.setText("Janelas");
        jMenuBar1.add(mnJanelas);

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });

        mnSairTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Porta.PNG"))); // NOI18N
        mnSairTela.setText("Sair");
        mnSairTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairTelaActionPerformed(evt);
            }
        });
        mnSair.add(mnSairTela);

        jMenuBar1.add(mnSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(701, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnEquipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEquipesActionPerformed
        // TODO add your handling code here:
        mnEquipes.setEnabled(false);
        objEquipes = new Tela_Equipes("");
        objEquipes.setVisible(true);
    }//GEN-LAST:event_mnEquipesActionPerformed

    private void mnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuariosActionPerformed
        // TODO add your handling code here:
        mnUsuarios.setEnabled(false);
        objUsuarios = new Tela_Usuarios();
        objUsuarios.setVisible(true);
    }//GEN-LAST:event_mnUsuariosActionPerformed

    private void mnRelatorio_OSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRelatorio_OSActionPerformed
        // TODO add your handling code here:
        mnRelatorio_OS.setEnabled(false);
        objRelatorio_OS = new Relatorio_OS();
        objRelatorio_OS.setVisible(true);
    }//GEN-LAST:event_mnRelatorio_OSActionPerformed

    private void mnSairTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairTelaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_mnSairTelaActionPerformed

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAvaliacoesActionPerformed
        mnAvaliacoes.setEnabled(false);
        objAvaliacoes = new Tela_Avaliacoes(mJanela);
        objAvaliacoes.setVisible(true);
    }//GEN-LAST:event_mnAvaliacoesActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
     public int preencheJanelas(String pJanela, String pTipo){
        try {
            
            System.out.println("Tipo: "+ pTipo);
            System.out.println("Janela: " + pJanela);

            if (pTipo.equals("I"))
               if (pJanela.equals("Equipes")){
                   mnEquipes.setEnabled(true);
                   System.out.println("Botou Visivel Equipes");
               }
               if (pJanela.equals("Usuarios")){
                   mnUsuarios.setEnabled(true);
                   System.out.println("Botou Visivel Usuarios");
               }
                if (pJanela.equals("Relatorio_OS")){
                   mnRelatorio_OS.setEnabled(true);
                   System.out.println("Botou Visivel Relatorio_OS");
               }
               if (pJanela.equals("Avaliacoes")){
                   mnAvaliacoes.setEnabled(true);
                   System.out.println("Botou Visivel Avaliações");
               }
               else{
                if  (pTipo.equals("E"))
                   //mnJanelas.remove(pJanela);
                    System.out.println("teste");
                else
                {

                }
            }

             } catch (Exception e) {
              e.printStackTrace();
              return (-1);
         }
          return (0);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnAvaliacoes;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnEquipes;
    private javax.swing.JMenu mnJanelas;
    private javax.swing.JMenuItem mnRelatorio_OS;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuItem mnSairTela;
    private javax.swing.JMenuItem mnUsuarios;
    // End of variables declaration//GEN-END:variables

}
