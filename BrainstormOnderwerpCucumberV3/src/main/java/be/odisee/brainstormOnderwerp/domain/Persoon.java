package be.odisee.brainstormOnderwerp.domain;

import java.util.ArrayList;

public class Persoon {

    private int id;
    private static int nextid=1;
    private String status;
    private String voornaam;
    private String familienaam;
    private String emailadres;
    private String paswoord;
    private ArrayList<Rol> m_Rollen= new ArrayList<Rol>();

    public Persoon(){

    }

    public Persoon(String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.id = this.nextid++;
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }

    public Persoon(int id, String status, String voornaam, String familienaam, String emailadres, String paswoord) {
        this.id = id;
        this.status = status;
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.emailadres = emailadres;
        this.paswoord = paswoord;
    }

    public int getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public ArrayList<Rol> getRollen(){
        return m_Rollen;
    }

    public Rol voegRolToe(int id, String status, String type, String usernaam, Sessie sessie){
        Rol newRol=null;
        if (type.equals("Deelnemer")) newRol= new Deelnemer(id, status, usernaam, sessie);
        if (type.equals("Facilitator")) newRol= new Facilitator(id, status, usernaam, sessie);
        m_Rollen.add(newRol);
        return newRol;
    }

}