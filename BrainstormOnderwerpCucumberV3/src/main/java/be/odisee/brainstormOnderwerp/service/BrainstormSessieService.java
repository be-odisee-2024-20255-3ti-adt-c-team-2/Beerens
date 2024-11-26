package be.odisee.brainstormOnderwerp.service;

import be.odisee.brainstormOnderwerp.domain.*;

public interface BrainstormSessieService {

	Onderwerp voegOnderwerpToe(Sessie sessie, Facilitator facilitator, String titel);

	Onderwerp zoekOnderwerpVolgensTitel (Sessie sessie, String titel);

	Bijdrage voegBijdrageToe
                (Onderwerp onderwerp, Deelnemer deelnemer, String type, Bijdrage reactieOp, String tekst);

	Bijdrage zoekBijdrageBijOnderwerpVolgensTekst(Sessie sessie, String onderwerptitel,String ideetekst);

	boolean verwijderBijdrage(Bijdrage bjdrage);

    void toonSessieResultaten(Sessie sessie);


}