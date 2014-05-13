package Ferramentas;
/*
 * SwingTools.java
 *
 * Created on 26 de Maio de 2007, 16:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

/**
 * Um conjunto de ferramentas para trabalhar com aplica��es GUI
 * @author Mouriac
 */
public class SwingTools {
    
    final private static int WINDOWS = 0;
    final private static int WINDOWS_CLASSIC = 1;
    final private static int MOTIF = 2;
    final private static int METAL = 3;
    
    private static SwingTools instancia = new SwingTools();
    
    /** Creates a new instance of SwingTools */
    private SwingTools() {
    }
    
    /**
     * Retorna uma instancia da classe SwingTools
     * @return uma instancia de SwingTools
     */
    public static SwingTools obterinstancia() {
        return (instancia);
    }
    
    /**
     * Seleciona o padr�o de visualiza��o da interface GUI
     * @param tipo um inteiro WINDOWS, WINDOWS_CLASSIC, MOTIF ou METAL
     */
    public void selecionarInterface( int tipo ) {
        String[] newLookAndFeel = { "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
        "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
        "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
        "javax.swing.plaf.metal.MetalLookAndFeel" };
        
        tipo = tipo < 0 || tipo > 3 ? 3 : tipo;
        
        try {
            UIManager.setLookAndFeel( newLookAndFeel[ tipo ] );
        } catch (Exception e) { }
    }
    
    /**
     * Retorna um vetor com a resolu��o do v�deo
     * @return um vetor com largura e altura do v�deo em n�mero de pixels
     */
    
}