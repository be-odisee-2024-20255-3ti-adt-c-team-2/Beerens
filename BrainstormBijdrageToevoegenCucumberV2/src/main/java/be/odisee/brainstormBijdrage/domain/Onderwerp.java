package be.odisee.brainstormBijdrage.domain;

import java.util.ArrayList;

public class Onderwerp {

    private int id;
    private String status;
    private String titel;
    private Facilitator m_Facilitator;
    private Onderwerp vorigOnderwerp;
    private ArrayList<Bijdrage> m_Bijdragen = new ArrayList<Bijdrage>();

    public Onderwerp(){}

    public Onderwerp(int id, String status, String titel, Facilitator facilitator) {
        this.id =id;
        this.status=status;
        this.titel=titel;
        this.m_Facilitator=facilitator;
    }

    public String getStatus() {
        return status;
    }

    public String getTitel() {
        return titel;
    }

    public Onderwerp getvorigOnderwerp(){
        return vorigOnderwerp;
    }

    public void setvorigOnderwerp(Onderwerp newVal){
        vorigOnderwerp = newVal;
    }

    public ArrayList<Bijdrage> getBijdragen(){
        return m_Bijdragen;
    }

    public Bijdrage voegBijdrageToe(Deelnemer deelnemer, String type, Bijdrage reactieOp, String tekst) 
            throws Exception{
    	
    	
    	if (status.equals("gesloten")) return null;

        Bijdrage newBijdrage=null;
        if (type.equalsIgnoreCase("Idee")) newBijdrage= new Idee(0, "actief", deelnemer, reactieOp, tekst);
        if (type.equalsIgnoreCase("Reactie")) newBijdrage= reactieOp.voegReactieToe(deelnemer, tekst);
        m_Bijdragen.add(newBijdrage);
        return newBijdrage;
    }

    public void veranderOnderwerp(){
    	if (status.equals ("vorig")) status = "gesloten";
    	if (status.equals("actueel")) status = "vorig";       
    }

    void toonOnderwerpResultaten() {
        // bedoeld voor preliminaire testen
        System.out.println();
        for (Bijdrage bijdrage : m_Bijdragen){
            System.out.println("Bijdrage: '"+bijdrage.getTekst()+"'");
        }
    }
}











