package SuperTrunfoDaReciclagem;

import java.util.LinkedList;
import java.util.Queue;

public class Jogador {
     private String nome;
     private Queue<Carta> cartas = new LinkedList<>();

    public Jogador(String name) {
        this.nome = name;
    }

    public String nome() {
        return this.getNome();
    }

    public int numeroDeCartas() {
        return this.cartas.size();
        
    }

    public void incluir(Carta carta) {
        this.cartas.add(carta);
    }

    public Carta excluir() {

        return this.cartas.remove();
        
    }

    public boolean TemCartas() {

        return this.cartas.isEmpty();
    }

    //GETTERS
    public String getNome() {
        return this.nome;
    }


    public Carta getCartas() {
        return this.cartas.peek();

    }

}