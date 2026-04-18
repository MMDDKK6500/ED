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
 
    public void printPrecurso() {
        System.out.println("precurso: ");
        precurso(this.raiz);
        System.out.println("");
    }
    
    private void precurso(No aux) {
        System.out.printf("%.2f - ", aux.getValor());
        if (aux.getEsquerda() != null) {
            precurso(aux.getEsquerda());
        }
        if (aux.getDireita() != null){
            precurso(aux.getDireita());
        }
    }
    
    public void printIncurso() {
        System.out.println("incurso: ");
        incurso(this.raiz);
        System.out.println("");
    }
    
    private void incurso(No aux) {
        if (aux.getEsquerda() != null) {
            incurso(aux.getEsquerda());
        }
        System.out.printf("%.2f - ", aux.getValor());
        if (aux.getDireita() != null){
            incurso(aux.getDireita());
        }
    }
    
    public void printPoscurso() {
        System.out.println("incurso: ");
        poscurso(this.raiz);
        System.out.println("");
    }
    
    private void poscurso(No aux) {
        if (aux.getEsquerda() != null) {
            poscurso(aux.getEsquerda());
        }
        if (aux.getDireita() != null){
            poscurso(aux.getDireita());
        }
        System.out.printf("%.2f - ", aux.getValor());
    }
    
}
