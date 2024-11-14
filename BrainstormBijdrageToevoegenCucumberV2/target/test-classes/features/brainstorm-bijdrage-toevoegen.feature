Feature: Voorraadbeheer voor autosoort

	Scenario: Voorraadniveau is onder de min (BVA)
		Given Een voorraadniveau die kleiner is dan de minimum peiler
		When Een bestelling wordt geplaatst
		Then zal een foutmelding getoond: "voorraadniveau moet groter zijn dan de minimum peiler"

	Scenario: Voorraadniveau binnen de grenzen (EP)
		Given Een voorraadniveau zit binnen de gestelde grenzen
		When Een bestelling wordt geplaatst
		Then Bestelling wordt aangemaakt

	Scenario: Voorraadniveau gelijk aan min of max (BVA)
		Given Een voorraadniveau gelijk aan de min- of maximum peiler
		When Een bestelling wordt geplaatst
		Then Bestelling wordt aangemaakt

	Scenario: Voorraadniveau is boven max (BVA)
		Given Een voorraadniveau hoger dan maximum peiler
		When Een bestelling wordt geplaatst
		Then zal een foutmelding getoond: "voorraadniveau moet kleiner zijn dan de maximum peiler"
