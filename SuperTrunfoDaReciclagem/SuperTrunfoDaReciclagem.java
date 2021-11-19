package SuperTrunfoDaReciclagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SuperTrunfoDaReciclagem {

    private int empate;
    private Carta carta;
    private Carta card;
    private String name1, name2, name3, name4;
    private Random random = new Random();
    private int[] iVector = new int[32];
    private int i = 0, aux, aux2, counter = 0, counterSecond = 1, countertree = 2, counterfor = 3, trade = 0, round = 0, verify = 0, secondwinner_round;
    private int option, size, retorno;
    private final List<Jogador> list = new ArrayList<>();
    private final List<Integer> number = new ArrayList<>();
    private final List<Carta> monte = new ArrayList<>();
    private final Baralho distribution = new Baralho();
    private int qntJogadores, rodada = 0, winner_round;

    //Metodo construtor
    public SuperTrunfoDaReciclagem(int qntJogadores) {
        this.qntJogadores = qntJogadores;
        for (i = 0; i < 32; i++) {
            aux = random.nextInt(32);
            while (number.contains(aux)) {
                aux = random.nextInt(32);
            }
            number.add(aux);
        }
        distribution.lerDoArquivo();

        for (i = 0; i < 32; i++) {
            iVector[i] = number.get(i) + 1;
        }
    }

    //Metodos especiais
    public void startJogoAutomatic() throws IOException {
        if (getQntJogadores() == 2) {
            counter = getRandom(1);
            counterSecond = counter + 1;
            if (counterSecond == counter) {
                if (counterSecond == 2) {
                    counterSecond = 0;
                }
            }
            do {

                round++;
                aux = random.nextInt(3);
                aux++;
                aux2 = comparationCards(aux, counter, counterSecond);
                if (aux2 == -1) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        distributionMonte(counterSecond);
                    }
                    trade = counter;
                    counter = counterSecond;
                    counterSecond = trade;
                } else if (aux2 == 1) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        distributionMonte(counter);
                    }
                }

                if (list.get(0).numeroDeCartas() == 0 || list.get(1).numeroDeCartas() == 0) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        if (list.get(0).numeroDeCartas() == 0) {
                            distributionMonte(1);
                        } else if (list.get(1).numeroDeCartas() == 0) {
                            distributionMonte(0);
                        }
                    }
                    if (list.get(1).numeroDeCartas() == 32) {
                        System.out.println("Vencedor: " + list.get(1).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" +
                                "Perdedor: " + list.get(0).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" +
                                "Quantidade de Rounds: " + round);

                        break;
                    } else if (list.get(0).numeroDeCartas() == 32) {
                        System.out.println("Vencedor: " + list.get(0).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" +
                                "Perdedor: " + list.get(1).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" +
                                "Quantidade de Rounds: " + round);

                        break;
                    }
                }
                System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome() + " : " + list.get(counter).numeroDeCartas());
                System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome() + " : " + list.get(counterSecond).numeroDeCartas());

            } while (!list.get(0).TemCartas() || !list.get(1).TemCartas());

        } else if (getQntJogadores() == 4) {
           /* counter = getRandom(3);
            counterSecond = counter + 1;
            if (counterSecond == 4) {
                counterSecond = 0;
            }*/
           for(i = 0; i<3;i++){
               iVector[i] = 0;
           }
           
            do {
                round++;
                aux = random.nextInt(3);
                aux++;
         
                   
                if(iVector[counter] != 1 && iVector[counterSecond] != 1){
                    aux2 = comparationCards(aux, counter, counterSecond);
                }
                else{
                    if(iVector[counter] == 1 && iVector[counterSecond] != 1){
                        
                        aux2 = -1;
                    }
                    else if(iVector[counterSecond] == 1 && iVector[counter] != 1){  
                        
                        aux2 = 1;
                    }
                    else if(iVector[counter]  == 1 && iVector[counterSecond] == 1){
                        trade = 10;
                    }
                }
                if(trade != 10){
                if(aux2 == 1){
                    winner_round = counter;
                }
                else if(aux2 == -1){
                    winner_round = counterSecond;
                }
         }
                if(iVector[countertree] != 1 && iVector[counterfor] != 1){
                    aux2 = comparationCards(aux, countertree, counterfor);
                }else{
                    if(iVector[countertree] == 1 && iVector[counterfor] != 1){
                        
                        aux2 = -1;
                    }
                    else if(iVector[counterfor] == 1 && iVector[countertree] != 1){  
                        
                        aux2 = 1;
                    }
                    else if(iVector[countertree]  == 1 && iVector[counterfor] == 1){
                        verify = 10;
                       
                    }
                }
                if(verify != 10){
                if(aux2 == 1){
                    secondwinner_round = countertree;
                }
                else if(aux2 == -1){
                    secondwinner_round = counterfor;
                }
         }
                if(trade == 10){
                    winner_round = countertree;
                    secondwinner_round = counterfor;
                }
                if(verify == 10){
                    winner_round = counter;
                    secondwinner_round = counterSecond;
                }
                aux2 = comparationCards(aux, winner_round, secondwinner_round);
                if(aux2 == 1){
                    distributionMonte(winner_round);
                }
                else if(aux2 == -1){
                    distributionMonte(secondwinner_round);
                }

                //Verifica quais jogadores tem cartas vazias e não utiliza eles.
                if(list.get(counter).numeroDeCartas() == 0){
                    iVector[counter] = 1;
                }
               if(list.get(counterSecond).numeroDeCartas() == 0){
                    iVector[counterSecond] = 1;
                }
                if(list.get(countertree).numeroDeCartas() == 0){
                    iVector[countertree] = 1;
                }
                if(list.get(counterfor).numeroDeCartas() == 0){
                    iVector[counterfor] = 1;
                }
   
                    for(i = 0; i <= 3; i++){
                        if(iVector[i] == 1){
                            trade++;
                            if(trade  == 3){
                                break;
                            }
                        }
                    }
                    if(trade != 3){
                        trade = 0;
                    }
                
                if(trade == 3){
                    if(iVector[counter] != 1){
                        distributionMonte(counter);
                       
                       
                    }
                    else if(iVector[counterSecond] != 1){
                        distributionMonte(counterSecond);
                        
                    }
                    else if(iVector[countertree] != 1){
                        distributionMonte(countertree);
                       
                        
                    }
                    else if(iVector[counterfor] != 1){
                        distributionMonte(counterfor);
                       
                    }
                    
                }
                    System.out.println("ROUND: " + round);
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome() + " : " + list.get(counter).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome() + " : " + list.get(counterSecond).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(countertree).getNome() + " : " + list.get(countertree).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counterfor).getNome() + " : " + list.get(counterfor).numeroDeCartas());
                    System.out.println("PRINT MONTE: " + monte.size());
                  if(list.get(counter).numeroDeCartas() == 32  || list.get(counterSecond).numeroDeCartas() == 32 || list.get(countertree).numeroDeCartas() == 32 || list.get(counterfor).numeroDeCartas() == 32){
                      break;
                  }  
            } while (!list.get(0).TemCartas() || !list.get(1).TemCartas() || !list.get(2).TemCartas() || !list.get(3).TemCartas());
            } 
            else {
            System.out.println("QUANTIDADE DE PLAYERS INVALIDA!");
            System.out.println();
        }

    }
            
 public void startJogoManual() throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (getQntJogadores() == 2) {
            counter = getRandom(1);
            counterSecond = counter + 1;
            if (counterSecond == counter) {
                if (counterSecond == 2) {
                    counterSecond = 0;
                }
            }
            do {

                round++;
                do {
                    System.out.println("\n" + "Jogador desafiante:" + list.get(counter).getNome());
                    System.out.println("\nQuantidade de Cartas do Jogador " + list.get(counter).getNome() + " : " + list.get(counter).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome() + " : " + list.get(counterSecond).numeroDeCartas());
                    System.out.println("Jogador desafiado:" + list.get(counterSecond).getNome());
                    System.out.println("CARTA: " + list.get(counter).getCartas().getNome() + "\n" +
                            "Ataque:" + list.get(counter).getCartas().getAtaque() + "\n" + "Decomposição: " + list.get(counter).getCartas().getDecomposicao() + "\n" +
                            "Cor: " + list.get(counter).getCartas().getCor());
                    System.out.println("==========================");
                    System.out.println("= ROUND:  " + round + "              =");
                    System.out.println("= 1- Ataque:             =");
                    System.out.println("= 2- Decomposição:       =");
                    System.out.println("= 3- Cor:                =");
                    System.out.println("==========================");
                    System.out.println("= Optção:  ");
                    aux = scanner.nextInt();
                    if (aux > 3 || aux < 1) {
                        System.out.println("OPÇÃO INCORRETA DIGITE NOVAMENTE!");
                        System.out.println();
                        round--;
                    }
                } while (aux < 1 || aux > 3);
                aux2 = comparationCards(aux, counter, counterSecond);
                if (aux2 == -1) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        distributionMonte(counterSecond);
                    }
                    trade = counter;
                    counter = counterSecond;
                    counterSecond = trade;
                } else if (aux2 == 1) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        distributionMonte(counter);
                    }
                }

                if (list.get(0).numeroDeCartas() == 0 || list.get(1).numeroDeCartas() == 0) {
                    empate = verifyMonte();
                    if (empate != 0) {
                        if (list.get(0).numeroDeCartas() == 0) {
                            distributionMonte(1);
                        } else if (list.get(1).numeroDeCartas() == 0) {
                            distributionMonte(0);
                        }
                    }
                    if (list.get(1).numeroDeCartas() == 32) {
                        System.out.println("Vencedor: " + list.get(1).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" +
                                "Perdedor: " + list.get(0).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" +
                                "Quantidade de Rounds: " + round);

                        break;
                    } else if (list.get(0).numeroDeCartas() == 32) {
                        System.out.println("Vencedor: " + list.get(0).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" +
                                "Perdedor: " + list.get(1).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" +
                                "Quantidade de Rounds: " + round);

                        break;
                    }
                }


            } while (!list.get(0).TemCartas() || !list.get(1).TemCartas());

        } else if (getQntJogadores() == 4) {
            /*counter = getRandom(3);
            counterSecond = counter + 1;
            if (counterSecond == 4) {
                counterSecond = 0;
            }*/

            do {
                round++;
                System.out.println();
                do {
                    System.out.println("ROUND:  " + round);
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome() + " : " + list.get(counter).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome() + " : " + list.get(counterSecond).numeroDeCartas());   
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(countertree).getNome() + " : " + list.get(countertree).numeroDeCartas());
                    System.out.println("Quantidade de Cartas do Jogador " + list.get(counterfor).getNome() + " : " + list.get(counterfor).numeroDeCartas());
                    System.out.println("\nCARTA: " + list.get(counter).getCartas().getNome() + "\n" +
                            "Ataque:" + list.get(counter).getCartas().getAtaque() + "\n" + "Decomposição: " + list.get(counter).getCartas().getDecomposicao() + "\n" +
                            "Cor: " + list.get(counter).getCartas().getCor());
                    System.out.println("==========================");
                    System.out.println("= ROUND:  " + round + "              =");
                    System.out.println("= 1- Ataque:             =");
                    System.out.println("= 2- Decomposição:       =");
                    System.out.println("= 3- Cor:                =");
                    System.out.println("==========================");
                    System.out.println("= Optção:  ");
                    aux = scanner.nextInt();
                    if (aux > 3 || aux < 1) {
                        System.out.println("OPÇÃO INCORRETA DIGITE NOVAMENTE!");
                        System.out.println();
                        round--;
                    }
                } while (aux < 1 || aux > 3);
                 if(iVector[counter] != 1 && iVector[counterSecond] != 1){
                    aux2 = comparationCards(aux, counter, counterSecond);
                }
                else{
                    if(iVector[counter] == 1 && iVector[counterSecond] != 1){
                        
                        aux2 = -1;
                    }
                    else if(iVector[counterSecond] == 1 && iVector[counter] != 1){  
                        
                        aux2 = 1;
                    }
                    else if(iVector[counter]  == 1 && iVector[counterSecond] == 1){
                        trade = 10;
                    }
                }
                if(trade != 10){
                if(aux2 == 1){
                    winner_round = counter;
                }
                else if(aux2 == -1){
                    winner_round = counterSecond;
                }
         }
                if(iVector[countertree] != 1 && iVector[counterfor] != 1){
                    aux2 = comparationCards(aux, countertree, counterfor);
                }else{
                    if(iVector[countertree] == 1 && iVector[counterfor] != 1){
                        
                        aux2 = -1;
                    }
                    else if(iVector[counterfor] == 1 && iVector[countertree] != 1){  
                        
                        aux2 = 1;
                    }
                    else if(iVector[countertree]  == 1 && iVector[counterfor] == 1){
                        verify = 10;
                       
                    }
                }
                if(verify != 10){
                if(aux2 == 1){
                    secondwinner_round = countertree;
                }
                else if(aux2 == -1){
                    secondwinner_round = counterfor;
                }
         }
                if(trade == 10){
                    winner_round = countertree;
                    secondwinner_round = counterfor;
                }
                if(verify == 10){
                    winner_round = counter;
                    secondwinner_round = counterSecond;
                }
                aux2 = comparationCards(aux, winner_round, secondwinner_round);
                if(aux2 == 1){
                    distributionMonte(winner_round);
                    
                }
                else if(aux2 == -1){
                    distributionMonte(secondwinner_round);
                }

                //Verifica quais jogadores tem cartas vazias e não utiliza eles.
                if(list.get(counter).numeroDeCartas() == 0){
                    iVector[counter] = 1;
                }
               if(list.get(counterSecond).numeroDeCartas() == 0){
                    iVector[counterSecond] = 1;
                }
                if(list.get(countertree).numeroDeCartas() == 0){
                    iVector[countertree] = 1;
                }
                if(list.get(counterfor).numeroDeCartas() == 0){
                    iVector[counterfor] = 1;
                }
   
                    for(i = 0; i <= 3; i++){
                        if(iVector[i] == 1){
                            trade++;
                            if(trade  == 3){
                                break;
                            }
                        }
                    }
                    if(trade != 3){
                        trade = 0;
                    }
                
                if(trade == 3){
                    if(iVector[counter] != 1){
                        distributionMonte(counter);
                       
                       
                    }
                    else if(iVector[counterSecond] != 1){
                        distributionMonte(counterSecond);
                        
                    }
                    else if(iVector[countertree] != 1){
                        distributionMonte(countertree);
                       
                        
                    }
                    else if(iVector[counterfor] != 1){
                        distributionMonte(counterfor);
                       
                    }
                    
                }

                    if (list.get(counter).numeroDeCartas() == 32 || list.get(counterSecond).numeroDeCartas() == 32 || list.get(countertree).numeroDeCartas() == 32 || list.get(counterfor).numeroDeCartas() == 32) {
                            System.out.println("Vencedor:" + list.get(counter).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(counter).numeroDeCartas() + "\n" + "\n" +
                                "Perdedor:" + list.get(counterSecond).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(counterSecond).numeroDeCartas() + "\n" + "\n" +
                                "Perdedor:" + list.get(countertree).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(countertree).numeroDeCartas() + "\n" + "\n" +
                                "Perdedor:" + list.get(counterfor).getNome() + "\n" +
                                "Quantidade de Cartas: " + list.get(counterfor).numeroDeCartas() + "\n" + "\n" +
                                "Quantidade de Rounds:" + round);

                        break;
                    } 
                
            } while (!list.get(0).TemCartas() || !list.get(1).TemCartas() || !list.get(2).TemCartas() || !list.get(3).TemCartas());
        } else {
            System.out.println("\nQUANTIDADE DE PLAYERS INVALIDA!");
            System.out.println();
        }

    }

    //Getters
    public int getQntJogadores() {
        return this.qntJogadores;
    }

    public void setQntJogadores(int qnt) {
        this.qntJogadores = qnt;
    }

    public String getJogadorName() {
        return this.list.get(0).getNome();
    }

    //Setters
    public void setJogadorName(String name) {
        Jogador player = new Jogador(name);
        list.add(player);
    }

    public int comparationCards(int nIndex, int desafiante, int desafiado) {
        if (nIndex == 1) { // COMPARA ATAQUE
            if (list.get(desafiante).getCartas().comparationAtaque(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas() + "\n");
                card = list.get(desafiado).excluir();
                monte.add(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationAtaque(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas() + "\n");
                card = list.get(desafiante).excluir();
                monte.add(card);
                return -1;
            } else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!\n");
                if (list.get(desafiante).numeroDeCartas() == 0) {
                    distributionMonte(desafiado);
                    return -1;
                } else if (list.get(desafiado).numeroDeCartas() == 0) {
                    distributionMonte(desafiante);
                    return 1;
                }
                return 0;
            }
        } else if (nIndex == 2) { // COMPARA DECOMPOSIÇÃO
            if (list.get(desafiante).getCartas().comparationDecomp(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Decomp: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas() + "\n");
                card = list.get(desafiado).excluir();
                monte.add(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationDecomp(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Decomp: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas() + "\n");
                card = list.get(desafiante).excluir();
                monte.add(card);
                return -1;
            } else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!\n");
                if (list.get(desafiante).numeroDeCartas() == 0) {
                    distributionMonte(desafiado);
                    return -1;
                } else if (list.get(desafiado).numeroDeCartas() == 0) {
                    distributionMonte(desafiante);
                    return 1;
                }
                return 0;
            }

        } else if (nIndex == 3) { // COMPARA COR
            if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Cor: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas() + "\n");
                card = list.get(desafiado).excluir();
                monte.add(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor  no quesito Cor: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas());
                card = list.get(desafiante).excluir();
                monte.add(card);
                return -1;
            } else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!");
                if (list.get(desafiante).numeroDeCartas() == 0) {
                    distributionMonte(desafiado);
                    return -1;
                } else if (list.get(desafiado).numeroDeCartas() == 0) {
                    distributionMonte(desafiante);
                    return 1;
                }
                return 0;
            }
        } else {
            System.out.println("\nOPÇÃO INVALIDA DE COMPARAÇÃO\n");
            return 999;
        }


    }

    public int verifyMonte() {
        size = this.monte.size();
        return size;
    }

    public void distributionMonte(int nIndex) {
        for (i = this.monte.size()-1; i >= 0; i--) {
            carta = monte.remove(i);
            list.get(nIndex).incluir(carta);
        }
    }

    public int getRandom(int nIndex) {
        retorno = random.nextInt(nIndex);
        return retorno;
    }

    public void doisJogadores(String name1, String name2) {
        setJogadorName(name1);
        setJogadorName(name2);
        for (i = 0; i < 16; i++) {
            list.get(0).incluir(distribution.getBaralho(number.get(i)));
            list.get(1).incluir(distribution.getBaralho(number.get(16 + i)));
        }
    }

    public void quatroJogadores(String name1, String name2, String name3, String name4) {
        setJogadorName(name1);
        setJogadorName(name2);
        setJogadorName(name3);
        setJogadorName(name4);
        for (i = 0; i < 8; i++) {
            list.get(0).incluir(distribution.getBaralho(number.get(i)));
            list.get(1).incluir(distribution.getBaralho(number.get(8 + i)));
            list.get(2).incluir(distribution.getBaralho(number.get(16 + i)));
            list.get(3).incluir(distribution.getBaralho(number.get(24 + i)));
        }
    }
}