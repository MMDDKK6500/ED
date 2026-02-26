package br.dev.mmddkk.testelistaestatica;

import br.dev.mmddkk.listaestatica.ListaEstatica;

public class Principal {

    public static void main(String[] args) {
        
        ListaEstatica lista = new ListaEstatica(10);
        
        
        System.out.println(lista.printVetor());
        System.out.println(lista.printLista());
        
        lista.inserir(200);
        lista.inserir(300);
        lista.inserir(400);
        
        System.out.println(lista.printVetor());
        System.out.println(lista.printLista());        
        
        lista.remover(4);
        
        System.out.println(lista.printVetor());
        System.out.println(lista.printLista());        
        
    }
    
}
