import java.time.LocalDate;

public class Juego {
    //atributos
    private Baraja baraja; //crea una baraja con cartas barajadas
    private Jugador[] jugadores;
    private Jugador banca;

    public Juego(Jugador[] jugadores){
        this.jugadores = jugadores;
        baraja = new Baraja();
        banca = new Jugador("Banca", LocalDate.now());

    }
    public void start(){
        //reparto inicial
        for(Jugador jugador: jugadores){
            repartoInicial(jugador);
        }
        repartoInicial(banca);

        //jugar todos los jugadores
        for(Jugador jugador: jugadores){
            juegaJugador(jugador);
        }
        juegaBanca(banca);
        mostrarGanador();
    }
    private void repartoInicial(Jugador player){
        player.anyadirCarta(baraja.repartirEncima());
        player.anyadirCarta(baraja.repartirEncima());
    }

    private void juegaJugador(Jugador player){
        //repartir cartas mientras el jugador diga que si Y puntuacion sea -1
        System.out.println("Turno para " +player.getNombre());
        System.out.println(player);
        char option = Input.getString("¿Otra carta?(Y para si, cualquier otro valor para no: ")
                .toUpperCase().charAt(0);
        while(option=='Y' && player.obtenerPuntuacion()>=0){
            player.anyadirCarta(baraja.repartirEncima());
            //con la baraja ya creada y barajada,
            // coje la carta de la primera posicion, la devuelve y la añade a la mano
            System.out.println(player);
            if(player.obtenerPuntuacion()>=0){
                option = Input.getString("¿Otra carta?(Y para si, cualquier otro valor para no: ")
                        .toUpperCase().charAt(0);
            }else{
                System.out.println(player.getNombre() + " te has pasado!!");
            }

        }
    }
    private void juegaBanca(Jugador player){
        int maxPuntuacion=maxPuntuacionJugadores();
        System.out.println("Turno para " + player.getNombre());
        System.out.println(player);
        while(player.obtenerPuntuacion()<maxPuntuacion){
            player.anyadirCarta(baraja.repartirEncima());
            System.out.println(player);
            if(player.obtenerPuntuacion()<0)
                System.out.println(player.getNombre() + " te has pasado !!");
        }
    }
    private void esperar(long millis){
        try{
            Thread.sleep(millis);
        } catch (Exception e){

        }
    }

    private int maxPuntuacionJugadores(){
        int mayor = Integer.MIN_VALUE;
        for(Jugador jugador:jugadores){
            if(jugador.obtenerPuntuacion()>mayor){
                mayor = jugador.obtenerPuntuacion();
            }
        }
        return mayor;
    }

    private void mostrarGanador(){
        int maxPuntuacion = maxPuntuacionJugadores();
        if(banca.obtenerPuntuacion() == maxPuntuacion){
            System.out.println("La banca gana");
        }else{
            for(Jugador jugador:jugadores){
                if(jugador.obtenerPuntuacion()==maxPuntuacion)
                    System.out.println("Jugador" + jugador.getNombre() + " ha ganado");
            }
        }
    }

}
