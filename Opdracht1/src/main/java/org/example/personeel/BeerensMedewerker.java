package org.example.personeel;

public class BeerensMedewerker {
    private int id;
    private String status;
    private String voornaam;
    private String achternaam;
    private String email;
    private String telefoonnummer;
    private BeerensMedewerkerFunctie functie;

    public BeerensMedewerker(int id, String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.functie = functie;
        this.status = "Actief";
    }

    public void ontsla() {
        this.status = "Ontslagen";
    }

    public void neemInDienst() {
        this.status = "In Dienst";
    }
}