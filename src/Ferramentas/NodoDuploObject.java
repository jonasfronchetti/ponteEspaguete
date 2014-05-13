/*
 * NodoDuploObject.java
 *
 * Created on 2 de Junho de 2007, 15:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Ferramentas;

/**
 *
 * @author diogo
 */
public class NodoDuploObject
{
     private NodoDuploObject anterior;
     private Object valor;
     private NodoDuploObject proximo;
        
     public NodoDuploObject( NodoDuploObject nodoAnterior, Object valorInicial, NodoDuploObject proximoNodo )
     {
          anterior = nodoAnterior;
          valor = valorInicial;
          proximo = proximoNodo;
     }
     
     public void atribuirValor( Object novoValor )
     {
          valor = novoValor;
     }
     
     public void atribuirproximo( NodoDuploObject proximoNodo )
     {
          proximo = proximoNodo;
     }
     
     public void atribuirAnterior( NodoDuploObject nodoAnterior )
     {
          anterior = nodoAnterior;
     }
     
     public Object obterValor()
     {
          return (valor);
     }
     
     public NodoDuploObject obterproximo()
     {
          return (proximo);
     }
     
     public NodoDuploObject obterAnterior()
     {
          return (anterior);
     }
     
}