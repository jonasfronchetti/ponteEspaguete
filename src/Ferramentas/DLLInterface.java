/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ferramentas;

/**
 *
 * @author Jonas
 */
import com.sun.jna.Library;
import com.sun.jna.Native;

public interface DLLInterface extends Library{ 

public static DLLInterface BalancaLider = (DLLInterface)Native.loadLibrary("BalancaLider.dll", DLLInterface.class);
        
double CapturarPeso(int Porta, int Velocidade);  

double Zerar(int Porta, int Velocidade);  
              
}


	

