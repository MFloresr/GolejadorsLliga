import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Processar extends DefaultHandler {

    private static String NOM_JUGADOR=("jugador");
    private static String NOM_NOM=("nom");
    private static String NOM_GOLS=("gols");
    private static String NOM_EQUIPS=("equips");

    private static boolean JUGADOR_OK=false;
    private static boolean NOM_OK=false;
    private static boolean GOLS_OK=false;
    private static boolean EQUIPS_OK=false;

    ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    ArrayList<Club> clubes = new ArrayList<Club>();
    Set<String> clubs =new HashSet<String>();
    int gols=0;
    int golestotales;
    int golesclub;
    String nombrejugador;
    String nombreclub;



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase(NOM_JUGADOR)){
            JUGADOR_OK=true;
        }if(qName.equalsIgnoreCase(NOM_NOM)){
            NOM_OK=true;
        }if(qName.equalsIgnoreCase(NOM_GOLS)) {
            GOLS_OK= true;
        }if(qName.equalsIgnoreCase(NOM_EQUIPS)){
            EQUIPS_OK=true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(JUGADOR_OK && NOM_OK && EQUIPS_OK==false){
            nombrejugador= new String(ch, start, length);
        }if(JUGADOR_OK && NOM_OK && EQUIPS_OK) {
            nombreclub = new String(ch,start,length);
            clubs.add(nombreclub);
        }if(JUGADOR_OK && GOLS_OK && EQUIPS_OK==false){
            golestotales= new Integer(new String(ch, start, length));

        }if(JUGADOR_OK && GOLS_OK && EQUIPS_OK){
            golesclub= new Integer(new String(ch, start, length));
            Jugador jugador = new Jugador(nombrejugador, golesclub, nombreclub);
            jugadores.add(jugador);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase(NOM_JUGADOR)){
            JUGADOR_OK = false;
        }if(qName.equalsIgnoreCase(NOM_NOM)){
            NOM_OK = false;
        }if(qName.equalsIgnoreCase(NOM_GOLS)){
            GOLS_OK = false;
        }if(qName.equalsIgnoreCase(NOM_EQUIPS)){
            EQUIPS_OK = false;
        }
    }

    @Override
    public void endDocument() throws SAXException {

        for(Object object : clubs) {
            String nombre = (String) object;
            Club club =new Club(nombre);
            clubes.add(club);
        }

        for(int i = 0; i<clubes.size();i++){
            for(int x = 0; x<jugadores.size();x++){
                if(clubes.get(i).getNombre().equals(jugadores.get(x).getClub())){
                    clubes.get(i).addjuagdor(jugadores.get(x));
                    gols = gols+ jugadores.get(x).getGols();
                    clubes.get(i).setGols(gols);
                }
            }
            gols=0;
        }
        Collections.sort(clubes);
        for(Club c:clubes) {
            System.out.println(c);
        }

    }
}

