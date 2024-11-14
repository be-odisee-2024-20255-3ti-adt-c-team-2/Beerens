package org.example.autos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutosoortTest {
    private Autosoort autosoort;


    //Hoofdscenario: 1 - 2 - 3 - 4 - 5 - 6 - 7 - 8
    @Test
    void testBasicPath() {
        // Voorraad = 7, minimumpijler = 3, maximumpijler = 10, gebaseerd op concreet testgeval
        autosoort = new Autosoort(1, "Tesla", "Tesla", 7, 3, 10);

        // Testactie 1: De logistiek manager klikt op de autosoort van een verkoop.
        assertEquals("Tesla", autosoort.naam);
        assertEquals("Tesla", autosoort.merk);

        // Testactie 2: Het systeem toont voor "Tesla" de huidige voorraad in het magazijn, minimum- en maximumpijlers en de log.
        assertEquals(7, autosoort.getHuidigVoorraadniveau());
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 3: De logistiek manager maakt een analyse van de marktvraag naar deze autosoort en slaat deze op.
        autosoort.voegAnalyseMarktvraagToe("Hoge vraag in marktsegment");
        assertNotNull(autosoort.getMarktvraag());
        assertEquals("Hoge vraag in marktsegment", autosoort.getMarktvraag().getBeschrijving());

        // Testactie 4: Het systeem toont de minimum- en maximumpijlers en biedt opties.
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 6: Het systeem vergelijkt de voorraad met minimum- en maximumpijlers.
        int voorraad = autosoort.getHuidigVoorraadniveau();
        assertTrue(voorraad >= autosoort.getMinimumpeiler() && voorraad <= autosoort.getMaximumpeiler(),
                "Voorraad ligt tussen de minimum- en maximumpijlers.");

        // Testactie 8: Het systeem update de voorraad
        int nieuweVoorraad = 6;
        autosoort.updateVoorraad(nieuweVoorraad);
        assertEquals(nieuweVoorraad, autosoort.getHuidigVoorraadniveau());
    }



    //Minimumpijler wordt niet aanvaard: 1 - 2 - 3 - 4 - 5.1 - 5.1.1 - 5 - 6 - 7 - 8
    @Test
    void testAlternatiefPadMinimumPijlerNietAanvaard() {
        // Voorraad = 7, minimumpijler = 3, maximumpijler = 10, gebaseerd op concreet testgeval
        autosoort = new Autosoort(1, "Tesla", "Tesla", 7, 3, 10);

        // Testactie 1: De logistiek manager klikt op de autosoort van een verkoop.
        assertEquals("Tesla", autosoort.naam);
        assertEquals("Tesla", autosoort.merk);

        // Testactie 2: Het systeem toont voor "Tesla" de huidige voorraad in het magazijn, minimum- en maximumpijlers en de log.
        assertEquals(7, autosoort.getHuidigVoorraadniveau());
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 3: De logistiek manager maakt een analyse van de marktvraag naar deze autosoort en slaat deze op.
        autosoort.voegAnalyseMarktvraagToe("Hoge vraag in marktsegment");
        assertNotNull(autosoort.getMarktvraag());
        assertEquals("Hoge vraag in marktsegment", autosoort.getMarktvraag().getBeschrijving());

        // Testactie 4: Het systeem toont het scherm met de minimum- en maximumpijlers.
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 5.1: De logistiek manager aanvaardt de opgeslagen minimum- en maximumpeiler niet en kiest "Bewerken".
        int nieuweMinimumpeiler = 4;
        autosoort.setMinimumpeiler(nieuweMinimumpeiler); // Simuleert het bijwerken van de minimumpeiler
        assertEquals(nieuweMinimumpeiler, autosoort.getMinimumpeiler());

        // Testactie 5: De logistiek manager kiest de optie "Opslaan".
        // Controleert of de bijwerkingen zijn opgeslagen
        assertEquals(4, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 6: Het systeem vergelijkt de voorraad met minimum- en maximumpijler.
        int voorraad = autosoort.getHuidigVoorraadniveau();
        assertTrue(voorraad >= autosoort.getMinimumpeiler() && voorraad <= autosoort.getMaximumpeiler(),
                "Voorraad ligt tussen de minimum- en maximumpijlers.");

        // Testactie 8: Het systeem update de voorraad
        int nieuweVoorraad = 6;
        autosoort.updateVoorraad(nieuweVoorraad);
        assertEquals(nieuweVoorraad, autosoort.getHuidigVoorraadniveau());
    }


    //Voorraad ligt onder de minimumpijler: 1 - 2 - 3 - 4 - 5 - 6 - 7.1 - 7.1.1
    @Test
    void testAlternatiefPadVoorraadOnderMinimum() {
        // Voorraad = 2, minimumpijler = 3, maximumpijler = 10, gebaseerd op het concrete testgeval
        autosoort = new Autosoort(1, "Tesla", "Tesla", 2, 3, 10);

        // Testactie 1: De logistiek manager klikt op de autosoort van een verkoop.
        assertEquals("Tesla", autosoort.naam);
        assertEquals("Tesla", autosoort.merk);

        // Testactie 2: Het systeem toont voor "Tesla" de huidige voorraad, minimum- en maximumpijlers, en de log.
        assertEquals(2, autosoort.getHuidigVoorraadniveau());
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 3: De logistiek manager maakt een analyse van de marktvraag en slaat deze op.
        autosoort.voegAnalyseMarktvraagToe("Hoge vraag in marktsegment");
        assertNotNull(autosoort.getMarktvraag());
        assertEquals("Hoge vraag in marktsegment", autosoort.getMarktvraag().getBeschrijving());

        // Testactie 4: Het systeem toont de minimum- en maximumpijlers met de opties.
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());

        // Testactie 5: De logistiek manager aanvaardt de minimum- en maximumpijler.
        // (In deze test wordt dit gesimuleerd door verder te gaan zonder wijzigingen.)

        // Testactie 6: Het systeem vergelijkt de voorraad met minimum- en maximumpijler.
        int voorraad = autosoort.getHuidigVoorraadniveau();
        assertTrue(voorraad < autosoort.getMinimumpeiler(),
                "De voorraad ligt onder de minimumpeiler.");

        // Testactie 7.1: Het systeem geeft melding dat de voorraad onder de minimumpeiler ligt.
        String melding = autosoort.checkVoorraadEnMeldOnderMinimum();
        assertEquals("De voorraad ligt onder de minimumpeiler", melding);

        // Testactie 7.1.1: Het systeem stuurt een verzoek naar de voorraadinkoper.
        String berichtNaarVoorraadinkoper = autosoort.stuurBerichtNaarVoorraadinkoper();
        assertEquals("Bestel meer auto's van deze autosoort", berichtNaarVoorraadinkoper);
    }

}
