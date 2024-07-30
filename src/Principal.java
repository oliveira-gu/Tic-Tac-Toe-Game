// Desenvolvido por Gustavo de Oliveira

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        // Criando um objeto Scanner para ler entrada do teclado
        Scanner teclado = new Scanner(System.in);

        // Solicitando ao usuário que insira os nomes dos objetos
        System.out.print("Insira o nome do primeiro jogador: ");
        String jogadorUm = teclado.nextLine();
        Jogador primeiroJogador = new Jogador(jogadorUm);

        System.out.print("Insira o nome do segundo jogador: ");
        String jogadorDois = teclado.nextLine();
        Jogador segundoJogador = new Jogador(jogadorDois);

        int opcao =1;

        while (opcao == 1){

            // Solicita ao usuário o tamanho do tabuleiro
            System.out.print("Insira a dimensão do tabuleiro: ");
            int dimensaoTabuleiro = teclado.nextInt();
            JogoDaVelha tabuleiro = new JogoDaVelha(dimensaoTabuleiro);

            System.out.println("\nVisualizção do Tabuleiro");
            System.out.println(tabuleiro.toString());

            boolean fechou = false;
            boolean empate = false;
            int jogada = 0;

            while(!fechou){ // enquanto algum jogador não vencer ou empatar, continuará rodando

                // Se a jogada for impar, o primeiro jogador joga
                if(jogada % 2 == 0){
                    desenvolveJogo(primeiroJogador.getNome(), 'X', tabuleiro);
                    fechou = tabuleiro.verificaGanhador();
                }
                else{ // Se a jogada for par, o segundo jogador joga
                    desenvolveJogo(segundoJogador.getNome(), 'O', tabuleiro);
                    fechou = tabuleiro.verificaGanhador();

                }
                jogada++;
                if(jogada == dimensaoTabuleiro * dimensaoTabuleiro){ // Se o número de jogadas for igual ao tamanho do tabuleiro e não encontramos ganhador, sinal de que temos um empate
                    empate = true;
                    fechou = true;
                }
                System.out.println(tabuleiro.toString());
                System.out.println("----------------------------------");
            }

            // Imprime quem ganhou
            System.out.println("=========== FIM DE JOGO ===========");
            if(empate){
                // Se empatou o jogo não é necessário imprimir o vencedor
                System.out.println("Parece que temos um empate, tente novamente!");
            }
            else{
                if(jogada % 2 == 1){
                    System.out.println(jogadorUm + ", ganhou o jogo!");
                    primeiroJogador.setPontos(primeiroJogador.getPontos() +1);
                }
                else {
                    System.out.println(jogadorDois + ", ganhou o jogo!");
                    segundoJogador.setPontos(segundoJogador.getPontos() +1);
                }
            }
            System.out.println("=========== FIM DE JOGO ===========");

            // Menu de opções
            System.out.println("Menu\n1 - Jogar novamente\n2 - Ver pontuação\n3 - Finalizar o jogo");
            opcao = teclado.nextInt();

            if(opcao == 2){
                System.out.println("\n----------------------------------");
                System.out.println(primeiroJogador.toString());
                System.out.println();
                System.out.println(segundoJogador.toString());
                System.out.println("----------------------------------\n");
                System.out.println("Menu\n1 - Jogar novamente\n2 - Ver pontuação\n3 - Finalizar o jogo");
                opcao = teclado.nextInt();
                if (opcao == 2)
                    System.out.println("Obrigado por jogar");
            } else if (opcao == 3)
                try{
                    File arquivo = new File("Resultado.txt");
                    FileWriter escritaArquivo = new FileWriter(arquivo);
                    PrintWriter escrita = new PrintWriter(escritaArquivo);
                    escrita.println("\n----------------------------------");
                    escrita.println(primeiroJogador.toString());
                    escrita.println();
                    escrita.println(segundoJogador.toString());
                    escrita.println("\n----------------------------------");
                    escrita.close();
                }catch (IOException e){
                    System.out.println("Erro ao escrever arquivo.");
                }
                System.out.println("Até a próxima!");
        }
        teclado.close();

    }

    public static void desenvolveJogo(String nome, char caractere, JogoDaVelha tabuleiro){
        Scanner tecladoUm = new Scanner(System.in);

        System.out.println(nome + ", escolha a sua posição de jogada: ");
        System.out.print("Linha: ");
        int linha = tecladoUm.nextInt();
        System.out.print("Coluna: ");
        int coluna = tecladoUm.nextInt();
        boolean jogada = tabuleiro.realizaJogada(linha, coluna, caractere);
        while (!jogada){

            System.out.println("ATENÇÃO! " + nome + ", escolha uma posição que não esteja ocupada");
            System.out.print("Linha: ");
            int linhaDois = tecladoUm.nextInt();
            System.out.print("Coluna: ");
            int colunaDois = tecladoUm.nextInt();
            jogada = tabuleiro.realizaJogada(linhaDois, colunaDois, caractere);
            tecladoUm.close();
        }


    }

}