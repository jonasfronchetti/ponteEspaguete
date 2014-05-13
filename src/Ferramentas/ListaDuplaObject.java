/*
 * ListaDuplaObject.java
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
public class ListaDuplaObject
{
     private NodoDuploObject header;  // guarda o ponteiro do primeiro nodo da lista
     private NodoDuploObject trailer; // guarda o ponteiro do �ltimo nodo da lista
     private int tamanho;          // guarda o n�mero de nodos da lista
     
     public ListaDuplaObject()
     {
          // cria os nodos header e trailer
          header = new NodoDuploObject(null, null, null);
          trailer = new NodoDuploObject(null, null, null);
          
          // aponta o nodo header para o trailer
          header.atribuirproximo( trailer );
          
          // aponta o nodo trailer para o header
          trailer.atribuirAnterior( header );
          
          // inicializa o tamanho com zero
          tamanho = 0;
     }
     
     // retorna a refer�ncia do primeiro nodo da lista
     private NodoDuploObject obterInicio() 
     {
          return (header.obterproximo());
     }
     
     // retorna a refer�ncia do �ltimo nodo da lista
     private NodoDuploObject obterFim()
     {
          return (trailer.obterAnterior());
     }
     
     // retorna verdadeiro quando a lista est� vazia
     private boolean estaVazia()
     {
          return (tamanho == 0);
     }
     
     // inserir um novo nodo depois do "nodo" 
     private void inserirNodo( NodoDuploObject nodo, Object valor )
     {
          // guarda a refer�ncia do nodo que vem depois do "nodo"
          NodoDuploObject proximo = nodo.obterproximo();
          
          // cria um novo nodo com o conte�do e seus apontadores
          NodoDuploObject novoNodo = new NodoDuploObject( nodo, valor, proximo );
          
          // atualiza o apontador de proximo do "nodo", fazendo com que aponte para o novo nodo
          nodo.atribuirproximo( novoNodo );
          
          // atualiza o apontador de anterior do "proximo", fazendo com que aponte para o novo nodo
          proximo.atribuirAnterior( novoNodo );
          
          // incrementa o tamanho
          tamanho ++;
     }
     
     // retirar o nodo referenciado na vari�vel "nodo"
     private Object retirarNodo( NodoDuploObject nodo )
     {
          // guarda a refer�ncia do nodo que vem depois do "nodo"
          NodoDuploObject proximo = nodo.obterproximo();
          
          // guarda a refer�ncia do nodo que vem antes do "nodo"
          NodoDuploObject anterior =  nodo.obterAnterior();
          
          // atualiza o apontador de proximo do nodo "anterior"
          anterior.atribuirproximo( proximo );
          
          // atualiza o apontador de anterior do nodo "proximo"
          proximo.atribuirAnterior( anterior );
          
          // decrementa o tamanho
          tamanho --;
          
          // retorna o campo valor do "nodo"
          return ( nodo.obterValor() );
     }
     
     // procura e retorna a refer�ncia do nodo que contem o "valor"
     private NodoDuploObject procurarNodo( Object valor )
     {
          // vari�vel auxiliar que recebe verdadeiro quando o "valor" for localizado
          boolean sucesso = false;
          
          // inicializa a vari�vel "temp" com a refer�ncia do header
          NodoDuploObject temp = header;
          
          // verifica se o nodo atual n�o est� apontando para o trailer, ou seja,
          // se o nodo atual n�o � o �ltimo. Se a lista estiver vazia n�o executa a repeti��o.
          while (temp.obterproximo() != trailer && !sucesso)
          {
               // avan�a para o proximo nodo
               temp = temp.obterproximo();
               
               // verifica se o campo valor do nodo � igual ao "valor" procurado
               if (temp.obterValor().toString().equals( valor.toString() ))
               {
                    sucesso = true;
               }
          }
          
          if (!sucesso) // se n�o obteve sucesso
          {
               // atribui nulo para a vari�vel temp a fim de retornar nulo
               temp = null;
          }
          
          // retorna a refer�ncia do nodo que contem o "valor"
          return (temp);
     }
     
     
     // insere um nodo com o "novoValor" no in�cio da lista
     public void inserirInicio( Object novoValor )
     {    
          // inserir um novo nodo depois do header
          inserirNodo( header, novoValor );
     }
     
     // retira o nodo que est� no in�cio da lista, 
     // retornando o seu valor ou retornando -1 quando a lista est� vazia
     public Object retirarInicio()
     {
          Object valorRetirado = null;
          if (!estaVazia())
          {
               // retira o nodo que est� referenciado por "obterInicio()"
               valorRetirado = retirarNodo( obterInicio() );
          }
          return (valorRetirado);
     }
     
     // insere um nodo com o "novoValor" no final da lista
     public void inserirFim( Object novoValor )
     {
          // inserir um novo nodo depois o �ltimo nodo
          inserirNodo( obterFim(), novoValor );
     }
     
     // retira o nodo que est� no final da lista, 
     // retornando o seu valor ou retornando -1 quando a lista est� vazia
     public Object retirarFim()
     {
          Object valorRetirado = null;
          if (!estaVazia())
          {
               // retira o nodo referenciado por "obterFim()" e guarda o valor em "valorRetirado"
               valorRetirado = retirarNodo( obterFim() );
          }
          return (valorRetirado);
     }
     
     // insere um nodo com o "novoValor" ap�s um nodo existente que contem o "valor"
     public boolean inserirApos( Object valor, Object novoValor )
     {
          // procura a refer�ncia do nodo que contem o "valor"
          NodoDuploObject nodo = procurarNodo( valor );
          
          if (nodo != null) // se encontrou o "valor" realiza a inser��o
          {
               // inserir um novo nodo depois do "nodo"
               inserirNodo( nodo, novoValor );
          }
          
          return (nodo != null); // verdadeiro se encontrou o "valor", falso quando n�o encontrou o "valor"
     }
     
     // retira o nodo que contem o "valor"
     // retorna o seu valor ou retorna -1 quando n�o obteve sucesso
     public Object retirarNodo( Object valor )
     {
          Object valorRetirado = null;
          
          // procura a refer�ncia do nodo que contem o "valor"
          NodoDuploObject nodo = procurarNodo( valor );
          
          if (nodo != null) // se encontrou o "valor" realiza a retirada. Se alista estiver vazia "nodo" ser� nulo.
          {
               // retira o nodo referenciado por "nodo" e guarda o valor em "valorRetirado"
               valorRetirado = retirarNodo( nodo );
          }
          return (valorRetirado);
     }
     
     // retorna o tamanho da lista, ou seja, n�mero de elementos da lista
     public int obterTamanho()
     {
          return (tamanho);
     }
     
     // retorna um vetor com os elementos da lista
     public Object[] obterElementos()
     {
          // gera um vetor com os elementos da lista
          Object[] elementos = new Object[ tamanho ];
          NodoDuploObject temp = obterInicio();
          for (int i=0; i < tamanho; i++)
          { 
               elementos[i] = temp.obterValor();
               temp = temp.obterproximo();
          }
          
          // retorna o vetor elementos
          return (elementos);
     }
     
     // retorna o valor do �ltimo nodo da lista ou retorna -1 se lista vazia
     public Object obterultimo()
     {
          Object retorno = null;
          if (!estaVazia())
          {
               retorno = obterFim().obterValor();
          }
          return (retorno);
     }
     
     // retorna o valor do primeiro nodo da lista ou retorna -1 se lista vazia
     public Object obterPrimeiro()
     {
          Object retorno = null;
          if (!estaVazia())
          {
               retorno = obterInicio().obterValor();
          }
          return (retorno);
     }
     
     public boolean contem( Object valor ) {
        NodoDuploObject nodo = procurarNodo( valor );
        return (nodo != null); // verdadeiro se encontrou o "valor", falso quando n�o encontrou o "valor"
     }
}