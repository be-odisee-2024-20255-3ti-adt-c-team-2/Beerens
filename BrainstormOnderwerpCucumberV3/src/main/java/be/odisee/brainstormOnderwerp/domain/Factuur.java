package be.odisee.brainstormOnderwerp.domain;

public class Factuur {
    private int id;
    private String details;

    public Factuur(int id, String details) {
        this.id = id;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}