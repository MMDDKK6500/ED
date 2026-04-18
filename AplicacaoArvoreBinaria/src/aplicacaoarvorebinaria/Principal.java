package aplicacaoarvorebinaria;

import arvorebinaria.ABB;

public class Principal {

    public static void main(String[] args) {
        
        ABB arvore = new ABB();
        
        arvore.insert(50);
        arvore.insert(20);
        arvore.insert(10);
        arvore.insert(100);
        arvore.insert(200);
        arvore.insert(1);
        arvore.insert(25);
        arvore.insert(8);
        arvore.insert(150);
        arvore.insert(500);
        
        arvore.printPrecurso();
        arvore.printIncurso();
        arvore.printPoscurso();
        
    }
    
}
