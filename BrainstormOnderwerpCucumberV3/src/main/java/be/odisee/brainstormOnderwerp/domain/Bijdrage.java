package be.odisee.brainstormOnderwerp.domain;

import java.util.ArrayList;

public abstract class Bijdrage {

    protected int id;
    protected String status;
    protected String tekst;
    protected Deelnemer m_Deelnemer;
    protected Bijdrage m_ReactieOp;
    private ArrayList<Reactie> m_Reacties = new ArrayList<Reactie>();


    public Bijdrage(){}

    public Bijdrage(int id, String status, Deelnemer m_Deelnemer, Bijdrage reactieOp, String tekst) {
        this.id = id;
        this.status = status;
        this.m_Deelnemer = m_Deelnemer;
        if (reactieOp != null) this.m_ReactieOp = reactieOp;
        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public Reactie voegReactieToe(Deelnemer deelnemer, String tekst) throws Exception{
        Reactie newReactie=null;
        newReactie= new Reactie(id, "actief", deelnemer, this, tekst);
        m_Reacties.add(newReactie);
        return newReactie;
    }

    public ArrayList<Reactie> getReacties() {
        return m_Reacties;
    }

    public boolean verwijderBijdrage(){
        /* moet nog uitgewerkt worden */
        return false;
    }

    public boolean verwijderReactie(Reactie deReactie){
        /* moet nog uitgewerkt worden */
        return false;
    }

}