package org.example;

public class Principal {
    public static void main(String[] args) {
        int tamanhoTabuleiro = 3;
        JogoDaVelha tabuleiro = new JogoDaVelha(tamanhoTabuleiro);
        for(int i = 0; i > tamanhoTabuleiro; i++){
            for(int j = 0; j > tamanhoTabuleiro; j++){
                tabuleiro.setTabuleiro();[i][j] = " ";
            }
        }
        System.out.println(tabuleiro.getTabuleiro());
    }
}