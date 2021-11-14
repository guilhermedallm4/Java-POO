package SuperTrunfoDaReciclagem.temp;

public class Reciclavel extends Carta{
    private boolean reciclavel;
    
    public Reciclavel(String codigo, String nome, String descricao, String tipo, Cor cor, double decomposicao, int ataque, boolean reciclavel) {
        super(codigo, nome, descricao, tipo, cor, decomposicao, ataque);
        this.reciclavel = reciclavel;
    }

  public static boolean ehReciclavel(){
    return true;
  }
  @Override
       public String toString() {
         return 
                "Carta{" +
                super.toString() +
                "reciclavel=" + this.ehReciclavel() +"}";
        }
       //SETTERS
      public void setReciclavel(boolean reciclavel){
          this.reciclavel = reciclavel;
      }
      //GETTERS
      public boolean getReciclavel(){
          return this.reciclavel;
      }
}