/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import Interface.Tela_Avaliacoes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author W7
 */
public class Cronometro extends Thread {
    private JLabel label;
    private int tempo;
    private Tela_Avaliacoes tAvalia;
    public Cronometro(JLabel label, int tempo, Tela_Avaliacoes tAvalia) {
        this.label = label;
        this.tempo = tempo;
        this.tAvalia = tAvalia;
    }

    public void run() {
        while (tempo > 0){
            label.setText(tempo+"");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            tempo --;
        }
        label.setText(tempo+"");
        tAvalia.capturaPeso();
    }

}
