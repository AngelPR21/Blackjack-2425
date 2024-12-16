public enum Numero {
    AS("A",1),
    DOS("2",2),
    TRES("3",3),
    CUATRO("4",4),
    CINCO("5",5),
    SEIS("6",6),
    SIETE("7",7),
    OCHO("8",8),
    NUEVE("9",9),
    DIEZ("10",10),
    JACK("J",10),
    QUEEN("Q",10),
    KING("K",10);

    private final String tipo;
    private final int puntuacion;
    Numero(String tipo, int puntuacion){
        this.puntuacion=puntuacion;
        this.tipo=tipo;
    }

    public int getPuntuacion(){return puntuacion;}

    @Override
    public String toString(){
        return tipo;
    }

}
