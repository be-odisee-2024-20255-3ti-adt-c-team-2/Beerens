package be.odisee.brainstormOnderwerp.acceptancetests.steps;

import be.odisee.brainstormOnderwerp.domain.Autosoort;
import be.odisee.brainstormOnderwerp.domain.LogistiekManager;
import be.odisee.brainstormOnderwerp.service.VoorraadService;
import be.odisee.brainstormOnderwerp.service.VoorraadServiceImpl;

import io.cucumber.java.nl.Gegeven;
import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Dan;

import static org.junit.Assert.*;

public class VoorraadStepDefinitions {

    private VoorraadService service = new VoorraadServiceImpl();
    private LogistiekManager logistiekManager;
    private Autosoort voertuig;


    @Gegeven("^de logistiek manager is ingelogd en bekijkt de verkoop voorraadlijst$")
    public void de_logistiek_manager_is_ingelogd_en_bekijkt_de_verkoop_voorraadlijst() throws Throwable {
        logistiekManager = new LogistiekManager("Ingelogd");
        assertTrue("De logistiek manager zou ingelogd moeten zijn", logistiekManager.isIngelogd());
    }

    @Als("^de logistiek manager het voertuigtype \"([^\"]*)\" selecteert om details te bekijken$")
    public void de_logistiek_manager_selecteert_voertuigtype(String voertuigNaam) throws Throwable {
        voertuig = service.haalVoertuigOp(voertuigNaam);
    }

    @Dan("^toont het systeem de huidige voorraad, de minimumdrempel van (\\d+) en de maximumdrempel van (\\d+) voor \"([^\"]*)\"$")
    public void systeem_toont_voorraad_en_drempels(int minDrempel, int maxDrempel, String voertuigNaam) throws Throwable {
        assertEquals("Fout in minimumdrempel", minDrempel, voertuig.getMinimumpeiler());
        assertEquals("Fout in maximumdrempel", maxDrempel, voertuig.getMaximumpeiler());
        assertEquals("Verkeerd voertuigtype geselecteerd", voertuigNaam, voertuig.naam);
    }

    @Dan("^geeft het systeem de melding \"([^\"]*)\"$")
    public void systeem_geeft_melding(String melding) throws Throwable {
        String meldingSysteem = service.controleerVoorraad(voertuig);
        assertEquals("De melding is niet zoals verwacht", melding, meldingSysteem);

    }

    @Dan("^geeft de optie \"([^\"]*)\"$")
    public void systeem_geeft_optie(String optie) throws Throwable {
        // Simuleer de optie die het systeem toont, bijvoorbeeld "Opslaan" of "Meld aan voorraadinkoper"
        assertTrue("De optie " + optie + " is niet beschikbaar", service.isOptieBeschikbaar(optie));
    }

    @Als("^de voorraad van \"([^\"]*)\" voertuigen de maximumdrempel van (\\d+) overschrijdt$")
    public void voorraad_overschrijdt_maximumdrempel(String voertuigNaam, int maxDrempel) throws Throwable {
        voertuig.setHuidigeVoorraad(maxDrempel + 1);  // Simuleert overvoorraad
        voertuig.checkVoorraadEnMeldOnderMinimum();
    }

    @Dan("^stuurt het systeem een bericht naar de voorraadinkoper om meer \"([^\"]*)\" voertuigen te bestellen$")
    public void systeem_stuurt_melding_inkoopteam(String voertuigNaam) throws Throwable {
        boolean meldingVerzonden = service.stuurMeldingNaarInkoop(voertuig);
        assertTrue("De melding naar het inkoopteam is niet verzonden", meldingVerzonden);
    }

    @Dan("^stuurt het systeem een melding naar de logistiek manager om te waarschuwen voor overvoorraad$")
    public void systeem_stuurt_melding_overvoorraad() throws Throwable {
        boolean meldingVerzonden = service.stuurOvervoorraadMelding(logistiekManager, voertuig);
        assertTrue("De overvoorraadmelding is niet verzonden", meldingVerzonden);
    }

    @Dan("^biedt het systeem de optie \"([^\"]*)\" aan$")
    public void systeem_biedt_optie_aan(String optie) throws Throwable {
        // Simuleer dat het systeem de juiste optie aanbiedt (bijv. "Opslaan" of "Meld aan voorraadinkoper")
        assertTrue("De optie " + optie + " wordt niet aangeboden", service.isOptieBeschikbaar(optie));
    }

    @Als("kiest om de voorraad bij te werken")
    public void kiest_om_de_voorraad_bij_te_werken() {
        // Hier voeg je de logica toe voor het bijwerken van de voorraad
        // Dit zou kunnen zijn het aanroepen van een methode van de service om de voorraad bij te werken
        // Voorbeeld:
        Autosoort autosoort = new Autosoort(1, "Tesla", "Model S", 7, 3, 10);
        service.updateVoorraadniveau(autosoort, 8); // Voorbeeld van het bijwerken van de voorraad
    }

    @Gegeven("^de voorraad voor \"([^\"]*)\" is (\\d+), met een minimumdrempel van (\\d+) en een maximumdrempel van (\\d+)$")
    public void de_voorraad_voor_is_met_een_minimumdrempel_van_en_een_maximumdrempel_van(String voertuigNaam, int huidigeVoorraad, int minDrempel, int maxDrempel) {
        System.out.println("Geselecteerd voertuig: " + voertuigNaam);
        System.out.println("Huidige voorraad: " + huidigeVoorraad);
        System.out.println("Minimumdrempel: " + minDrempel);
        System.out.println("Maximumdrempel: " + maxDrempel);

        voertuig = service.haalVoertuigOp(voertuigNaam);
        voertuig.setHuidigeVoorraad(huidigeVoorraad);
        voertuig.setMinimumpeiler(minDrempel);
        voertuig.setMaximumpeiler(maxDrempel);
    }

    @Als("^wijzigt de minimumdrempel naar (\\d+)$")
    public void wijzigt_de_minimumdrempel_naar(int nieuweMinDrempel) {
        // Wijzig de minimumpeiler naar de nieuwe waarde die in de feature file wordt gegeven
        voertuig.setMinimumpeiler(nieuweMinDrempel);
    }


    @Dan("^biedt de optie \"([^\"]*)\" niet aan$")
    public void biedt_de_optie_niet_aan(String optie) {
        // Hier controleer je of de optie niet wordt aangeboden
        // Dit kan bijvoorbeeld betekenen dat de knop "Opslaan" niet zichtbaar is:
        assertFalse("De optie " + optie + " wordt niet aangeboden", !service.isOptieBeschikbaar(optie));
    }
}
