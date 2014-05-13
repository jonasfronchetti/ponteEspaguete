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
import javax.swing.JFrame;

/**
 *
 * @author Jonas
 */
public class Menu extends javax.swing.JFrame {

    public int mIdUsuarioLogin;
    public String mLoginUsuario;
    Tela_Clientes objClientes;
    Tela_Principal objPrincipal;
    Relatorio_OS objRelatorio_OS;
    Component objUsuarios;
    String mJanela = "";
    /** Creates new form Form */
    public Menu() {
        initComponents();
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mnClientes = new javax.swing.JMenuItem();
        mnUsuarios = new javax.swing.JMenuItem();
        mnTeste = new javax.swing.JMenuItem();
        mnRelatorios = new javax.swing.JMenu();
        mnRelatorio_OS = new javax.swing.JMenuItem();
        mnJanelas = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenu();
        mnSairTela = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        mnCadastros.setText("Cadastros");

        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Clientes.png"))); // NOI18N
        mnClientes.setText("Clientes");
        mnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClientesActionPerformed(evt);
            }
        });
        mnCadastros.add(mnClientes);

        mnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Funcionario.PNG"))); // NOI18N
        mnUsuarios.setText("Usuários");
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        mnCadastros.add(mnUsuarios);

        mnTeste.setText("CAPTURA");
        mnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTesteActionPerformed(evt);
            }
        });
        mnCadastros.add(mnTeste);

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
            .addGap(0, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(701, 394));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClientesActionPerformed
        // TODO add your handling code here:
        mnClientes.setEnabled(false);
        objClientes = new Tela_Clientes("");
        objClientes.setVisible(true);
    }//GEN-LAST:event_mnClientesActionPerformed

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

    private void mnTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTesteActionPerformed
        mnTeste.setEnabled(false);
        objPrincipal = new Tela_Principal(mJanela);
        objPrincipal.setVisible(true);
    }//GEN-LAST:event_mnTesteActionPerformed

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
               if (pJanela.equals("Clientes")){
                   mnClientes.setEnabled(true);
                   System.out.println("Botou Visivel Clientes");
               }
               if (pJanela.equals("Usuarios")){
                   mnUsuarios.setEnabled(true);
                   System.out.println("Botou Visivel Usuarios");
               }
                if (pJanela.equals("Relatorio_OS")){
                   mnRelatorio_OS.setEnabled(true);
                   System.out.println("Botou Visivel Relatorio_OS");
               }
               if (pJanela.equals("TesteCOM")){
                   mnClientes.setEnabled(true);
                   System.out.println("Botou Visivel TesteCOM");
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenuItem mnClientes;
    private javax.swing.JMenu mnJanelas;
    private javax.swing.JMenuItem mnRelatorio_OS;
    private javax.swing.JMenu mnRelatorios;
    private javax.swing.JMenu mnSair;
    private javax.swing.JMenuItem mnSairTela;
    private javax.swing.JMenuItem mnTeste;
    private javax.swing.JMenuItem mnUsuarios;
    // End of variables declaration//GEN-END:variables

}