import java.time.LocalDate;
import java.util.Arrays;

public class Jugador {
    //atributos
    private String nombre;
    private LocalDate fechaNacimiento;
    private Carta[] mano;

    //
    public Jugador(String nombre, LocalDate fechaNacimiento){
        mano = new Carta[0]; //crea un array con 0
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    public String getNombre(){ return nombre;}

    public void anyadirCarta(Carta carta){
       mano = Arrays.copyOf(mano,mano.length+1); //copia el array y le añade una posicion
       mano[mano.length-1] = carta; //en la posicion length-1 le añade la carta
    }

    public int obtenerPuntuacion(){
//        //contar a partir de las cartas de la mano y devolver la puntuacion
//        int puntos = 0;
//        for(Carta carta: mano){
//            puntos += carta.getNumero().getPuntuacion();
//        }
////        if (puntos > 21){
////            return -1;
////
////        }
////        return puntos;
//        return(puntos>21)?-1:puntos;
        return obtenerPuntuacionRecursiva(0,0);
    }

    public int obtenerPuntuacionRecursiva(int index, int suma){
        if(suma>21)
            return -1;
        if(index>=mano.length)
            return suma;
        if(mano[index].getNumero().getPuntuacion().length==1)
            return obtenerPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getPuntuacion()[0]);
        return Math.max(
             obtenerPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getPuntuacion()[0]),
             obtenerPuntuacionRecursiva(index+1,suma+mano[index].getNumero().getPuntuacion()[1])
        );

    }
    @Override
    public String toString(){
        //devolver nombre + mano
        return "Jugador: " + nombre + " puntuación: "+ obtenerPuntuacion()+
                " mano: " + Arrays.toString(mano);
    }
}
