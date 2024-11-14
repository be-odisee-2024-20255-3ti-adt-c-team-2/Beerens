package be.odisee.brainstormBijdrage.steps;

import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class brainstormBijdrageStepDefinitions {

	private int voorraadniveau;
	private int minimumPeiler = 3; // Stel minimumpeiler in als voorbeeld
	private int maximumPeiler = 10; // Stel maximumpeiler in als voorbeeld
	private String foutmelding;
	private boolean bestellingGeplaatst;

	@Given("Een voorraadniveau die kleiner is dan de minimum peiler")
	public void een_voorraadniveau_die_kleiner_is_dan_de_minimum_peiler() {
		voorraadniveau = 2; // Voorraadniveau instellen onder de minimumpeiler
	}

	@Given("Een voorraadniveau zit binnen de gestelde grenzen")
	public void een_voorraadniveau_zit_binnen_de_gestelde_grenzen() {
		voorraadniveau = 7; // Voorraadniveau instellen binnen de peilers
	}

	@Given("Een voorraadniveau gelijk aan de min- of maximum peiler")
	public void een_voorraadniveau_gelijk_aan_de_min_of_maximum_peiler() {
		voorraadniveau = minimumPeiler; // Voorbeeld: instellen op minimumpeiler
	}

	@Given("Een voorraadniveau hoger dan maximum peiler")
	public void een_voorraadniveau_hoger_dan_maximum_peiler() {
		voorraadniveau = 12; // Voorraadniveau instellen boven de maximumpeiler
	}

	@When("Een bestelling wordt geplaatst")
	public void een_bestelling_wordt_geplaatst() {
		if (voorraadniveau < minimumPeiler) {
			foutmelding = "voorraadniveau moet groter zijn dan de minimum peiler";
			bestellingGeplaatst = false;
		} else if (voorraadniveau > maximumPeiler) {
			foutmelding = "voorraadniveau moet kleiner zijn dan de maximum peiler";
			bestellingGeplaatst = false;
		} else {
			bestellingGeplaatst = true;
		}
	}

	@Then("zal een foutmelding getoond: {string}")
	public void zal_een_foutmelding_getoond(String expectedMessage) {
		assertEquals(expectedMessage, foutmelding);
	}

	@Then("Bestelling wordt aangemaakt")
	public void bestelling_wordt_aangemaakt() {
		assertTrue(bestellingGeplaatst, "De bestelling zou geplaatst moeten worden.");
	}
}
