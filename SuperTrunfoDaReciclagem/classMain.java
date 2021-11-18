package SuperTrunfoDaReciclagem;

import java.io.IOException;
import java.util.Scanner;

public class classMain {
    public static void main(String[] args) throws IOException {
        String name1, name2, name3, name4;
        Scanner nc = new Scanner(System.in);

        int option;
        do {
            System.out.println("========================================================");
            System.out.println("=******/ Bem vindo ao Super Trunfo da Reciclagem /******=");
            System.out.println("1- Jogar de maneira automatica");
            System.out.println("2- Jogar de maneira manual");
            System.out.println("========================================================");
            System.out.println("Digite sua opção: ");
            option = nc.nextInt();
            if (option < 1 || option > 2) {
                System.out.println("OPÇÃO INVALIDA!");
            }
        } while (option < 1 || option > 2);
        if (option == 1) {
            do {
                System.out.println("Selecione a quantidade de jogadores");
                System.out.println(" 1 - 2 Jogadores");
                System.out.println(" 2 - 4 Jogadores");
                option = nc.nextInt();

                if (option < 1 || option > 2) {
                    System.out.println("OPÇÃO INVALIDA!");
                }
            } while (option < 1 || option > 2);
            if (option == 1) {
                System.out.println("Digite o nome do jogador 1 ");
                name1 = nc.next();
                System.out.println("Digite o nome do jogador 2 ");
                name2 = nc.next();
                SuperTrunfoDaReciclagem superTrunfoDaReciclagem = new SuperTrunfoDaReciclagem(2);
                superTrunfoDaReciclagem.doisJogadores(name1, name2);
                superTrunfoDaReciclagem.startJogoAutomatic();
            } else {
                System.out.println("Digite o nome do jogador 1 ");
                name1 = nc.next();
                System.out.println("Digite o nome do jogador 2 ");
                name2 = nc.next();
                System.out.println("Digite o nome do jogador 3 ");
                name3 = nc.next();
                System.out.println("Digite o nome do jogador 4 ");
                name4 = nc.next();
                SuperTrunfoDaReciclagem superTrunfoDaReciclagem4 = new SuperTrunfoDaReciclagem(4);
                superTrunfoDaReciclagem4.quatroJogadores(name1, name2, name3, name4);
                superTrunfoDaReciclagem4.startJogoAutomatic();
            }
        } else {
            do {
                System.out.println("Selecione a quantidade de jogadores");
                System.out.println(" 1 - 2 Jogadores");
                System.out.println(" 2 - 4 Jogadores");
                option = nc.nextInt();
                if (option < 1 || option > 2) {
                    System.out.println("OPÇÃO INVALIDA!");
                }
            } while (option < 1 || option > 2);
            if (option == 1) {
                System.out.println("Digite o nome do jogador 1 ");
                name1 = nc.next();
                System.out.println("Digite o nome do jogador 2 ");
                name2 = nc.next();
                SuperTrunfoDaReciclagem superTrunfoDaReciclagem = new SuperTrunfoDaReciclagem(2);
                superTrunfoDaReciclagem.doisJogadores(name1, name2);
                superTrunfoDaReciclagem.startJogoManual();
            } else {
                System.out.println("Digite o nome do jogador 1 ");
                name1 = nc.next();
                System.out.println("Digite o nome do jogador 2 ");
                name2 = nc.next();
                System.out.println("Digite o nome do jogador 3 ");
                name3 = nc.next();
                System.out.println("Digite o nome do jogador 4 ");
                name4 = nc.next();
                SuperTrunfoDaReciclagem superTrunfoDaReciclagem4 = new SuperTrunfoDaReciclagem(4);
                superTrunfoDaReciclagem4.quatroJogadores(name1, name2, name3, name4);
                superTrunfoDaReciclagem4.startJogoManual();
            }

        }

    }
}

