package SuperTrunfoDaReciclagem.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SuperTrunfoDaReciclagem{

    private List<Jogador> list = new ArrayList<>();
    private List<Integer> number = new ArrayList<>();
    private List<Carta> monte = new ArrayList<>();
    private Baralho distribution = new Baralho();
    public int empate;
    public Carta card;
    public String name1, name2, name3, name4;
    public Random random = new Random();
    public int[] iVector = new int[32];
    private int qntJogadores;
    public int i = 0, aux, aux2, counter, counterSecond, trade, round = 0, verify = 0;
    public int option, size;
    
    //Metodo construtor
    public SuperTrunfoDaReciclagem(int qntJogadores){
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
           FileWriter arq = new FileWriter("c:\\teste.txt");
           PrintWriter gravarArq = new PrintWriter(arq);
      if(getQntJogadores() == 2){
          counter = getRandom(1);
          counterSecond = counter + 1;
          if(counterSecond == counter){
              if(counterSecond == 2){
                  counterSecond = 0;
              }
          }
          do{
              
              round++;
              aux = random.nextInt(3);
              aux++;
              aux2 = comparationCards(aux, counter, counterSecond);
              if(aux2 == -1){
                  empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counterSecond);
                  }
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = trade;
                  }
                 else if(aux2 == 1){
                  empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counter);
                  }
                }
                         
              if(list.get(0).numeroDeCartas() == 0 || list.get(1).numeroDeCartas() == 0){
                  empate = verifyMonte();
                  if(empate != 0){
                      if(list.get(0).numeroDeCartas() == 0){
                          distributionMonte(1);                          
                      }
                      else if(list.get(1).numeroDeCartas() == 0){
                          distributionMonte(0);
           }
        }
                   if(list.get(1).numeroDeCartas() == 32){
                  gravarArq.printf("Vencedor: " + list.get(1).getNome() +  "\n" +
                  "Quantidade de Cartas: " + list.get(1).numeroDeCartas() +  "\n" +
                   "Perdedor: " + list.get(0).getNome() +  "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() +  "\n" +
                   "Quantidade de Rounds: " + round);
                    arq.close();
                  break;
              }
                   else if(list.get(0).numeroDeCartas() == 32){
                gravarArq.printf("Vencedor: " + list.get(0).getNome() +  "\n" +
                  "Quantidade de Cartas: " + list.get(0).numeroDeCartas() +  "\n" +
                   "Perdedor: " + list.get(1).getNome() +  "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() +  "\n" +
                   "Quantidade de Rounds: " + round);
                    arq.close();
                  break;
                  }
              }
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
              
          }while(!list.get(0).TemCartas()|| !list.get(1).TemCartas());
          
      }
      else if(getQntJogadores() == 4){
          counter = getRandom(3);
          counterSecond = counter + 1;
          if(counterSecond == 4){
              counterSecond = 0;
          }
          
          do{
              round++;
              aux = random.nextInt(3);
              aux++;
              
              aux2 = comparationCards(aux, counter, counterSecond);
              
              if(aux2 == -1){
                   empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counterSecond);
                  }
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = counterSecond + 1;
                        if(counterSecond == 4){
                            counterSecond = 0;
                        }
                        if(counterSecond == counter){
                            counterSecond = counterSecond + 1;
                            if(counterSecond == 4){
                                counterSecond = 0;
                            }
                        }
              }
              
              else if(aux2 == 1){
                   empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counter);
                  }
                  counterSecond = counterSecond + 1;
                  if(counterSecond == 4){
                            counterSecond = 0;
                  }
                  if(counterSecond == counter){
                       counterSecond = counterSecond + 1;
                        if(counterSecond == 4){
                                counterSecond = 0;
                            }
                        }
              }
              if(aux2 == 0){
                  counterSecond = counterSecond + 1;
                  if(counterSecond == 4){
                      counterSecond = 0;
                      if(counterSecond == counter){
                          counterSecond = counterSecond + 1;
                      }
                  }
                  if(counterSecond == counter){
                      counterSecond = counterSecond + 1;
                      if(counterSecond == 4){
                          counterSecond = 0;
                      }
                  }
              }
              //Verifica quais jogadores tem cartas vazias e não utiliza eles.
              while(list.get(counterSecond).numeroDeCartas() == 0){
                  verify++; 
                  counterSecond = counterSecond + 1;
                   if(counterSecond == counter){
                       counterSecond = counterSecond + 1;
                       if(counterSecond == 4){
                           counterSecond = 0;
                       }
                   }
                   if(counterSecond == 4){
                       counterSecond = 0;
                       if(counterSecond == counter){
                           counterSecond = counterSecond + 1;
                       }
                   }
                   if(verify == 4){
                       break;
                  }
              }
              if(verify != 4){
                  verify = 0;
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
              }
              else{
                   if(list.get(0).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              else if(list.get(1).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
                    
              }
              else if(list.get(2).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" + 
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              else if(list.get(3).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              }
            }while(!list.get(0).TemCartas()|| !list.get(1).TemCartas() || !list.get(2).TemCartas() || !list.get(3).TemCartas());
        }
      else{
          System.out.println("QUANTIDADE DE PLAYERS INVALIDA!");
          System.out.println();
      }
      arq.close();
    } 
    
  public void startJogoManual() throws IOException {
      FileWriter arq = new FileWriter("c:\\teste.txt");
      PrintWriter gravarArq = new PrintWriter(arq);
      Scanner scanner = new Scanner(System.in);
      if(getQntJogadores() == 2){
          counter = getRandom(1);
          counterSecond = counter + 1;
          if(counterSecond == counter){
              if(counterSecond == 2){
                  counterSecond = 0;
              }
          }
          do{
              
              round++;
              do{ 
                  System.out.println("\n" + "Jogador desafiante:" + list.get(counter).getNome());
                  System.out.println("\nQuantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
                   System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
                  System.out.println("Jogador desafiado:" + list.get(counterSecond).getNome());
                  System.out.println("CARTA: " + list.get(counter).getCartas().getNome() + "\n" + 
                  "Ataque:" + list.get(counter).getCartas().getAtaque() + "\n" +  "Decomposição: " + list.get(counter).getCartas().getDecomposicao() + "\n" +
                  "Cor: " + list.get(counter).getCartas().getCor());
                  System.out.println("==========================");
                  System.out.println("= ROUND:  " + round + "              =");
                  System.out.println("= 1- Ataque:             =");
                  System.out.println("= 2- Decomposição:       =");
                  System.out.println("= 3- Cor:                =");
                  System.out.println("==========================");
                  System.out.println("= Optção:  ");
                  aux = scanner.nextInt();
                  if(aux > 3 || aux < 1){
                      System.out.println("OPÇÃO INCORRETA DIGITE NOVAMENTE!");
                      System.out.println();
                      round--;
                  }
              }while(aux < 1 && aux > 3);
              aux2 = comparationCards(aux, counter, counterSecond);
              if(aux2 == -1){
                  empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counterSecond);
                  }
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = trade;
                  }
                 else if(aux2 == 1){
                  empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counter);
                  }
                }
                         
              if(list.get(0).numeroDeCartas() == 0 || list.get(1).numeroDeCartas() == 0){
                  empate = verifyMonte();
                  if(empate != 0){
                      if(list.get(0).numeroDeCartas() == 0){
                          distributionMonte(1);                          
                      }
                      else if(list.get(1).numeroDeCartas() == 0){
                          distributionMonte(0);
           }
        }
                   if(list.get(1).numeroDeCartas() == 32){
                  gravarArq.printf("Vencedor: " + list.get(1).getNome() +  "\n" +
                  "Quantidade de Cartas: " + list.get(1).numeroDeCartas() +  "\n" +
                   "Perdedor: " + list.get(0).getNome() +  "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() +  "\n" +
                   "Quantidade de Rounds: " + round);
                    arq.close();
                  break;
              }
                   else if(list.get(0).numeroDeCartas() == 32){
                gravarArq.printf("Vencedor: " + list.get(0).getNome() +  "\n" +
                  "Quantidade de Cartas: " + list.get(0).numeroDeCartas() +  "\n" +
                   "Perdedor: " + list.get(1).getNome() +  "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() +  "\n" +
                   "Quantidade de Rounds: " + round);
                    arq.close();
                  break;
                  }
              }
        
              
          }while(!list.get(0).TemCartas()|| !list.get(1).TemCartas());
          
      }
      else if(getQntJogadores() == 4){
          counter = getRandom(3);
          counterSecond = counter + 1;
          if(counterSecond == 4){
              counterSecond = 0;
          }
          
          do{
              round++;
              System.out.println();
              do{ 
                  System.out.println("\n" + "Jogador desafiante:" + list.get(counter).getNome());
                  System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
                  System.out.println("Jogador desafiado:" + list.get(counterSecond).getNome());
                  System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
                  System.out.println("\nCARTA: " + list.get(counter).getCartas().getNome() + "\n" + 
                  "Ataque:" + list.get(counter).getCartas().getAtaque() + "\n" +  "Decomposição: " + list.get(counter).getCartas().getDecomposicao() + "\n" +
                  "Cor: " + list.get(counter).getCartas().getCor());
                  System.out.println("==========================");
                  System.out.println("= ROUND:  " + round + "              =");
                  System.out.println("= 1- Ataque:             =");
                  System.out.println("= 2- Decomposição:       =");
                  System.out.println("= 3- Cor:                =");
                  System.out.println("==========================");
                  System.out.println("= Optção:  ");
                  aux = scanner.nextInt();
                  if(aux > 3 || aux < 1){
                      System.out.println("OPÇÃO INCORRETA DIGITE NOVAMENTE!");
                      System.out.println();
                      round--;
                  }
              }while(aux < 1 && aux > 3);
              aux2 = comparationCards(aux, counter, counterSecond);
              
              if(aux2 == -1){
                   empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counterSecond);
                  }
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = counterSecond + 1;
                        if(counterSecond == 4){
                            counterSecond = 0;
                        }
                        if(counterSecond == counter){
                            counterSecond = counterSecond + 1;
                            if(counterSecond == 4){
                                counterSecond = 0;
                            }
                        }
              }
              
              else if(aux2 == 1){
                   empate = verifyMonte();
                  if(empate != 0){
                      distributionMonte(counter);
                  }
                  counterSecond = counterSecond + 1;
                  if(counterSecond == 4){
                            counterSecond = 0;
                  }
                  if(counterSecond == counter){
                       counterSecond = counterSecond + 1;
                        if(counterSecond == 4){
                                counterSecond = 0;
                            }
                        }
              }
              if(aux2 == 0){
                  counterSecond = counterSecond + 1;
                  if(counterSecond == 4){
                      counterSecond = 0;
                      if(counterSecond == counter){
                          counterSecond = counterSecond + 1;
                      }
                  }
                  if(counterSecond == counter){
                      counterSecond = counterSecond + 1;
                      if(counterSecond == 4){
                          counterSecond = 0;
                      }
                  }
              }
              //Verifica quais jogadores tem cartas vazias e não utiliza eles.
              while(list.get(counterSecond).numeroDeCartas() == 0){
                  verify++; 
                  counterSecond = counterSecond + 1;
                   if(counterSecond == counter){
                       counterSecond = counterSecond + 1;
                       if(counterSecond == 4){
                           counterSecond = 0;
                       }
                   }
                   if(counterSecond == 4){
                       counterSecond = 0;
                       if(counterSecond == counter){
                           counterSecond = counterSecond + 1;
                       }
                   }
                   if(verify == 4){
                       break;
                  }
              }
              if(verify != 4){
                  verify = 0;
             }
              else{
                   if(list.get(0).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              else if(list.get(1).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
                    
              }
              else if(list.get(2).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(3).getNome() + "\n" + 
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              else if(list.get(3).numeroDeCartas() == 32){
                    gravarArq.printf("Vencedor:" + list.get(3).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(3).numeroDeCartas() + "\n" + "\n" +
                    "Perdedor:" + list.get(1).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(0).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(2).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(1).numeroDeCartas() + "\n" + "\n" +
                   "Perdedor:" + list.get(0).getNome() + "\n" +
                   "Quantidade de Cartas: " + list.get(2).numeroDeCartas() + "\n" + "\n" +
                   "Quantidade de Rounds:" + round);
                   //arq.close();
                   break;
              }
              }
            }while(!list.get(0).TemCartas()|| !list.get(1).TemCartas() || !list.get(2).TemCartas() || !list.get(3).TemCartas());
        }
      else{
          System.out.println("\nQUANTIDADE DE PLAYERS INVALIDA!");
          System.out.println();
      }
      arq.close();
    } 
    //Setters
    public void setJogadorName(String name) {
        Jogador player = new Jogador(name);
        list.add(player);
    }

    public void setQntJogadores(int qnt) {
        this.qntJogadores = qnt;
    }

    //Getters
    public int getQntJogadores() {
        return this.qntJogadores;
    }

    public String getJogadorName() {
        return this.list.get(0).getNome();
    }

    public int comparationCards(int nIndex, int desafiante, int desafiado) {
        if (nIndex == 1) { // COMPARA ATAQUE
            if (list.get(desafiante).getCartas().comparationAtaque(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas() + "\n");
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationAtaque(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1){
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas() + "\n");
                card = list.get(desafiante).excluir();
                list.get(desafiado).incluir(card);
                return -1;
            }
else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!\n");
                                if(list.get(desafiante).numeroDeCartas() == 0){
                    distributionMonte(desafiado);
                    return -1;
                }
                else if(list.get(desafiado).numeroDeCartas() == 0){
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
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas()+ "\n");
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationDecomp(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
                System.out.println("\nROUND: " + round);
               System.out.println("Vencedor no quesito Decomp: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas() + "\n");
                card = list.get(desafiante).excluir();
                list.get(desafiado).incluir(card);
                return -1;
            }else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!\n");
                                if(list.get(desafiante).numeroDeCartas() == 0){
                    distributionMonte(desafiado);
                    return -1;
                }
                else if(list.get(desafiado).numeroDeCartas() == 0){
                    distributionMonte(desafiante);
                    return 1;
                }
                return 0;
            }
        
        } else if(nIndex == 3){ // COMPARA COR
            if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
                System.out.println("\nROUND: " + round);
               System.out.println("Vencedor no quesito Cor: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas() + "\n");
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
                System.out.println("\nROUND: " + round);
                System.out.println("Vencedor  no quesito Cor: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas());
                card = list.get(desafiante).excluir();
                list.get(desafiado).incluir(card);
                return -1;
            }else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("\nROUND: " + round);
                System.out.println("EMPATE!");
                                if(list.get(desafiante).numeroDeCartas() == 0){
                    distributionMonte(desafiado);
                    return -1;
                }
                else if(list.get(desafiado).numeroDeCartas() == 0){
                    distributionMonte(desafiante);
                    return 1;
                }
                return 0;
            }
        }
        else{
            System.out.println("\nOPÇÃO INVALIDA DE COMPARAÇÃO\n");
            return 999;
        }
        

    }
    public int verifyMonte(){
        size = this.monte.size();
        return size;
    }
    
    public void distributionMonte(int nIndex){
        Carta carta;
        for(i = 0; i < this.monte.size(); i++){
            carta = this.monte.remove(i);
            list.get(nIndex).incluir(carta);
        }
    }
    
    public int getRandom(int nIndex){
        int retorno = random.nextInt(nIndex);
        return retorno;
    }
    
    public void doisJogadores(String name1, String name2){
            setJogadorName(name1);
            setJogadorName(name2);
            for (i = 0; i < 16; i++) {
                list.get(0).incluir(distribution.getBaralho(number.get(i)));
                list.get(1).incluir(distribution.getBaralho(number.get(16 + i)));
            }
    }
    
    public void quatroJogadores(String name1, String name2, String name3, String name4){
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
