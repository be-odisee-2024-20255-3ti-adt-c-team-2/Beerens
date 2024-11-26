package be.odisee.brainstormOnderwerp.domain;

public class Idee extends Bijdrage {

    private Bijdrage reactieOp;

    public Idee(){

    }

    public Idee(int id, String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst) {
        super(id, status, deelnemer, reactieOp, tekst);
    }

    public Bijdrage getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bijdrage newVal){
        reactieOp = newVal;
    }

}