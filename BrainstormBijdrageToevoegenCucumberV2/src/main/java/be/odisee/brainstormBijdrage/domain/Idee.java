package be.odisee.brainstormBijdrage.domain;

public class Idee extends Bijdrage {

    public Idee(){

    }

    public Idee(int id, String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst) {
        super(id, status, deelnemer, reactieOp, tekst);
    }

}