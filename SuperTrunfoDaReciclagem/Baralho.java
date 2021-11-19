package SuperTrunfoDaReciclagem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Baralho {

     private boolean reciclar;
     private String testar = "sim";
     private String path = "c:\\Super Trunfo da Reciclagem.csv";

    List<Carta> list = new ArrayList<Carta>();

    public void lerDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            while (line != null) {

                String[] vect = line.split(";");
                String codigo = vect[0];
                String nome = vect[1];
                String descricao = vect[2];
                String tipo = vect[3];
                Cor cor = Cor.stringToCor(vect[4]);
                Double decomposicao = Double.parseDouble(vect[5]);
                Integer ataque = Integer.parseInt(vect[6]);
                String reciclavel = (vect[7]);

                if (reciclavel.equals(testar)) {
                    reciclar = true;
                    Reciclavel recicl = new Reciclavel(codigo, nome, descricao, tipo, cor, decomposicao, ataque, reciclar);
                    list.add(recicl);
                } else {
                    reciclar = false;
                    NaoReciclavel noRecicl = new NaoReciclavel(codigo, nome, descricao, tipo, cor, decomposicao, ataque, reciclar);
                    list.add(noRecicl);
                }
                line = br.readLine();
            }

               /* System.out.println("CARTAS:");
                for (Carta p : list) {
                    System.out.println(p);
                }*/
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public Carta getBaralho(int nIndex) {

        return this.list.get(nIndex);
    }
}  