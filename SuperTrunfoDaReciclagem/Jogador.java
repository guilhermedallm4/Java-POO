package SuperTrunfoDaReciclagem;

import java.util.LinkedList;
import java.util.Queue;

public class Jogador {
    public String nome;
    Queue<Carta> cartas = new LinkedList<>();

    public Jogador(String name) {
        this.nome = name;
    }

    public String nome() {
        return this.getNome();
    }

    public int numeroDeCartas() {
        int size = this.cartas.size();
        return size;
    }

    public void incluir(Carta carta) {
        this.setCartas(carta);
    }

    public Carta excluir() {

        Carta carta = this.cartas.remove();
        return carta;
    }

    public boolean TemCartas() {

        return this.cartas.isEmpty();
    }

    //GETTERS
    public String getNome() {
        return this.nome;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carta getCartas() {
        return this.cartas.peek();

    }

    public void setCartas(Carta carta) {
        this.cartas.add(carta);
    }


}