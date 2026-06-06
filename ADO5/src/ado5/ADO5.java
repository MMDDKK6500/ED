package ado5;

import java.util.Random;

public class ADO5 {

    public static void main(String[] args) {
        
        Random rng = new Random();
        
        ListaDE lista = new ListaDE();
        ABB arvore = new ABB();
        
        int qtd = 100;
        
        for (int i = 0; i < qtd; i++) {
            
            int numero = rng.nextInt(0, 1000);
            
            lista.inserir(numero);
            arvore.inserir(numero);
        }
        
        System.out.println(lista.toString());  

        
        System.out.println("Árvore impressa em ordem crescente:");
        
        lista = arvore.transformarEmListaDE();
        
        System.out.println(lista);
        
    }
    
}
