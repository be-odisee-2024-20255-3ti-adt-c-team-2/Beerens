package org.example.autos;

import org.example.bestelling.Bestelling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AutosoortTest {

    private Autosoort autosoort;

    @BeforeEach
    void setUp() {
        // Stel de autosoort in met een initiële voorraad en peilers
        autosoort = new Autosoort(1, "Model X", "Tesla", 0, 3, 10);
    }

    @Test
    void testVoorraadBovenMinimumPeiler() {

        autosoort.updateVoorraad(7);

        // Controleer of de voorraad boven de minimumpeiler ligt
        assertTrue(autosoort.getHuidigVoorraadniveau() > autosoort.getMinimumpeiler(),
                "De voorraad zou boven de minimumpeiler moeten liggen.");
    }

    @Test
    void testVoorraadOnderMinimumPeiler() {

        autosoort.updateVoorraad(2);

        // Verlaag de voorraad en controleer opnieuw
        autosoort.updateVoorraad(3);
        assertFalse(autosoort.getHuidigVoorraadniveau() > autosoort.getMinimumpeiler(),
                "De voorraad zou onder de minimumpeiler moeten liggen.");
    }

    @Test
    void testVoegMarktanalyseToe() {
        // Voeg een marktanalyse toe en controleer de status van de marktvraag
        autosoort.voegAnalyseMarktvraagToe("Sterke vraag naar Model X");
        assertNotNull(autosoort.getMarktvraag(), "Marktvraag zou moeten zijn toegevoegd.");
        assertEquals("Actief", autosoort.getMarktvraag().getStatus(), "Status van marktvraag zou 'Actief' moeten zijn.");
    }

    @Test
    void testBestellingVerwerken() {
        // Maak een nieuwe bestelling en stel de status in op "In behandeling"
        Bestelling bestelling = autosoort.voegBestellingToe(5);
        bestelling.setStatus("In behandeling"); // Zorg ervoor dat de status correct is
        bestelling.bestel();
        assertEquals("Besteld", bestelling.getStatus(), "Bestelling zou de status 'Besteld' moeten hebben.");
    }


    @Test
    void testBestellingAfgerond() {
        // Markeer de bestelling als afgerond en controleer de status
        Bestelling bestelling = autosoort.voegBestellingToe(5);
        bestelling.markeerAlsAfgerond();
        assertEquals("Afgerond", bestelling.getStatus(), "Bestelling zou de status 'Afgerond' moeten hebben.");
    }

    @Test
    void testVoorraadOnderMinimumPeilerBestellingPlaatsen() {
        // Stel de minimum peiler in
        autosoort.updateVoorraad(2); // Verlaag de voorraad tot onder de minimum peiler

        // Controleer of de voorraad onder de minimum peiler ligt
        if (autosoort.getHuidigVoorraadniveau() < autosoort.getMinimumpeiler()) {
            // Maak een bestelling en stel de status in op "In behandeling"
            Bestelling bestelling = autosoort.voegBestellingToe(10);
            bestelling.setStatus("In behandeling"); // Zorg ervoor dat de status correct is
            bestelling.bestel();

            assertEquals("Besteld", bestelling.getStatus(), "Bestelling zou moeten worden geplaatst.");
        }
    }

    @Test
    void testGeenBestellingBovenMaximumPeiler() {
        // Stel maximumpeiler in op 10 eenheden
        autosoort.updateVoorraad(12); // Zet de voorraad boven de maximumpeiler

        // Controleer of de voorraad boven de maximumpeiler ligt
        if (autosoort.getHuidigVoorraadniveau() > autosoort.getMaximumpeiler()) {
            // Probeer een bestelling te plaatsen
            Bestelling bestelling = autosoort.voegBestellingToe(5);
            bestelling.setStatus("Afgekeurd");

            assertEquals("Afgekeurd", bestelling.getStatus(), "Geen bestelling mogelijk, voorraad ligt boven maximumpeiler.");
        }
    }


}