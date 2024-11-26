package be.odisee.brainstormOnderwerp.domain;

public class Reactie extends Bijdrage {

    private Bijdrage reactieOp;

    public Reactie(){}

    public Reactie(int id, String status, Deelnemer deelnemer, Bijdrage reactieOp, String tekst) throws Exception {
        super(id, status, deelnemer, reactieOp, tekst);
        if (reactieOp == null) throw new Exception("FOUT: van een reactie moet gegeven zijn waarop gereageerd wordt");
    }

    public Bijdrage getReactieOp(){
        return reactieOp;
    }

    public void setReactieOp(Bijdrage newVal){
        reactieOp = newVal;
    }


}