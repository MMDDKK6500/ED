// João Duque Nardelli Wandermuren
// Aline Sousa Rezende

package br.dev.mmddkk.djikstra;

import java.util.ArrayList;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {
        
        // Prof, colocar todo aquele grafo que você fez, e eu lembro de você falar q esse aqui ta ok
        // pfvr nn mata agente
        
        No[] grafo = new No[4];
        
        No A = new No("A");
        No B = new No("B");
        No C = new No("C");
        No D = new No("D");
        
        A.conectar(B, 10);
        A.conectar(D, 5);
        
        B.conectar(C, 2);
        B.conectar(B, 2);
        B.conectar(D, 4);
        
        C.conectar(A, 1);
        
        D.conectar(B, 6);
        D.conectar(C, 2);
        
        grafo[0] = A;
        grafo[1] = B;
        grafo[2] = C;
        grafo[3] = D;
                
        // Buscando caminho do nó A (índice 0) para o nó B (índice 1)
        dijkstra(grafo, 0, 2);
    }
    
    public static void dijkstra(No[] grafo, int origem, int destino) {
        No noOrigem = grafo[origem];
        No noDestino = grafo[destino];

        ArrayList<No> naoVisitados = new ArrayList<>();
        
        //não visitamos nenhum nó ainda
        for (No no : grafo) {
            naoVisitados.add(no);
        }
        
        // o valor de ir pro mesmo né é 0
        noOrigem.distancia = 0;
        
        
        // enquanto ainda tem nenhum nó que testamos
        while (!naoVisitados.isEmpty()) {
            // Encontra o nó não visitado com a menor distância atual
            No atual = null;
            int menorDistancia = Integer.MAX_VALUE;
            
            for (No no : naoVisitados) {
                if (no.distancia < menorDistancia) {
                    menorDistancia = no.distancia;
                    atual = no;
                }
            }

            //chegar no destino ou desitir por não haver caminho
            if (atual == null || atual == noDestino) {
                break;
            }
            
            //Dizer que já visitamos o nó atual
            naoVisitados.remove(atual);

            // bater na porta dos vizinhos pels aarestas(ruas) "indo" do nó atual
            for (Aresta aresta : atual.indo) {
                No vizinho = aresta.destino;
                
                // não incomoda o vizinho se já batemos na porta dele (ele vai matar agente se fizermos isso)
                if (naoVisitados.contains(vizinho)) {
                    int novaDistancia = atual.distancia + aresta.peso;
                    
                    // mas se o vizinho for legal a gente convida ele pra ser a melhor alternativa
                    if (novaDistancia < vizinho.distancia) {
                        vizinho.distancia = novaDistancia;
                        vizinho.anterior = atual; 
                    }
                }
            }
        }

        // se não tiver caminho meio q ferrou tudo né
        if (noDestino.distancia == Integer.MAX_VALUE) {
            System.out.println("Não há caminho do nó " + noOrigem.nome + " para o nó " + noDestino.nome);
            return;
        }

        ArrayList<No> caminho = new ArrayList<>();
        No passoAtual = noDestino;
        
        //criar caminho mesmo, utilizando o Nó de destino e o atributo de anterior para ver
        while (passoAtual != null) {
            caminho.add(passoAtual);
            passoAtual = passoAtual.anterior;
        }
        
        //Inverter 
        Collections.reverse(caminho);

        //mostrar resultado no console
        System.out.print("Caminho: ");
        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i).nome + "(" + caminho.get(i).distancia + ")");
            if (i < caminho.size() - 1) {
                System.out.print(" -> ");
            }
        }
        
        //Completou yipee
        System.out.println("\nCusto final: " + noDestino.distancia);
    }
}

// vizinhos
class No {
    public String nome;
    public ArrayList<Aresta> indo = new ArrayList<>();
    public ArrayList<Aresta> vindo = new ArrayList<>();
    
    //Valor que é preenchido durante o método, que é o custo desse nó até a origem.
    public int distancia = Integer.MAX_VALUE;
    //Da onde essse custo é pego.
    public No anterior = null;

    public No(String nome) {
        this.nome = nome;
    }
    
    // Código simples para conectar os nós com arestas
    public void conectar(No destino, int peso) {
        Aresta temp = new Aresta(destino, peso);
        indo.add(temp);
        
        Aresta temp2 = new Aresta(this, peso);
        destino.vindo.add(temp2);
    }
}

//rua
class Aresta {
    public No destino;
    public int peso;
    
    public Aresta(No destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}