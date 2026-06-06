package ado5;

public class ListaDE {
    
    private No inicio;
    private No fim;

    public ListaDE() {
        this.inicio = null;
        this.fim = null;
    }
    
    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }
    
    public No getFim() {
        return fim;
    }
    
    public void setFim(No fim) {
        this.fim = fim;
    }
    
    public void inserirPrimeiroElemento(double valor) {
        No primeiro = new No(valor);
        
        this.inicio = primeiro;
        this.fim = primeiro;
    }
    
    public void inserirInicioLista(double valor) {
        No aux = new No(valor);
//        No anterior = this.inicio.getEsquerda();
        
        aux.setDireita(this.inicio);
//        aux.setEsquerda(this.inicio.getEsquerda());
        
        this.inicio.setEsquerda(aux);
        this.inicio = aux;
    }
    
    public void inserirFimLista(double valor) {
        No aux = new No(valor);
        
        aux.setEsquerda(this.fim);
        
        this.fim.setDireita(aux);
        this.fim = aux;
        
    }
    
    public void inserirMeioLista(double valor, int pos) {
        if (pos <= 0) {
            this.inserirInicioLista(valor);
            return;
        } else if (pos >= this.pegarTamanho()) {
            this.inserirFimLista(valor);
            return;
        }
        
        No aux = new No(valor);
        No temp = this.inicio;
        
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.getDireita();
        }
        
        No proximo = temp.getDireita();
        
        aux.setEsquerda(temp);
        aux.setDireita(proximo);
        
        temp.setDireita(aux);
        proximo.setEsquerda(aux);
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
    
    
    // Remoções
    public void removerPrimeiroLista() {    
        if (this.inicio == null) return;

        if (this.inicio == this.fim) {
            this.inicio = null;
            this.fim = null;
        } else { // Se tem mais de 1
            this.inicio = this.inicio.getDireita();
            this.inicio.setEsquerda(null); 
        }
    }
    
    public void removerFimLista() {
        if (this.fim == null) return;

        if (this.inicio == this.fim) {
            this.inicio = null;
            this.fim = null;
        } else { // Se tem mais de 1
            No anterior = this.fim.getEsquerda();
            anterior.setDireita(null);
            this.fim = anterior;
        }
    }
    
    public void removerMeioLista(int pos) {
//        int tamanho = this.pegarTamanho();
        
        No atual = this.inicio;
        for (int i = 0; i < pos; i++) {
            atual = atual.getDireita();
        }

        No anterior = atual.getEsquerda();
        No proximo = atual.getDireita();
        
        anterior.setDireita(proximo);
        proximo.setEsquerda(anterior);

        atual.setEsquerda(null);
        atual.setDireita(null);
    }
    
    public void remover(int pos) {
        int tamanho = this.pegarTamanho();
        
        if (pos < 0 || pos >= tamanho) {
            System.out.println("Erro: Posição inválida na lista!");
            return;
        }

        if (pos == 0) {
            this.removerPrimeiroLista();
            return;
        }

        if (pos == tamanho - 1) {
            this.removerFimLista();
            return;
        }
        
        this.removerMeioLista(pos);

    }
    
    public int pegarTamanho() {
        if (this.inicio == null) return 0;
        No aux = this.inicio.getDireita();
        int qtd = 1;
        
        while (aux != null) {
            aux = aux.getDireita();
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
        
        temp = temp.getDireita();
        
        while (temp != null) {
            dados += temp.getValor() + " - ";
            temp = temp.getDireita();
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
        
        temp = temp.getDireita();
        
        while (temp != null) {
            System.out.println(temp.getValor() + " - ");
            temp = temp.getDireita();
        }
    }
    
}