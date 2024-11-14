package org.example.autos;

import org.example.bestelling.Bestelling;

public class Autosoort {
    private int id;
    private String status;
    String naam;
    String merk;
    private int huidigVoorraadniveau;
    private int minimumpeiler;
    private int maximumpeiler;
    private AnalyseMarktvraag marktvraag;

    public Autosoort(int id, String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        this.id = id;
        this.naam = naam;
        this.merk = merk;
        this.huidigVoorraadniveau = huidigVoorraadniveau;
        this.minimumpeiler = minimumpeiler;
        this.maximumpeiler = maximumpeiler;
        this.status = "Beschikbaar";
    }

    public void isVerkocht() {
        this.status = "Verkocht";
    }

    public void voegAnalyseMarktvraagToe(String beschrijving) {
        this.marktvraag = new AnalyseMarktvraag(1, "Actief", new java.util.Date(), beschrijving);
    }

    public Bestelling voegBestellingToe(int hoeveelheid) {
        return new Bestelling(1, "Nieuw", this, hoeveelheid, new java.util.Date(), null, null);
    }

    public void bestellingAfgerond() {
        this.status = "Afgerond";
    }

    public int getHuidigVoorraadniveau() {
        return this.huidigVoorraadniveau;
    }

    public int getMinimumpeiler() {
        return this.minimumpeiler;
    }

    public int getMaximumpeiler() {
        return this.maximumpeiler;
    }

    public AnalyseMarktvraag getMarktvraag() {
        return this.marktvraag;
    }

    public void updateVoorraad(int nieuweVoorraad) {
        this.huidigVoorraadniveau = nieuweVoorraad;
    }

    public void setMinimumpeiler(int nieuweMinimumpeiler) {
        if (nieuweMinimumpeiler <= maximumpeiler) {
            this.minimumpeiler = nieuweMinimumpeiler;
        } else {
            throw new IllegalArgumentException("Minimumpeiler kan niet hoger zijn dan maximumpijler.");
        }
    }

    public String checkVoorraadEnMeldOnderMinimum() {
        if (huidigVoorraadniveau < minimumpeiler) {
            return "De voorraad ligt onder de minimumpeiler";
        }
        return "Voorraad is binnen de veilige marges";
    }

    public String stuurBerichtNaarVoorraadinkoper() {
        if (huidigVoorraadniveau < minimumpeiler) {
            return "Bestel meer auto's van deze autosoort";
        }
        return "Geen bestelling nodig";
    }
}