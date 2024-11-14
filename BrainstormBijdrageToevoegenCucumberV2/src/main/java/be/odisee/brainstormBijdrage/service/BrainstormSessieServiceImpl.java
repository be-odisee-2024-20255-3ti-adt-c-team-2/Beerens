package be.odisee.brainstormBijdrage.service;

import java.util.ArrayList;

import be.odisee.brainstormBijdrage.domain.*;

public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private ArrayList<Sessie> m_Sessies = new ArrayList<Sessie>();
    
    private String foutmelding;

    public BrainstormSessieServiceImpl(){}

    public void voegSessieToe(Sessie newVal){
        m_Sessies.add(newVal);
    }

    public ArrayList<Sessie> getSessies(){
        return m_Sessies;
    }

    public Onderwerp voegOnderwerpToe(Sessie sessie, Facilitator facilitator, String titel){
        Onderwerp newOnderwerp = sessie.voegOnderwerpToe(facilitator, sessie.getActueelOnderwerp(), titel);
        return newOnderwerp;
    }

	public Onderwerp zoekOnderwerpVolgensTitel(Sessie sessie, String titel) {
		
		for (Onderwerp onderwerp : sessie.getOnderwerpen()){
			if (onderwerp.getTitel().equals(titel)) return onderwerp;
		}

		return null;
	}
    
    public Bijdrage voegBijdrageToe(Onderwerp onderwerp, Deelnemer deelnemer, String type, Bijdrage reactieOp, String tekst){
        Bijdrage newBijdrage=null;
        try {
        	// tekst van een bijdrage mag niet blanco zijn
            if ((tekst == null) || (tekst.equals("")) || (tekst.equals(" "))) 
            	throw new RuntimeException("Bijdrage mag niet blanco zijn");
            newBijdrage = onderwerp.voegBijdrageToe(deelnemer, type, reactieOp, tekst);
        } catch (Exception ex) {
            setFoutmelding("ERROR: bijdrage '" + tekst + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }
        return newBijdrage;
     }
   
	public Bijdrage zoekBijdrageBijOnderwerpVolgensTekst(Sessie sessie, String onderwerptitel, String bijdragetekst) {
		
		Onderwerp hetOnderwerp = zoekOnderwerpVolgensTitel(sessie, onderwerptitel);
		
		for (Bijdrage b : hetOnderwerp.getBijdragen()) {
			if (b.getTekst().equals(bijdragetekst)) return b;
		}

		return null;
	}

	public String getFoutmelding() {
		return foutmelding;
	}

	public void setFoutmelding(String foutmelding) {
		this.foutmelding = foutmelding;
	}

    public void toonSessieResultaten(Sessie sessie){
        // bedoeld voor preliminaire testen
        System.out.println("\nResultaten voor sessie: ");
        sessie.toonSessieResultaten();
    }

    public boolean verwijderBijdrage(Bijdrage bjdrage){
        return false;
    }

}





















