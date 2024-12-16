import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    //atributo
    private Carta[] cartas;

    public Baraja(){
        cartas = new Carta[Palo.values().length*Numero.values().length];
        //values te transforma el palo en un array, devuelve un array con todos los palos.
        int posicion = 0;
        for(Palo palo:Palo.values()){ //Foreach devuelve un array con los palos.
            for (Numero numero: Numero.values()){
                cartas[posicion] = new Carta(palo,numero);
                posicion++;
            }
        }
        barajar();
    }
    private void barajar(){
        List listaCartas = Arrays.asList(cartas);
        Collections.shuffle(listaCartas);
        listaCartas.toArray(cartas);

    }
    public Carta repartirEncima(){
        Carta carta = null;
        if(cartas.length>0){
            carta = cartas[0];
            cartas = Arrays.copyOfRange(cartas,1,cartas.length);
        }
        return carta;
    }
    @Override
    public String toString(){return Arrays.toString(cartas);}
}
