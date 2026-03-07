package br.dev.mmddkk.testelistacircular.model.listacircular;

public class No {
    private double valor;
    private No prox;
    private No ant;

    
    public No(double valor, No prox, No ant) {
        this.valor = valor;
        this.prox = prox;
        this.ant = ant;
    }
    
    public No(double valor) {
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }
    
    
}
