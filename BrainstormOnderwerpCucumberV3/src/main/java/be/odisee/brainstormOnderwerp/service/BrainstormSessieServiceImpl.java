package be.odisee.brainstormOnderwerp.service;

import java.util.ArrayList;

import be.odisee.brainstormOnderwerp.domain.*;

public class BrainstormSessieServiceImpl implements BrainstormSessieService {

    private ArrayList<Sessie> m_Sessies = new ArrayList<Sessie>();

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
            newBijdrage = onderwerp.voegBijdrageToe(deelnemer, type, reactieOp, tekst);
        } catch (Exception ex) {
            System.out.println("ERROR: bijdrage '" + tekst + "' toevoegen is niet gelukt.");
            ex.printStackTrace();
        }
        return newBijdrage;
     }

	public Bijdrage zoekBijdrageBijOnderwerpVolgensTekst(Sessie sessie, String onderwerptitel, String ideetekst) {

		Onderwerp hetOnderwerp = zoekOnderwerpVolgensTitel(sessie, onderwerptitel);

		for (Bijdrage b : hetOnderwerp.getBijdragen()) {
			if (b.getTekst().equals(ideetekst)) return b;
		}

		return null;
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





















