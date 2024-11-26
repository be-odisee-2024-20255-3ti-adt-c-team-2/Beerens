package be.odisee.brainstormOnderwerp.domain;

public abstract class Rol {

    protected int id;
    protected static int nextid=1;
    protected String status;
    protected String usernaam;
    protected Sessie m_Sessie;

    public Rol(){}

    public Rol(String status, String usernaam, Sessie sessie) {
        this.id = this.nextid++;
        this.status = status;
        this.usernaam = usernaam;
        this.m_Sessie = sessie;
    }

    public Rol(int id, String status, String usernaam, Sessie sessie) {
        this.id = id;
        this.status = status;
        this.usernaam = usernaam;
        this.m_Sessie = sessie;
    }

    public int getId() {
        return id;
    }

    public Sessie getSessie(){
        return m_Sessie;
    }

    public void setSessie(Sessie newVal){
        m_Sessie = newVal;
    }

}