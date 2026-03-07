package br.dev.mmddkk.testelistacircular.model.listacircular;

public class ListaCircular {
    
    private No inicio;

    public ListaCircular() {
        this.inicio = null;
    }
    
    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }
    
    public void inserirPrimeiroElemento(double valor) {
        No primeiro = new No(valor);
        
        primeiro.setAnt(primeiro);
        primeiro.setProx(primeiro);
        this.inicio = primeiro;
    }
    
    public void inserirInicioLista(double valor) {
        No aux = new No(valor);
        No anterior = this.inicio.getAnt();
        
        aux.setProx(this.inicio);
        aux.setAnt(this.inicio.getAnt());
        
        anterior.setProx(aux);
        this.inicio.setAnt(aux);
        this.inicio = aux;
    }
    
    public void inserirFimLista(double valor) {
        No aux = new No(valor);
        No anterior = this.inicio.getAnt();
        
        aux.setProx(this.inicio);
        aux.setAnt(this.inicio.getAnt());
        
        anterior.setProx(aux);
        this.inicio.setAnt(aux);
    }
    
    public void inserirMeioLista(double valor, int pos) {
        No aux = new No(valor);
        No temp = this.inicio;
        
        if (pos == this.pegarTamanho()) {
            this.inserirFimLista(valor);
            return;
        } else if (pos == 0) {
            this.inserirInicioLista(valor);
            return;
        }
        
        if (pos > this.pegarTamanho() / 2) {
            while(pos > 1) {
                temp = temp.getAnt();
                pos--;
            }
        } else {
            while(pos > 1) {
                temp = temp.getProx();
                pos--;
            }
        }
        
        aux.setAnt(temp);
        aux.setProx(temp.getProx());
        temp.setProx(aux);
        
    }
    
    public void inserir(double valor) {
        if (this.pegarTamanho() == 0) {
            inserirPrimeiroElemento(valor);
            return;
        }
        
        inserirFimLista(valor);
        
    }
    
    public void inserir(double valor, int pos) {
        if (this.pegarTamanho() == 0) {
            inserirPrimeiroElemento(valor);
            return;
        }
        
        if (pos > this.pegarTamanho()) {
            System.out.println("Erro: Posição inválida na lista!");
            return;
        }
        
        inserirMeioLista(valor, pos);
    }
    
    public int pegarTamanho() {
        if (this.inicio == null) return 0;
        No aux = this.inicio.getProx();
        int qtd = 1;
        
        while (aux != this.inicio) {
            aux = aux.getProx();
            qtd++;
        }
        
        return qtd;
    }

    @Override
    public String toString() {
        No temp = this.inicio;
        
        String dados = "";
        
        if (temp == null) {
            dados = "Lista Vazia.";
            return dados;
        }
        
        dados += temp.getValor() + " - ";
        
        temp = temp.getProx();
        
        while (temp != this.inicio) {
            dados += temp.getValor() + " - ";
            temp = temp.getProx();
        }
        
        return dados;
    }
    
    public void printLista() {
        No temp = this.inicio;
        
        if (temp == null) {
            System.out.println("Lista Vazia.");
            return;
        }
        
        System.out.println(temp.getValor() + " - ");
        
        temp = temp.getProx();
        
        while (temp != this.inicio) {
            System.out.println(temp.getValor() + " - ");
            temp = temp.getProx();
        }
    }
    
}