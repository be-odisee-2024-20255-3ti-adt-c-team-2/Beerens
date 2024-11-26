package be.odisee.brainstormOnderwerp.service;


import be.odisee.brainstormOnderwerp.domain.Autosoort;
import be.odisee.brainstormOnderwerp.domain.Bestelling;
import be.odisee.brainstormOnderwerp.domain.LogistiekManager;

public interface VoorraadService {

    Bestelling plaatsBestelling(Autosoort autosoort, int hoeveelheid);

    boolean annuleerBestelling(Bestelling bestelling);

    Autosoort zoekAutosoortOpNaam(String naam);

    String controleerVoorraad(Autosoort autosoort);

    void updateVoorraadniveau(Autosoort autosoort, int nieuweVoorraad);

    void markeerBestellingAlsAfgerond(Bestelling bestelling);

    Autosoort haalVoertuigOp(String voertuigNaam);

    void wijzigMinimumDrempel(Autosoort voertuig, int nieuweDrempel);

    boolean stuurMeldingNaarInkoop(Autosoort voertuig);

    boolean stuurOvervoorraadMelding(LogistiekManager manager, Autosoort voertuig);

    boolean isOptieBeschikbaar(String optie);

    void controleerMinimumdrempel(int nieuweMinDrempel) throws IllegalArgumentException;

}
