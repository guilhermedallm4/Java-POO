package SuperTrunfoDaReciclagem.temp;
import java.util.Queue;
import java.util.LinkedList;

public class Jogador {
    public String nome;
    public Carta carta;
    public int size;
    Queue<Carta>cartas = new LinkedList<>();

    public Jogador(String name){
        this.nome = name;
    }
    public String nome(){
      return this.getNome();
    }
    public int numeroDeCartas(){
      size = this.cartas.size();
      return size;
    }
    public void incluir(Carta carta){
      this.setCartas(carta);
    }
    
    public Carta excluir(){   
      carta = this.cartas.remove();
      return carta;
    }

    public boolean TemCartas(){
      return this.cartas.isEmpty();    
    }

    //SETTERS
    public void setNome(String nome){
      this.nome = nome;
    }
    public void setCartas(Carta carta){
        this.cartas.add(carta);
    }
    //GETTERS
    public String getNome(){
      return this.nome;
    }
    public Carta getCartas(){
       return this.cartas.peek();
        
    }

   
}