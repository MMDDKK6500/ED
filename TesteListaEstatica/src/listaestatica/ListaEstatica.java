package listaestatica;

public class ListaEstatica {
    
    private int tamanhoMaximo;    
    private double[] vetor;
    private int qtd;
    
    public ListaEstatica(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.vetor = new double[tamanhoMaximo];
        this.qtd = 0;
    }
    
    // Retornar todos os valores do vetor
    public String printVetor() {
        String temp = "";
        
        for(double d : this.vetor) {
            temp += Double.toString(d) + " - ";
        }
        return temp;
    }
    
    //Retornar tamanho da lista
    public int tamanhoLista() {
        return this.qtd;
    }
    
    // Lista está vazia?
    public boolean eVazia() {
        return (tamanhoLista() == 0);
    }
    
    // Retornar todos os valores da lista
    public String printLista() {
        String temp = "";
        
        for (int i = 0; i < tamanhoLista(); i++) {
            temp += Double.toString(this.vetor[i]) + " - ";
        }
        return temp;
    }
    
    // Insrir em lista vazia
    private void inserirListaVazia(double valor) {
        this.vetor[0] = valor;
        qtd++;
    }
    
    // Inserir no fim da lista
    private void inserirFimLista(double valor) {
        this.vetor[this.qtd] = valor;
        this.qtd++;
    }
    
    // Fiz sem o prof ???
    private void inserirInicioLista(double valor) {
        for(int i = this.qtd; i >= 0; i--) {
            this.vetor[i + 1] = this.vetor[i];
        }
        this.vetor[0] = valor;
        qtd++;
    }
    
    // Feito com base no inserirInicioLista
    private void inserirMeioLista(double valor, int pos) {
        for(int i = this.qtd; i >= pos; i--) {
            this.vetor[i + 1] = this.vetor[i];
        }
        this.vetor[pos] = valor;
        qtd++;
    }
    
    
    public boolean inserir(double valor) {
        if (eVazia()) {
            inserirListaVazia(valor);
        } else {
            inserirFimLista(valor);
        }
        return true;
    }
    
    public boolean inserir(double valor, int pos) {
        if (pos < 0) return false;
        if (eVazia() && pos > 0) return false;
        if (eVazia() && pos == 0) inserirListaVazia(valor);
        if (pos == 0) inserirInicioLista(valor);
        if (pos == tamanhoLista()) {
            inserirFimLista(valor);
            return true;
        }
        inserirMeioLista(valor, pos);
        return true;
    }

}
