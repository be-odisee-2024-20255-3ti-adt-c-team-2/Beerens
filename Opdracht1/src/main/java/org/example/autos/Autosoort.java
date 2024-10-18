package org.example.autos;

import org.example.bestelling.Bestelling;

public class Autosoort {
    private int id;
    private String status;
    private String naam;
    private String merk;
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

    public AnalyseMarktvraag getMarktvraag() {
        return this.marktvraag;
    }

    public void updateVoorraad(int nieuweVoorraad) {
        this.huidigVoorraadniveau = nieuweVoorraad;
    }

}