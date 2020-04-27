package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        if(karten != null && Spiel.kartenStapel.size()>1){
            List<Karte> tempStapel = Spiel.kartenStapel.subList(0,Spiel.kartenStapel.size()-2);
            Spiel.kartenStapel.removeAll(tempStapel);
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

        }
        image = new Image(getClass().getResource("/karten/"+farbe+"_"+symbol+".png").toExternalForm());
    }

    public Image getImage(){
        return image;
    }

    /**
     *
     * @return 0 nichts
     * @return 1 tafn
     * @return 2 auklaubm
     * @return 3 auslossn
     */
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
