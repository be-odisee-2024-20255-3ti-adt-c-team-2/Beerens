package be.odisee.brainstormOnderwerp.domain;

import java.util.ArrayList;

public class Facilitator extends Rol {

    private ArrayList<Onderwerp> m_Onderwerpen;

    public Facilitator(){}

    public Facilitator(String status, String usernaam, Sessie sessie){
        super(status,usernaam, sessie);
    }

    public Facilitator(int id, String status, String usernaam, Sessie sessie){
        super(id,status,usernaam, sessie);
    }

    public ArrayList<Onderwerp> getOnderwerpen(){
            return m_Onderwerpen;
    }

    public void voegOnderwerpToe(Onderwerp newVal){
            m_Onderwerpen.add(newVal);
    }
}