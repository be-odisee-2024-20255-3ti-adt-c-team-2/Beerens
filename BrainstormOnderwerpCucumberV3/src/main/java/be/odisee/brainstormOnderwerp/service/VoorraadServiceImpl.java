package be.odisee.brainstormOnderwerp.service;

import be.odisee.brainstormOnderwerp.domain.Autosoort;
import be.odisee.brainstormOnderwerp.domain.Bestelling;
import be.odisee.brainstormOnderwerp.domain.LogistiekManager;

import java.util.ArrayList;
import java.util.List;

public class VoorraadServiceImpl implements VoorraadService {

    private List<Autosoort> autosoorten = new ArrayList<>();
    private List<Bestelling> bestellingen = new ArrayList<>();

    @Override
    public Bestelling plaatsBestelling(Autosoort autosoort, int hoeveelheid) {
        if (hoeveelheid <= 0) {
            throw new IllegalArgumentException("Hoeveelheid moet groter dan 0 zijn.");
        }
        Bestelling nieuweBestelling = autosoort.voegBestellingToe(hoeveelheid);
        bestellingen.add(nieuweBestelling);
        return nieuweBestelling;
    }

    @Override
    public boolean annuleerBestelling(Bestelling bestelling) {
        if (bestelling.getStatus().equals("Afgerond")) {
            return false; // Kan geen afgeronde bestelling annuleren
        }
        bestelling.annuleer();
        return true;
    }

    @Override
    public Autosoort zoekAutosoortOpNaam(String naam) {
        for (Autosoort autosoort : autosoorten) {
            if (autosoort.naam.equals(naam)) {
                return autosoort;
            }
        }
        return null;
    }

    @Override
    public String controleerVoorraad(Autosoort autosoort) {
        // Eerst controleren of de minimumpeiler geldig is
        if (autosoort.getMinimumpeiler() < 3) {
            return "Minimumpijler wordt niet geaccepteerd, waarde moet groter of gelijk aan 3 zijn";
        }

        // Als de minimumpeiler geldig is, gaan we de voorraad controleren
        return autosoort.checkVoorraadEnMeldOnderMinimum();
    }


    @Override
    public void updateVoorraadniveau(Autosoort autosoort, int nieuweVoorraad) {
        autosoort.updateVoorraad(nieuweVoorraad);
    }

    @Override
    public void markeerBestellingAlsAfgerond(Bestelling bestelling) {
        bestelling.markeerAlsAfgerond();
    }

    @Override
    public Autosoort haalVoertuigOp(String voertuigNaam) {
        // Simulatie van ophalen
        return new Autosoort(1, voertuigNaam, "Tesla", 7, 3, 10);
    }

    @Override
    public boolean stuurMeldingNaarInkoop(Autosoort voertuig) {
        String melding = voertuig.stuurBerichtNaarVoorraadinkoper();
        return !melding.contains("Geen bestelling nodig");
    }

    @Override
    public boolean stuurOvervoorraadMelding(LogistiekManager manager, Autosoort voertuig) {
        manager.waarschuwVoorraad("Overvoorraad gedetecteerd voor " + voertuig.naam);
        return true;
    }

    @Override
    public boolean isOptieBeschikbaar(String optie) {
        // Simuleer logica voor het beschikbaar zijn van opties
        if (optie.equals("Opslaan")) {
            return true; // Optie 'Opslaan' is altijd beschikbaar (voorbeeld)
        } else if (optie.equals("Meld aan voorraadinkoper")) {
            // Zoek het Autosoort object in de lijst op basis van naam of een andere identifier
            for (Autosoort autosoort : autosoorten) {
                // Als het autosoort object met de naam of id overeenkomt, controleer dan de voorraad
                if (autosoort.getHuidigVoorraadniveau() < autosoort.getMinimumpeiler()) {
                    return true; // Als de voorraad onder de minimumdrempel ligt, is de optie beschikbaar
                }
            }
        }
        // Andere opties kunnen hier worden toegevoegd met specifieke logica
        return false;
    }


    @Override
    public void wijzigMinimumDrempel(Autosoort voertuig, int nieuweDrempel) {
        controleerMinimumdrempel(nieuweDrempel);  // Add this line to check the threshold
        voertuig.setMinimumpeiler(nieuweDrempel);
    }

    // New method to check the minimum threshold
    @Override
    public void controleerMinimumdrempel(int nieuweMinDrempel) throws IllegalArgumentException {
        if (nieuweMinDrempel < 3) {
            throw new IllegalArgumentException("Minimumpijler wordt niet geaccepteerd, waarde moet groter of gelijk aan 3 zijn");
        }
    }


}
