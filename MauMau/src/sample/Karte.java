package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Karte {
    public static String[] FARBEN = new String[]{"h", "l", "e", "s"};
    public static int[] WERTE = new int[]{14, 13, 12, 11, 10, 9, 8, 7};

    private static ArrayList<Karte> karten;

    public static void erstelleKartenStapel(){
        karten = new ArrayList<>();
        for (int i = 0; i < FARBEN.length; i++) {
            for (int j = 0; j < WERTE.length; j++) {
                karten.add(new Karte(FARBEN[i], WERTE[j]));
            }
        }
        Collections.shuffle(karten);
    }

    public static Karte getKarte(){
        if(karten!=null && karten.size()>0) {
            return karten.remove(0);
        }
        if(karten != null && ControllerPlayScreen.kartenStapel.size()>1){
            List<Karte> tempStapel = ControllerPlayScreen.kartenStapel.subList(0,ControllerPlayScreen.kartenStapel.size()-2);
            ControllerPlayScreen.kartenStapel.removeAll(tempStapel);
            karten.addAll(tempStapel);
            Collections.shuffle(karten);
            return karten.remove(0);
        }
        return null;
    }


    private String farbe;
    private int  symbol;
    private Image image;
    private int effect;

    private Karte(String farbe, int symbol) {
        this.farbe = farbe;
        this.symbol = symbol;
        switch (symbol){
            case 12:
                effect=11;
                break;
            case 9:
                effect=1;
                break;
            case 14:
                effect=3;
                break;
            default:
                effect=0;
                break;
        }
        image = new Image(getClass().getResource("/img/karten/" +farbe+"_"+symbol+".png").toExternalForm());
    }

    public Image getImage(){
        return image;
    }


    public int getEffect(){
        return effect;
    }

    public String getFarbe(){
        return farbe;
    }

    public int getSymbol(){
        return symbol;
    }

    public String toString() {
        return farbe + " " + symbol;
    }
}
