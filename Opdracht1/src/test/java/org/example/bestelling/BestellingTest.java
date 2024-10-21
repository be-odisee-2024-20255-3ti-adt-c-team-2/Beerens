package org.example.bestelling;

import org.example.autos.Autosoort;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class BestellingTest {

    @Test
    public void testBestelStatementCoverage() {
        // Arrange
        Autosoort autosoort = new Autosoort( "Civic", "Honda",
                10, 1, 20);
        Bestelling bestelling = new Bestelling(autosoort, 4);

        // Act
        bestelling.bestel("12/05/2025"); // verwachtte leverdatum
        Levering levering = bestelling.isGeleverd("20/05/2025",
                autosoort, 4);

        // Assert
        // Controleer of de levering succesvol is gemaakt
        assertNotNull(levering);
    }

    @Test
    public void testConditionCoverage() {
        // Arrange
        Autosoort autosoort = new Autosoort( "Civic", "Honda",
                10, 1, 20);
        Autosoort autosoortLevering = new Autosoort( "SUV", "Tesla",
                10, 1, 20);
        Bestelling bestelling = new Bestelling(autosoort, 5);

        // Act
        bestelling.bestel("12/05/2025"); // verwachtte leverdatum
        Levering levering = bestelling.isGeleverd("24/05/2025",
                autosoortLevering, 4);

        // Assert
        // Controleer of de levering succesvol is gemaakt
        assertNull(levering);
    }
}