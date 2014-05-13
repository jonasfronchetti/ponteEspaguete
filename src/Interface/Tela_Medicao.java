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
import Ferramentas.*;
import com.sun.jna.Native;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Jonas
 */
public class Tela_Medicao extends javax.swing.JFrame {

     DLLInterface DLLInterface;
     Arduino conn = new Arduino();
    /** Creates new form Form */
    public Tela_Medicao() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMedicao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btCapturar = new javax.swing.JButton();
        txtVelocidade = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        txtPeso1 = new javax.swing.JTextField();
        lblObs1 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        btStart = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btAdicionar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btFechar1 = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtgRanking = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeEquipe = new javax.swing.JTextField();
        txtData_Criacao = new javax.swing.JFormattedTextField();
        txtTelefone_Cliente = Formatacao.getTelefone();
        jLabel5 = new javax.swing.JLabel();
        btAdicionar1 = new javax.swing.JButton();
        txtCodigoEquipe = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        getContentPane().setLayout(null);

        pnMedicao.setBorder(javax.swing.BorderFactory.createTitledBorder("Medição"));
        pnMedicao.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Porta");
        pnMedicao.add(jLabel1);
        jLabel1.setBounds(14, 19, 63, 14);

        txtPorta.setName("txtPorta"); // NOI18N
        pnMedicao.add(txtPorta);
        txtPorta.setBounds(87, 16, 56, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Velocidade");
        pnMedicao.add(jLabel2);
        jLabel2.setBounds(16, 45, 61, 14);

        btCapturar.setText("Capturar");
        btCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapturarActionPerformed(evt);
            }
        });
        pnMedicao.add(btCapturar);
        btCapturar.setBounds(179, 16, 75, 49);

        txtVelocidade.setName("txtPorta"); // NOI18N
        pnMedicao.add(txtVelocidade);
        txtVelocidade.setBounds(87, 42, 75, 20);

        lblObs.setForeground(new java.awt.Color(51, 51, 255));
        lblObs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblObs.setText("Atualmente em sexto lugar!");
        pnMedicao.add(lblObs);
        lblObs.setBounds(179, 76, 225, 14);

        txtPeso1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPeso1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPeso1.setText("10");
        txtPeso1.setName("txtPorta"); // NOI18N
        txtPeso1.setOpaque(false);
        pnMedicao.add(txtPeso1);
        txtPeso1.setBounds(129, 108, 60, 49);

        lblObs1.setForeground(new java.awt.Color(51, 51, 255));
        lblObs1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblObs1.setText("MENSAGEM DE SUCESSO!!!");
        pnMedicao.add(lblObs1);
        lblObs1.setBounds(73, 175, 346, 14);

        txtPeso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPeso.setText("60");
        txtPeso.setName("txtPorta"); // NOI18N
        pnMedicao.add(txtPeso);
        txtPeso.setBounds(260, 16, 108, 49);

        btStart.setText("INICIAR TIMER");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });
        pnMedicao.add(btStart);
        btStart.setBounds(16, 108, 107, 49);

        getContentPane().add(pnMedicao);
        pnMedicao.setBounds(10, 109, 450, 0);
        pnMedicao.getAccessibleContext().setAccessibleName("medicao");

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Confirma.png"))); // NOI18N
        btAdicionar.setText("Adicionar");
        btAdicionar.setPreferredSize(new java.awt.Dimension(77, 25));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Lapis2.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setPreferredSize(new java.awt.Dimension(77, 25));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Novo.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setPreferredSize(new java.awt.Dimension(77, 25));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btFechar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Porta.PNG"))); // NOI18N
        btFechar1.setText("Fechar");
        btFechar1.setPreferredSize(new java.awt.Dimension(77, 25));
        btFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFechar1ActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Exclui.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(77, 25));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 687, 47);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ranking em Tempo Real"));
        jPanel2.setLayout(null);

        dtgRanking.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        dtgRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtgRankingMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dtgRankingMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(dtgRanking);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(6, 16, 209, 316);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(466, 58, 0, 0);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));
        jPanel3.setLayout(null);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Equipe");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(164, 19, 45, 14);

        txtNomeEquipe.setEditable(false);
        txtNomeEquipe.setName("txtPorta"); // NOI18N
        jPanel3.add(txtNomeEquipe);
        txtNomeEquipe.setBounds(253, 16, 148, 20);

        txtData_Criacao.setEditable(false);
        jPanel3.add(txtData_Criacao);
        txtData_Criacao.setBounds(58, 16, 102, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Data");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(16, 16, 38, 20);

        btAdicionar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Confirma.png"))); // NOI18N
        btAdicionar1.setPreferredSize(new java.awt.Dimension(77, 25));
        btAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btAdicionar1);
        btAdicionar1.setBounds(407, 16, 29, 25);

        txtCodigoEquipe.setEditable(false);
        txtCodigoEquipe.setName("txtPorta"); // NOI18N
        txtCodigoEquipe.setOpaque(false);
        jPanel3.add(txtCodigoEquipe);
        txtCodigoEquipe.setBounds(213, 16, 34, 20);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 55, 450, 0);

        setSize(new java.awt.Dimension(713, 440));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapturarActionPerformed
        // TODO add your handling code here:

        conn.comunicacaoArduino(btCapturar);
        double wControle;
        int wControle2;
                
    try{
        
        wControle = DLLInterface.BalancaLider.CapturarPeso(4, 9600);
        //wControle2 = Integer.parseInt(DLLInterface.BalancaLider.CapturarPeso(4, 9600) + "");
        
        //wControle = DLLInterface.BalancaLider.CapturarPeso(Integer.parseInt(txtPorta.getText()), Integer.parseInt(txtVelocidade.getText()));
        //wControle = DLLInterface.BalancaLider.Zerar(Integer.parseInt(txtPorta.getText()), Integer.parseInt(txtVelocidade.getText()));
        txtPeso.setText(wControle + "");
    
    } catch(Exception ex){
        System.out.println("ERRO COM: " + ex.getMessage());
    }//GEN-LAST:event_btCapturarActionPerformed
    
    }
    
    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
        int wControle = 0;
        String xMensagemValidacao = "";

        xMensagemValidacao = ValidaDados();
        if (xMensagemValidacao.equals("")){
            System.out.println("Validou Dados");
            GuardaDados(true);
            System.out.println("Guardou Dados");

            wControle = ctlCliente.gravarCliente();
            if (wControle != 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente gravado com sucesso!");
                LimpaTela(true,false);
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao gravar cliente!");
            }
        } else {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erros de Validação: \n" + xMensagemValidacao);
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        int wControle = 0;
        String xMensagemValidacao = "";

        xMensagemValidacao = ValidaDados();
        if (xMensagemValidacao.equals("")){
            System.out.println("Validou Dados");

            Clientes.definirId_Cliente(Integer.parseInt(txtId_Cliente.getText()));
            //Clientes.definirNome_Cliente(txtNome_Cliente.getText());
            //Clientes.definirTelefone(txtTelefone_Cliente.getText().replace("(","").replace(")","").replace("-",""));
            GuardaDados(false);
            System.out.println("Guardou Dados");

            wControle = ctlCliente.alterarCliente();
            if (wControle != 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente alterado com sucesso!");
                LimpaTela(true,false);
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar cliente!");
            }
        } else {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erros de Validação: \n" + xMensagemValidacao);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        LimpaTela(true,false);
    }//GEN-LAST:event_btLimparActionPerformed

    private void btFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFechar1ActionPerformed
        // TODO add your handling code here:
        int wControle = 0;

        wControle = Tela_Login.objMenu.preencheJanelas("Clientes", "I");
        if (wControle != 0){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao ativar menu 'Clientes'");
        }
        dispose();
    }//GEN-LAST:event_btFechar1ActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
        int wControle = 0;

        char wChar = 'p';
        boolean wPergunta = false;

        wPergunta = CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza de que deseja excluir o Cliente?","",wChar);

        if (wPergunta == true){
            Clientes.definirId_Cliente(Integer.parseInt(txtId_Cliente.getText()));
            Clientes.definirUsuario_Exclusao(Tela_Login.objMenu.mIdUsuarioLogin);
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            formatador.format(data);
            Clientes.definirData_Exclusao(formatador.format(data));
            wControle = ctlCliente.excluirCliente();
            if (wControle != 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente excluído com sucesso!");
                LimpaTela(true,false);
            } else {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir cliente!");
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void dtgRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtgRankingMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_dtgRankingMouseClicked

    private void dtgRankingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtgRankingMousePressed
        // TODO add your handling code here:
        int wControle;
        int linhaSelecionada = dtgRanking.getSelectedRow();//pega a linha selecionada
        String coluna1 = dtgRanking.getModel().getValueAt(linhaSelecionada, 0).toString(); // Primeira coluna da linha

        if (dtgRanking.isColumnSelected(3)){
            tbpClientes.setSelectedIndex(1);
            txtNome_Cliente.requestFocus();
            btAlterar.setVisible(true);
            btExcluir.setVisible(true);
            btNovo.setVisible(true);
            btAdicionar.setVisible(false);

            ctlCliente = new Controla_Clientes(Clientes, dtgRanking);

            Clientes.definirId_Cliente(Integer.parseInt(coluna1));
            wControle = ctlCliente.buscarCliente();
            if (wControle < 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao buscar Cliente no BD!");
            } else {
                if (wControle == 0)
                TelaAlteracao();
            }
        }
    }//GEN-LAST:event_dtgRankingMousePressed

    private void btAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionar1ActionPerformed

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btStartActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Medicao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAdicionar1;
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCapturar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar1;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btStart;
    private javax.swing.JTable dtgRanking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblObs1;
    private javax.swing.JPanel pnMedicao;
    private javax.swing.JTextField txtCodigoEquipe;
    private javax.swing.JFormattedTextField txtData_Criacao;
    private javax.swing.JTextField txtNomeEquipe;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPeso1;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtVelocidade;
    // End of variables declaration//GEN-END:variables

}
