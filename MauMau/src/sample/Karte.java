package sample;

public class Karte {

    String farbe;
    String symbol;

    public Karte(String farbe, String symbol) {
        this.farbe = farbe;
        this.symbol = symbol;
    }
    public String toString() {
        return farbe + " " + symbol;
    }
}
