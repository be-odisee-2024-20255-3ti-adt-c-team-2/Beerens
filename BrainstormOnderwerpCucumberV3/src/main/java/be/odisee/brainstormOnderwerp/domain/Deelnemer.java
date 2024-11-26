package be.odisee.brainstormOnderwerp.domain;

import java.util.ArrayList;

public class Deelnemer extends Rol {

    private ArrayList<Bijdrage> m_Bijdragen;

    public Deelnemer(){}

    public Deelnemer(String status, String usernaam, Sessie sessie){
        super(status,usernaam,sessie);
    }

    public Deelnemer(int id, String status, String usernaam, Sessie sessie){
        super(id,status,usernaam,sessie);
    }

    public ArrayList<Bijdrage> getBijdragen(){
            return m_Bijdragen;
    }

    public void voegBijdrageToe(Bijdrage newVal){
            m_Bijdragen.add(newVal);
    }

}