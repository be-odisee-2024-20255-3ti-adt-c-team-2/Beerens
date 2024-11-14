package be.odisee.brainstormBijdrage.service;

import be.odisee.brainstormBijdrage.domain.*;

public interface BrainstormSessieService {

	Onderwerp voegOnderwerpToe(Sessie sessie, Facilitator facilitator, String titel);
	
	Onderwerp zoekOnderwerpVolgensTitel (Sessie sessie, String titel);

	Bijdrage voegBijdrageToe
                (Onderwerp onderwerp, Deelnemer deelnemer, String type, Bijdrage reactieOp, String tekst);

	Bijdrage zoekBijdrageBijOnderwerpVolgensTekst(Sessie sessie, String onderwerptitel,String bijdragetekst);

	boolean verwijderBijdrage(Bijdrage bjdrage);

    void toonSessieResultaten(Sessie sessie);

	void setFoutmelding(String string);

	String getFoutmelding();

}