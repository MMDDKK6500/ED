package ado5;

public class ABB {

    private No raiz;

    public ABB() {
        this.raiz = null;
    }

    public void inserir(double valor) {
        this.raiz = inserirRecursivo(this.raiz, valor);
    }

    private No inserirRecursivo(No atual, double valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.getValor()) {
            
            //recursividade doida
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), valor));
            
        } else if (valor > atual.getValor()) {
            
            atual.setDireita(inserirRecursivo(atual.getDireita(), valor));
            
        } else {
            return atual; 
        }

        return atual;
    }

    public void imprimirEmOrdem() {
        if (this.raiz == null) {
            System.out.println("Árvore Vazia.");
            return;
        }
        percorrerEmOrdem(this.raiz);
        System.out.println();
    }

    private void percorrerEmOrdem(No atual) {
        if (atual != null) {
            percorrerEmOrdem(atual.getEsquerda());
            System.out.print(atual.getValor() + " - ");
            percorrerEmOrdem(atual.getDireita());
        }
    }
    
    public ListaDE transformarEmListaDE() {
        ListaDE listaOrdenada = new ListaDE();
        
        preencherListaEmOrdem(this.raiz, listaOrdenada);
        
        return listaOrdenada;
    }

    // Método privado recursivo
    private void preencherListaEmOrdem(No atual, ListaDE lista) {
        if (atual != null) {
            preencherListaEmOrdem(atual.getEsquerda(), lista);
            
            lista.inserir(atual.getValor()); 
            
            preencherListaEmOrdem(atual.getDireita(), lista);
        }
    }
}