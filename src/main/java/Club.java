import java.util.ArrayList;

public class Club implements Comparable<Club>{

    private String nombre;
    private int gols;
    private ArrayList<Jugador> jugadores;

    public Club(String nombre){
        this.nombre=nombre;
        this.jugadores = new ArrayList<Jugador>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public void addjuagdor(Jugador jugador){
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        return "Club{" +
                "nombre='" + nombre + '\'' +
                ", gols=" + gols +
                ", jugadores=" + jugadores +
                '}';
    }

    @Override
    public int compareTo(Club o) {
        if (gols < o.gols) {
            return 1;
        }
        if (gols > o.gols) {
            return -1;
        }
        return 0;
    }
}
