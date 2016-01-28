
public class Jugador {

    private String nombre;
    private int gols;
    private String club;

    public Jugador(String nombre, int goles, String club){
        this.nombre=nombre;
        this.gols=goles;
        this.club=club;
    }

    public String getNombre() {
        return nombre;
    }

    public int getGols() {
        return gols;
    }

    public String getClub() {
        return club;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", gols=" + gols +
                ", club='" + club + '\'' +
                '}';
    }
}
