public class Carta {
    //ATRIBUTOS
    private Palo palo;
    private Numero numero;

    //CONSTRUCTOR
    public Carta(Palo palo, Numero numero){
        this.numero = numero;
        this.palo = palo;
    }

    //GETTER
    public Numero getNumero(){return numero;}
    public Palo getPalo(){return palo;}

    @Override
    public String toString(){
        return numero.toString()+palo.toString();
    }

}
