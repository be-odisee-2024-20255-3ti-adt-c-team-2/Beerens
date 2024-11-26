package be.odisee.brainstormOnderwerp.domain;

import java.util.Date;


public class Bestelling {
    private int id;
    private String status;
    private Autosoort autosoort;
    private int hoeveelheid;
    private Date besteldatum;
    private Factuur factuur;
    private Date verwachteLeverdatum;

    public Bestelling(int id, String status, Autosoort autosoort, int hoeveelheid, Date besteldatum, Factuur factuur, Date verwachteLeverdatum) {
        this.id = id;
        this.status = status;
        this.autosoort = autosoort;
        this.hoeveelheid = hoeveelheid;
        this.besteldatum = besteldatum;
        this.factuur = factuur;
        this.verwachteLeverdatum = verwachteLeverdatum;
    }

    public void annuleer() {
        this.status = "Geannuleerd";
    }

    public void bestel() {
        if (hoeveelheid > 0 && "In behandeling".equals(status)) { // Controleer beide voorwaarden
            this.status = "Besteld";
        } else {
            this.status = "Niet besteld"; // Status als de hoeveelheid 0 of minder is of status niet "In behandeling"
        }
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void markeerAlsAfgerond() {
        this.status = "Afgerond";
    }


    public Levering isGeleverd() {
        return new Levering(this.id, new Date(), this);
    }
}