# language: nl

Functionaliteit: Bijwerken van de voorraad na een verkoop

  Achtergrond:
    Gegeven de logistiek manager is ingelogd en bekijkt de verkoop voorraadlijst

  Scenario: Het systeem toont de voorraad en pijlers voor een autosoort binnen de limieten
    Als de logistiek manager het voertuigtype "Tesla" selecteert om details te bekijken
    Dan toont het systeem de huidige voorraad, de minimumdrempel van 3 en de maximumdrempel van 10 voor "Tesla"

  Scenario: Het systeem geeft een melding bij voorraad tussen de minimum- en maximumdrempel
    Als de logistiek manager het voertuigtype "Tesla" selecteert om details te bekijken
    En kiest om de voorraad bij te werken
    Dan geeft het systeem de melding "Voorraad ligt tussen de minimum- en maximumpijler"
    En geeft de optie "Opslaan"

  Scenario: Het systeem accepteert geen minimumdrempel lager dan 3 voor de voorraad
    En de voorraad voor "Tesla" is 7, met een minimumdrempel van 3 en een maximumdrempel van 10
    Als de logistiek manager het voertuigtype "Tesla" selecteert om details te bekijken
    En wijzigt de minimumdrempel naar 2
    Dan geeft het systeem de melding "Minimumpijler wordt niet geaccepteerd, waarde moet groter of gelijk aan 3 zijn"
    En biedt de optie "Opslaan" niet aan

  Scenario: Het systeem stuurt een melding naar de voorraadinkoper wanneer de voorraad onder de minimumdrempel ligt
    En de voorraad voor "Tesla" is 2, met een minimumdrempel van 3 en een maximumdrempel van 10
    Als de logistiek manager het voertuigtype "Tesla" selecteert om details te bekijken
    En kiest om de voorraad bij te werken
    Dan geeft het systeem de melding "De voorraad ligt onder de minimumpeiler"
    En stuurt het systeem een bericht naar de voorraadinkoper om meer "Tesla" voertuigen te bestellen

  Scenario: Het systeem geeft een melding bij te hoge voorraad
    En de voorraad voor "Tesla" is 11, met een minimumdrempel van 3 en een maximumdrempel van 10
    Als de logistiek manager het voertuigtype "Tesla" selecteert om details te bekijken
    Dan geeft het systeem de melding "De voorraad overschrijdt de maximumdrempel"
    En biedt de optie "Opslaan" niet aan
