package SuperTrunfoDaReciclagem.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SuperTrunfoDaReciclagem {

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
    public int jogador1 = 0, jogador2 = 1, jogador3 = 2, jogador4 = 3, size;
    
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
    public void startJogo(){
        
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
                              
                              
              else if(aux2 == 0){
                if(list.get(counterSecond).numeroDeCartas() == 0){
                       empate = verifyMonte();
                        if(empate != 0){
                        distributionMonte(counter);
                        
                   }
                }
                  else if(list.get(counter).numeroDeCartas() == 0){
                       empate = verifyMonte();
                        if(empate != 0){
                        distributionMonte(counterSecond);
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = trade;
                        
                        }
                    }
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
              } 
              
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
              
              if(list.get(0).numeroDeCartas() == 32){
                   System.out.println("Vencedor: " + list.get(0).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Perdedor: " + list.get(1).getNome());
                    System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Quantidade de Rounds: " + round);
                  break;
              }
              else if(list.get(1).numeroDeCartas() == 32){
                   System.out.println("Vencedor: " + list.get(1).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Perdedor: " + list.get(0).getNome());
                    System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Quantidade de Rounds: " + round);
                  break;
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
              
              else if(aux2 == 0){
                if(list.get(counterSecond).numeroDeCartas() == 0){
                       empate = verifyMonte();
                        if(empate != 0){
                        distributionMonte(counter);
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
                             counterSecond = counterSecond + 1;
                         }
                      } 
                   }
                }
                  else if(list.get(counter).numeroDeCartas() == 0){
                       empate = verifyMonte();
                        if(empate != 0){
                        distributionMonte(counterSecond);
                        trade = counter;
                        counter = counterSecond;
                        counterSecond = trade + 1;
                        if(counterSecond == counter){
                            counterSecond++;
                            if(counterSecond == 4){
                                counterSecond = 0;
                            }
                          }
                        if(counterSecond == 4){
                            counterSecond = 0;
                            if(counterSecond == counter){
                                counterSecond++;
                            }
                        }
                      }
                        
                    }
                  else{
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
              
              if(verify != 4){
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counter).getNome()  + " : " + list.get(counter).numeroDeCartas());
              System.out.println("Quantidade de Cartas do Jogador " + list.get(counterSecond).getNome()  + " : " + list.get(counterSecond).numeroDeCartas());
              }
              
              if(list.get(0).numeroDeCartas() == 32 && verify == 4){
                   System.out.println("Vencedor:" + list.get(0).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(1).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(2).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(2).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(3).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(3).numeroDeCartas());
                   System.out.println("Quantidade de Rounds:" + round);
                  break;
              }
              else if(list.get(1).numeroDeCartas() == 32 && verify == 4){
                   System.out.println("Vencedor:" + list.get(1).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(0).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(2).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(2).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(3).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(3).numeroDeCartas());
                   System.out.println("Quantidade de Rounds:" + round);
                  break;
              }
              else if(list.get(2).numeroDeCartas() == 32  && verify == 4){
                   System.out.println("Vencedor:" + list.get(2).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(2).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(1).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(0).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(3).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(3).numeroDeCartas());
                   System.out.println("Quantidade de Rounds:" + round);
                  break;
              }
              else if(list.get(3).numeroDeCartas() == 32  && verify == 4){
                   System.out.println("Vencedor:" + list.get(3).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(3).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(1).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(0).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(2).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(1).numeroDeCartas());
                   System.out.println("Perdedor:" + list.get(0).getNome());
                   System.out.println("Quantidade de Cartas: " + list.get(2).numeroDeCartas());
                   System.out.println("Quantidade de Rounds:" + round);
                  break;
              }
            }while(!list.get(0).TemCartas()|| !list.get(1).TemCartas() || !list.get(2).TemCartas() || !list.get(3).TemCartas());
        }
      else{
          System.out.println("QUANTIDADE DE PLAYERS INVALIDA!");
          System.out.println();
      }
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
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas());
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationAtaque(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1){
                System.out.println("Vencedor no quesito Ataque: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas());
                card = list.get(desafiante).excluir();
                list.get(desafiado).incluir(card);
                return -1;
            }
             else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("EMPATE!");
                return 0;
            }
        } else if (nIndex == 2) { // COMPARA DECOMPOSIÇÃO
            if (list.get(desafiante).getCartas().comparationDecomp(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
               System.out.println("Vencedor no quesito Decomp: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas());
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationDecomp(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
               System.out.println("Vencedor no quesito Decomp: " + list.get(desafiado).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiado).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiante).getCartas());
                card = list.get(desafiante).excluir();
                list.get(desafiado).incluir(card);
                return -1;
            }                else {
                card = list.get(desafiante).excluir();
                monte.add(card);
                card = list.get(desafiado).excluir();
                monte.add(card);
                System.out.println("EMPATE!");
                return 0;
            }
        
        } else if(nIndex == 3){ // COMPARA COR
            if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == 1) {
               System.out.println("Vencedor no quesito Cor: " + list.get(desafiante).getNome());
                System.out.println("Carta Vencedora:" + list.get(desafiante).getCartas());
                System.out.println("Carta Perdedora: " + list.get(desafiado).getCartas());
                card = list.get(desafiado).excluir();
                list.get(desafiante).incluir(card);
                return 1;
            } else if (list.get(desafiante).getCartas().comparationCor(list.get(desafiante).getCartas(), list.get(desafiado).getCartas()) == -1) {
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
                System.out.println("EMPATE!");
                return 0;
            }
        }
        else{
            System.out.println("OPÇÃO INVALIDA DE COMPARAÇÃO");
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


