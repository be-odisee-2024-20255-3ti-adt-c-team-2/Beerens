package org.example.verkoop;

import org.example.autos.Autosoort;
import org.example.personeel.BeerensMedewerker;
import org.example.personeel.Factuur;

import java.util.Date;

public class Verkoop {
    private int id;
    private String status;
    private Date verkoopDatum;
    private Autosoort autosoort;
    private Factuur factuur;
    private BeerensMedewerker verkoper;

    public Verkoop(int id, String status, Date verkoopDatum, Autosoort autosoort, Factuur factuur, BeerensMedewerker verkoper) {
        this.id = id;
        this.status = status;
        this.verkoopDatum = verkoopDatum;
        this.autosoort = autosoort;
        this.factuur = factuur;
        this.verkoper = verkoper;
    }

    public void annuleer() {
        this.status = "Geannuleerd";
    }

    public void registreer() {
        this.status = "Geregistreerd";
    }
}