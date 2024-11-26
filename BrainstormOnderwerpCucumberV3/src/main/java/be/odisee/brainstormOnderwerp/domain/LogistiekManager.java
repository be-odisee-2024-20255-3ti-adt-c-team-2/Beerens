package be.odisee.brainstormOnderwerp.domain;

public class LogistiekManager {
    private String status;

    public LogistiekManager(String status) {
        this.status = status;
    }

    public boolean isIngelogd() {
        return "Ingelogd".equalsIgnoreCase(status);
    }

    public void waarschuwVoorraad(String bericht) {
        System.out.println(bericht); // Simulated logging or alert system
    }}
