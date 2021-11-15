package SuperTrunfoDaReciclagem.temp;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class classMain {
   public static void main(String [] args) throws IOException{
       /*Baralho start = new Baralho();
       start.lerDoArquivo();
       Jogador player = new Jogador("Guilherme");
       Jogador player2 = new Jogador("Joao");
       player.incluir(start.getBaralho(1));
       player2.incluir(start.getBaralho(10));
       Carta carta = start.getBaralho(1);
       Carta carta2 = start.getBaralho(0);
       System.out.println("COR: " + carta.comparationCor(carta, carta2));
       System.out.println("ATAQUE: " + carta.comparationAtaque(carta, carta2));
       System.out.println("DECOMPOSIÇÃO: " + carta.comparationDecomp(carta, carta2));*/
       SuperTrunfoDaReciclagem trunfo = new SuperTrunfoDaReciclagem(4);
       trunfo.quatroJogadores("Guilherme", "Joao", "Pedro", "RANDOM");
       //trunfo.doisJogadores("GUILHERME", "JOAO");
       trunfo.startJogoManual();
   }
}