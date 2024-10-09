package org.example.bestelling;

import org.example.autos.Autosoort;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BestellingTest {

    /*
    1. Statement Coverage
    Doel: Zorgen dat elke regel code minstens één keer wordt uitgevoerd.
    Testbasis: We testen of alle statements in de methode bestel() correct worden uitgevoerd.
    Testgevallen:
    Maak een bestelling en roep de bestel() methode aan om de status van de bestelling te veranderen.
    Junit Test:
    */
    @Test
    public void testBestelStatementCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);
        Bestelling bestelling = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());

        bestelling.bestel();

        assertEquals("Besteld", bestelling.getStatus());
    }


/*
2. Decision Coverage
Doel: Elke beslissingsuitkomst (waar/vals) moet minstens één keer worden getest.
Testbasis: Voeg een if-statement toe aan de methode bestel() en test zowel het waar- als vals-geval.
Bijvoorbeeld: if (this.status.equals("In behandeling"))
Junit Test:
 */
    @Test
    public void testBestelDecisionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Test waar-geval: status is "In behandeling" en hoeveelheid > 0
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Test vals-geval: status is "In behandeling" maar hoeveelheid <= 0
        Bestelling bestelling2 = new Bestelling(2, "In behandeling", autosoort, 0, new Date(), null, new Date());
        bestelling2.bestel();
        assertEquals("Niet besteld", bestelling2.getStatus());  // Controleer op de nieuwe status

        // Test vals-geval: status is niet "In behandeling"
        Bestelling bestelling3 = new Bestelling(3, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling3.bestel();
        assertEquals("Niet besteld", bestelling3.getStatus());  // Controleer op de nieuwe status
    }



/*
3. Condition Coverage
Doel: Elk onderdeel van een samengestelde voorwaarde moet apart worden getest.
Testbasis: Voeg samengestelde logische condities toe en test elk onderdeel.
Bijvoorbeeld: if (this.status.equals("In behandeling") && hoeveelheid > 0)
Junit Test:
 */
    @Test
    public void testBestelConditionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Beide condities waar
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Een voorwaarde onwaar
        Bestelling bestelling2 = new Bestelling(1, "In behandeling", autosoort, 0, new Date(), null, new Date());
        bestelling2.bestel();
        assertEquals("Niet besteld", bestelling2.getStatus());  // Controleer nu op de nieuwe status
    }



    /*
    4. Condition/Decision Coverage
Doel: Zowel elke beslissing als elke voorwaarde moet volledig worden getest.
Testbasis: Test combinaties van voorwaarden en beslissingen.
Junit Test:
     */
    @Test
    public void testBestelConditionDecisionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Waar: status is "In behandeling" en hoeveelheid > 0
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Vals: status is "In behandeling" maar hoeveelheid <= 0
        Bestelling bestelling2 = new Bestelling(1, "In behandeling", autosoort, 0, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());

        // Vals: status is niet "In behandeling"
        Bestelling bestelling3 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling3.bestel();
        assertNotEquals("Besteld", bestelling3.getStatus());
    }



/*
5. Modified Condition/Decision Coverage (MC/DC)
Doel: Elke voorwaarde moet onafhankelijk het resultaat van de beslissing beïnvloeden.
Testbasis: We moeten ervoor zorgen dat elke conditie onafhankelijk kan beïnvloeden of een beslissing waar of onwaar is.
Junit Test:
 */
    @Test
    public void testBestelMCDC() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Waar: beide condities
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Test met conditie onafhankelijk (bv. hoeveelheden aanpassen)
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());
    }


/*
6. Multiple Condition Coverage
Doel: Test alle mogelijke combinaties van voorwaarden.
Testbasis: Maak testen met verschillende combinaties van voorwaarden.
Junit Test:
 */
    @Test
    public void testBestelMultipleConditionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Combinatie 1: Beide waar
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Combinatie 2: Eerste onwaar, tweede waar
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());

        // Combinatie 3: Beide onwaar
        Bestelling bestelling3 = new Bestelling(1, "Geannuleerd", autosoort, 0, new Date(), null, new Date());
        bestelling3.bestel();
        assertNotEquals("Besteld", bestelling3.getStatus());
    }


    /*
    7. Path Coverage
Doel: Test elke mogelijke route door de code.
Testbasis: Test verschillende paden die de code kan nemen.
     */
    @Test
    public void testBestelPathCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Route 1: status is "In behandeling", hoeveelheid > 0
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Route 2: status is "Geannuleerd"
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());
    }

}
