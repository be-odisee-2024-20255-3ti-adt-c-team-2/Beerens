package be.odisee.brainstormOnderwerp.domain;


import java.util.Date;

public class Levering {
    private int id;
    private Date leverdatum;
    private Bestelling bestelling;

    public Levering(int id, Date leverdatum, Bestelling bestelling) {
        this.id = id;
        this.leverdatum = leverdatum;
        this.bestelling = bestelling;
    }
}