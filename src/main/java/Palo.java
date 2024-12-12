import static com.diogonunes.jcolor.Ansi.colorize;
public enum Palo {
    PICA(Color.NEGRO,"\u2660"),
    DIAMANTE(Color.ROJO,"\u2666"),
    TREBOL(Color.NEGRO,"\u2663"),
    CORAZON(Color.ROJO,"\u2665");
    private Color color;
    private String tipo;

    Palo(Color color, String tipo){
        this.color = color;
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return colorize(tipo,color.getColor());
    }
}
