package SuperTrunfoDaReciclagem.temp;
import java.io.Serializable;


public abstract class Carta{
    private String codigo;
    private String nome;
    private String descricao;
    private String tipo;
    private Cor cor;
    private double decomposicao;
    private int ataque;
    private static final long serialVersionUID = 1L;


    public Carta(String codigo, String nome, String descricao, String tipo, Cor cor, double decomposicao, int ataque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.cor = cor;
        this.decomposicao = decomposicao;
        this.ataque = ataque;
    }



    //Setters e Getters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public double getDecomposicao() {
        return decomposicao;
    }

    public void setDecomposicao(double decomposicao) {
        this.decomposicao = decomposicao;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    
    @Override
    public String toString() {
        return "Carta{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cor=" + cor +
                ", decomposicao=" + decomposicao +
                ", ataque=" + ataque +
                '}';
    }
    public int comparationCor(Carta cartaOne, Carta cartaSecond){
                
                //Compara a igualdade das cores
                if(cartaOne.cor.toString().equals(cartaSecond.cor.toString())){
                    return 0;
                }
                //Super Pneu
                else if(cartaOne.cor.toString().equals("menor")){
                    if(cartaSecond.cor.toString().equals("roxo") || cartaSecond.cor.toString().equals("branco") || cartaSecond.cor.toString().equals("marrom") || 
                            cartaSecond.cor.toString().equals("cinza") || cartaSecond.cor.toString().equals("laranja")){
                        return 1;
                        
                    }
                    else{
                            return -1;
                            
                    }
                }
                //Compara Dom Latom
                else if(cartaOne.cor.toString().equals("maior")){
                    if(cartaSecond.getCodigo().equals("A1") || cartaSecond.getCodigo().equals("B1") || cartaSecond.getCodigo().equals("C1") ||
                            cartaSecond.getCodigo().equals("E1") || cartaSecond.getCodigo().equals("F1")|| cartaSecond.getCodigo().equals("H1")){
                        return -1;
                    }
                    else{
                        System.out.println("DOM LATON VENCEU!");
                        return 1;
                    }
                }
                else if(cartaSecond.cor.toString().equals("maior")){
                    if(cartaOne.getCodigo().equals("A1") || cartaOne.getCodigo().equals("B1") || cartaOne.getCodigo().equals("C1") ||
                            cartaOne.getCodigo().equals("E1") || cartaOne.getCodigo().equals("F1")|| cartaOne.getCodigo().equals("H1")){
                        return 1;
                    }
                    else{
                        System.out.println("DOM LATON VENCEU!");
                        return -1;
                    }
                }
                //COMPARA O VERMELHO
                else if(cartaOne.cor.toString().equals("vermelho")){
                    if(cartaSecond.cor.toString().equals("amarelo") || cartaSecond.cor.toString().equals("verde") || cartaSecond.cor.toString().equals("marrom") || 
                            cartaSecond.cor.toString().equals("cinza") || cartaSecond.cor.toString().equals("preto") || cartaSecond.cor.toString().equals("menor")){
                        return 1;
                        
                    }
                    else if(cartaSecond.cor.toString().equals("preto")){
                            return 0;
                            
                    }
                    else{
                        return -1;
                        
                    }
                }
                
                //COMPARA AZUL
                else if(cartaOne.cor.toString().equals("azul")){
                    if(cartaSecond.cor.toString().equals("vermelho") || cartaSecond.cor.toString().equals("amarelo") || cartaSecond.cor.toString().equals("verde") 
                            || cartaSecond.cor.toString().equals("marrom") || cartaSecond.cor.toString().equals("menor")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("cinza")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                    
                }
                else if(cartaOne.cor.toString().equals("amarelo")){
                    if(cartaSecond.cor.toString().equals("verde") || cartaSecond.cor.toString().equals("marrom") || cartaSecond.cor.toString().equals("cinza") 
                            || cartaSecond.cor.toString().equals("preto") || cartaSecond.cor.toString().equals("menor")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("branco")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
                else if(cartaOne.cor.toString().equals("verde")){
                    if(cartaSecond.cor.toString().equals("cinza") || cartaSecond.cor.toString().equals("preto") || cartaSecond.cor.toString().equals("branco") 
                            || cartaSecond.cor.toString().equals("marrom") || cartaSecond.cor.toString().equals("menor")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("laranja")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
                else if(cartaOne.cor.toString().equals("cinza")){
                    if(cartaSecond.cor.toString().equals("branco") || cartaSecond.cor.toString().equals("preto") || cartaSecond.cor.toString().equals("laranja") 
                            || cartaSecond.cor.toString().equals("roxo")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("azul")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                }
                else if(cartaOne.cor.toString().equals("laranja")){
                if(cartaSecond.cor.toString().equals("roxo") || cartaSecond.cor.toString().equals("azul") || cartaSecond.cor.toString().equals("vermelho") 
                            || cartaSecond.cor.toString().equals("amarelo")|| cartaSecond.cor.toString().equals("verde")){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
                
                else if(cartaOne.cor.toString().equals("marrom")){
                if(cartaSecond.cor.toString().equals("roxo") || cartaSecond.cor.toString().equals("azul") || cartaSecond.cor.toString().equals("vermelho") 
                            || cartaSecond.cor.toString().equals("amarelo")||cartaSecond.cor.toString().equals("verde")){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                
                }
                else if(cartaOne.cor.toString().equals("roxo")){
                    if(cartaSecond.cor.toString().equals("roxo") || cartaSecond.cor.toString().equals("azul") || cartaSecond.cor.toString().equals("vermelho") 
                            || cartaSecond.cor.toString().equals("amarelo")|| cartaSecond.cor.toString().equals("verde")){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                
                }
                else if(cartaOne.cor.toString().equals("branco")){
                    if(cartaSecond.cor.toString().equals("laranja") ||cartaSecond.cor.toString().equals("roxo") || cartaSecond.cor.toString().equals("azul") 
                            || cartaSecond.cor.toString().equals("vermelho")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("amarelo")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                
                }
                else if(cartaOne.cor.toString().equals("preto")){
                                      if(cartaSecond.cor.toString().equals("branco") || cartaSecond.cor.toString().equals("laranja") || cartaSecond.cor.toString().equals("roxo") 
                            || cartaSecond.cor.toString().equals("azul") || cartaSecond.cor.toString().equals("menor")){
                        return 1;
                    }
                    else if(cartaSecond.cor.toString().equals("vermelho")){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                
                }
                else{
                System.out.println();
                System.out.println("CARTA1:" + cartaOne.cor.toString());
                System.out.println("CARTA2:" + cartaSecond.cor.toString());
                System.out.println("INDEFINIDA");
                System.out.println();
                return -3;
                
                }
                   
         }
    
    public int comparationAtaque(Carta cartaOne, Carta cartaSecond){
        //compara dom Latom
        if(cartaOne.getCodigo().equals("H3")){
            if(cartaSecond.getCodigo().equals("A1") || cartaSecond.getCodigo().equals("B1") || cartaSecond.getCodigo().equals("C1") ||
                            cartaSecond.getCodigo().equals("E1") || cartaSecond.getCodigo().equals("F1")|| cartaSecond.getCodigo().equals("H1")){
                        return -1;
             }
            else{
                return  1;
            }
        }
        //compara dom Latom
        else if(cartaSecond.getCodigo().equals("H3")){
            if(cartaOne.getCodigo().equals("A1") || cartaOne.getCodigo().equals("B1") || cartaOne.getCodigo().equals("C1") ||
                            cartaOne.getCodigo().equals("E1") || cartaOne.getCodigo().equals("F1")|| cartaOne.getCodigo().equals("H1")){
                        return -1;
             }
            else{
                return  1;
            }
           
        }
        else if(cartaOne.getAtaque() > cartaSecond.getAtaque()){
            return 1;
        }
        else if(cartaOne.getAtaque() == cartaSecond.getAtaque()){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public int comparationDecomp(Carta cartaOne, Carta cartaSecond){
          //compara dom Latom
        if(cartaOne.getCodigo().equals("H3")){
            if(cartaSecond.getCodigo().equals("A1") || cartaSecond.getCodigo().equals("B1") || cartaSecond.getCodigo().equals("C1") ||
                            cartaSecond.getCodigo().equals("E1") || cartaSecond.getCodigo().equals("F1")|| cartaSecond.getCodigo().equals("H1")){
                        return -1;
             }
            else{
                return  1;
            }
        }
        //compara dom Latom
        else if(cartaSecond.getCodigo().equals("H3")){
            if(cartaOne.getCodigo().equals("A1") || cartaOne.getCodigo().equals("B1") || cartaOne.getCodigo().equals("C1") ||
                            cartaOne.getCodigo().equals("E1") || cartaOne.getCodigo().equals("F1")|| cartaOne.getCodigo().equals("H1")){
                        return 1;
             }
            else{
                return  -1;
            }
           
        }
        else if(cartaOne.getDecomposicao() > cartaSecond.getDecomposicao()){
            return 1;
        }
        else if(cartaOne.getDecomposicao() == cartaSecond.getDecomposicao()){
            return 0;
        }
        else{
            return -1;
        }
    }
   

}