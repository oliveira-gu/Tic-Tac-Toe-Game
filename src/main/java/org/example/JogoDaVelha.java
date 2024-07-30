package org.example;

import java.util.Arrays;

public class JogoDaVelha {
    private String[][] tabuleiro;

   public JogoDaVelha(int dimensaoTabuleiro){
       this.tabuleiro = new String[dimensaoTabuleiro][dimensaoTabuleiro];
   }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String toString() {
        return "JogoDaVelha{" +
                "tabuleiro=" + Arrays.toString(tabuleiro) +
                '}';
    }
}
