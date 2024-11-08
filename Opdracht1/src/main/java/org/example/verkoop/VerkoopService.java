package org.example.verkoop;

public class VerkoopService {
    public String verwerkVerkoop(boolean verkoopVoltooid, boolean voorraadOnderMinimum, boolean isPersonenauto, boolean voorraadAangepast) {

        // Scenario 1: Verkoop voltooid, voorraad onder minimum, personenauto, voorraad aangepast
        if (verkoopVoltooid && voorraadOnderMinimum && isPersonenauto && voorraadAangepast) {
            return "Voorraad wordt bijgewerkt en bestelmelding wordt gestuurd";
        }

        // Scenario 2: Verkoop mislukt, voorraad boven minimumpeil
        if (!verkoopVoltooid && !voorraadOnderMinimum) {
            return "Controleer voorraad melding";
        }

        // Scenario 3: Verkoop voltooid, bestelwagen, voorraad boven minimumpeil
        if (verkoopVoltooid && !voorraadOnderMinimum && !isPersonenauto && !voorraadAangepast) {
            return "Voorraad wordt bijgewerkt";
        }

        // Scenario 4: Verkoop voltooid, voorraad onder minimum, bestelwagen, voorraad aangepast
        if (verkoopVoltooid && voorraadOnderMinimum && !isPersonenauto && voorraadAangepast) {
            return "Verkoop voltooid, geen verdere actie nodig";
        }

        // Andere scenario's kunnen worden toegevoegd indien nodig
        return "Geen actie vereist";
    }
}
