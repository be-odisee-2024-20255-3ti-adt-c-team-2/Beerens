package org.example;

import org.example.autos.Autosoort;
import org.example.bestelling.Bestelling;
import org.example.personeel.Factuur;

// We gebruiken het Mockito mocking framework


import java.util.Date;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Maak een nieuwe autosoort aan
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Maak een nieuwe bestelling
        Factuur factuur = new Factuur(1, "Factuur voor bestelling 1");
        Bestelling bestelling = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), factuur, new Date());

        // Verwerk de bestelling
        bestelling.bestel();
        System.out.println("Bestelling is geplaatst!");

        // Controleer of de bestelling geleverd is
        if (bestelling.isGeleverd() != null) {
            System.out.println("De bestelling is geleverd!");
        }
    }
}