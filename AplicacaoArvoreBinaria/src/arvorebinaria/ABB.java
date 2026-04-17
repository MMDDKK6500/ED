package arvorebinaria;

public class ABB {
    
    private No raiz;

    public ABB() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return (this.raiz == null);
    }
    
    public boolean insert(double valor) {
        if (this.isEmpty()) {
                No tmp = new No(valor);
                this.raiz = tmp;
                return true;
        }
        
        No aux = this.raiz;
        
        No ant = null;
        
        while (aux != null) {
            if (valor > aux.getValor()) {
                ant = aux;
                aux = aux.getDireita();
            } else if (valor < aux.getValor()) {
                ant = aux;
                aux = aux.getEsquerda();
            } else {
                return false;
            }
        }
        
        No n = new No(valor);
        if (valor > ant.getValor()) {
            ant.setDireita(n);
        } else {
            ant.setEsquerda(n);
        }
        return true;
    } 
    
}
