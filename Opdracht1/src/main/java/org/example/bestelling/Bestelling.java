package org.example.bestelling;

import org.example.autos.Autosoort;
import org.example.personeel.Factuur;

import java.util.Date;
import java.util.UUID;

/**
 * Vertegenwoordigt een bestelling van een specifiek autotype met details zoals status, hoeveelheid,
 * besteldatum en verwachte leverdatum.
 */
public class Bestelling {
    private int id;
    private String status;
    private Autosoort autosoort;
    private int hoeveelheid;
    private Date besteldatum;
    private Factuur factuur;
    private Date verwachteLeverdatum;
    private boolean isFinal;

    /**
     * Maakt een instantie van Bestelling met de opgegeven autotype en hoeveelheid.
     *
     * @param autosoort  het autotype dat besteld wordt
     * @param hoeveelheid de hoeveelheid van de bestelling
     */
    public Bestelling(Autosoort autosoort, int hoeveelheid) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.status = "In afwachting";
        this.autosoort = autosoort;
        this.hoeveelheid = hoeveelheid;
        this.verwachteLeverdatum = verwachteLeverdatum;
    }

    /**
     *  Wijzigt de status naar "Geannuleerd".
     */
    public void annuleer() {
        this.status = "Geannuleerd";
        this.isFinal = true;  // Mark the object as in the final state
    }

    /**
     * Plaatst de bestelling. Wijzigt de status naar "Besteld" als de voorwaarden voldoen.
     * Annuleert de bestelling als de hoeveelheid ongeldig is of de status niet in afwachting is.
     */
    public void bestel() {
        if (hoeveelheid > 0 && "In afwachting".equals(status)) { // Controleer beide voorwaarden
            this.status = "Besteld";
            this.besteldatum = new Date();;
            //this.factuur = factuur;
            //Date verwachteLeverdatum
        } else {
            annuleer();
        }
    }

    /**
     * Geeft de huidige status van de bestelling terug.
     *
     * @return de status van de bestelling
     */
    public String getStatus() {
        return status;
    }

    /**
     * Stelt de status van de bestelling in.
     *
     * @param status de nieuwe status van de bestelling
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Markeert de bestelling als afgerond door de status aan te passen.
     */
    public void markeerAlsAfgerond() {
        this.status = "Afgerond";
    }

    /**
     * Geeft een Levering-object terug dat de levering van deze bestelling vertegenwoordigt.
     *
     * @return een Levering-object met de leverdatum en deze bestelling
     */
    public Levering isGeleverd() {
        return new Levering(new Date(), this);
    }

    /**
     * Controleert of de bestelling in de definitieve staat is.
     *
     * @return true als de bestelling definitief is, anders false
     */
    public boolean isFinal() {
        return isFinal;
    }
}