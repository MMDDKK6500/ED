package testelistaestatica;

import listaestatica.ListaEstatica;

public class Principal {

    public static void main(String[] args) {
        
        ListaEstatica lista = new ListaEstatica(10);
        
        lista.inserirListaVazia(150);
        lista.inserirFimLista(300);
        lista.inserirInicioLista(200);
        
        System.out.println(lista.printVetor());
        System.out.println(lista.printLista());
        
    }
    
}
