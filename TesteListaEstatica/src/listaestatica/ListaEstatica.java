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
    
    public void inserirListaVazia(double valor) {
        this.vetor[0] = valor;
        qtd++;
    }
    
}
