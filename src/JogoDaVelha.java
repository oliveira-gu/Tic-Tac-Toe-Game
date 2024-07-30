import java.util.Arrays;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private static final char[][] DIAGONAL = {};

    public JogoDaVelha(int dimensaoTabuleiro) {
        this.tabuleiro = new char[dimensaoTabuleiro][dimensaoTabuleiro];

    }

    public boolean realizaJogada(int linha, int coluna, char caractere){

        if(tabuleiro[linha][coluna] == 0){
            tabuleiro[linha][coluna] = caractere;
        }
        else{
            return false;
        }
        return  true;
    }

    public boolean verificaGanhador(){
        int iguais = 0;

        // Verifica diagonal principal
        for(int i=0; i< tabuleiro.length; i++)
            if(tabuleiro[0][0] == tabuleiro[i][i] && tabuleiro[i][i] !=0)
                iguais++;
        if(iguais == tabuleiro.length){
            return true;
        }

        iguais = 0;
        // Verifica diagonal secundária
        for(int i=0; i< tabuleiro.length; i++){
            int coluna = tabuleiro.length -1;
            if(tabuleiro[tabuleiro.length-1][0] == tabuleiro[i][coluna - i] && tabuleiro[i][coluna - i] != 0)
                iguais++;
        }
        if(iguais == tabuleiro.length){
            return true;
        }

        // Verifica linhas
        for(int i=0; i< tabuleiro.length; i++){
            iguais = 0;
            for(int j=0; j<tabuleiro[i].length; j++){
                if(tabuleiro[i][tabuleiro.length-1] == tabuleiro[i][j] && tabuleiro[i][j] != 0)
                    iguais++;
            }
            if(iguais == tabuleiro.length){
                return true;
            }
        }

        // Verifica colunas
        for(int j=0; j<tabuleiro[0].length; j++){
            iguais = 0;
            for(int i=0; i< tabuleiro.length; i++){
                if(tabuleiro[tabuleiro.length-1][j] == tabuleiro[i][j] && tabuleiro[i][j] != 0)
                    iguais++;
            }
            if(iguais == tabuleiro.length){
                return true;
            }
        }

        return false;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public String toString() {
        String jogoTabuleiro = "";
        for(int i=0; i< tabuleiro.length; i++){
            for(int j=0; j<tabuleiro[i].length; j++){
                if(j == (tabuleiro[i].length -1))
                    jogoTabuleiro += (tabuleiro[i][j]);
                else
                    jogoTabuleiro += (tabuleiro[i][j] + " | ");
            }
            jogoTabuleiro += "\n";
        }
        return jogoTabuleiro;
    }
}
