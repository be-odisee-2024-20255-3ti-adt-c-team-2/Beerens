package org.example.autos;

import java.util.Date;

public class AnalyseMarktvraag {
    private int id;
    private String status;
    private Date datum;
    private String beschrijving;

    public AnalyseMarktvraag(int id, String status, Date datum, String beschrijving) {
        this.id = id;
        this.status = status;
        this.datum = datum;
        this.beschrijving = beschrijving;
    }

    public void vervang() {
        this.status = "Vervangen";
    }

    public String getStatus() {
        return this.status;
    }

}