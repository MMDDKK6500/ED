package br.dev.mmddkk.testelistacircular.view;

import br.dev.mmddkk.testelistacircular.model.listacircular.*;

public class TesteListaCircular {

    public static void main(String[] args) {
        
        ListaCircular lista = new ListaCircular();
        
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        
        System.out.println(lista.toString());
        
        lista.inserir(100, 1);
        System.out.println(lista.toString());
        
//        lista.removerPrimeiroLista();
//        lista.removerPrimeiroLista();
        
        System.out.println(lista.toString());
        
    }
    
}
