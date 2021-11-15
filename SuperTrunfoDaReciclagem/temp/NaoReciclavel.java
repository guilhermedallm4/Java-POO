package SuperTrunfoDaReciclagem.temp;

public class NaoReciclavel extends Carta{
    private boolean reciclavel;
    
    public NaoReciclavel(String codigo, String nome, String descricao, String tipo, Cor cor, double decomposicao, int ataque, boolean reciclavel) {
        super(codigo, nome, descricao, tipo, cor, decomposicao, ataque);
        this.reciclavel = reciclavel;
    }
   

  @Override
  public boolean ehReciclavel(){
    return false;
  }
 @Override 
       public String toString() {
         return 
                "Carta{" +
                super.toString() +
                "reciclavel=" + this.ehReciclavel() +'}';
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