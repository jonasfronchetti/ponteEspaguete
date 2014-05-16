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

import Modelo.ConexaoBD;
import Modelo.Login;
import Ferramentas.CaixaDeDialogo;
import Modelo.CriaTabelaBanco;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Jonas
 */
public class Tela_Login extends javax.swing.JFrame {

    public static Connection con;
    public static Statement stmt;
    public static Menu objMenu;
    Login objLoginImplem = new Login();

    /** Creates new form Form */
    public Tela_Login() {
        abreConexao();
        initComponents();

    }

        private void abreConexao() {
         try {
            con = ConexaoBD.getInstance().getConnection();
            stmt = con.createStatement();
            System.out.print("Conexão com Banco de Dados Criada!");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btLogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Login");

        txtLogin.setName("txtLogin"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha");

        txtSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btLogar.setText("Logar");
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLoginLayout = new javax.swing.GroupLayout(pnLogin);
        pnLogin.setLayout(pnLoginLayout);
        pnLoginLayout.setHorizontalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSenha, 0, 1, Short.MAX_VALUE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btLogar)
                .addContainerGap())
        );
        pnLoginLayout.setVerticalGroup(
            pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLogar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(pnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        setSize(new java.awt.Dimension(288, 182));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        
        if ( new File("ponte.db").length() == 0){
            CriaTabelaBanco a = new CriaTabelaBanco();
            a.criaTabelaUsuario();
            a.criaTabelaEquipes();
            a.criaTabelaAvaliacoes();
            a.criaTabelaAvaliacoesEquipe();
            a.criaUsuarioPadrao();
        }
        // TODO add your handling code here:
        int wControle = 0;

        wControle = objLoginImplem.buscarUsuario(txtLogin.getText(), txtSenha.getText());
        System.out.println(wControle);
        if (wControle != 0)
            CaixaDeDialogo.obterinstancia().exibirMensagem("Login Inválido!");
        else{
            objMenu = new Menu();
            objMenu.mIdUsuarioLogin = objLoginImplem.obterId_Usuario();
            objMenu.mLoginUsuario = objLoginImplem.obterNome_Usuario();
            objMenu.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btLogarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
