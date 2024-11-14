package be.odisee.brainstormBijdrage.domain;

import java.util.ArrayList;
import java.util.Date;

public class Sessie {

    private int id;
    private String status;
    private Date begin;
    private Date einde;
    private ArrayList<Onderwerp> m_Onderwerpen = new ArrayList<Onderwerp>();

    public Sessie(){}

    public Sessie(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEinde() {
        return einde;
    }

    public void setEinde(Date einde) {
        this.einde = einde;
    }

    public ArrayList<Onderwerp> getOnderwerpen(){
        return m_Onderwerpen;
    }

    public Onderwerp voegOnderwerpToe
            (Facilitator facilitator,Onderwerp vorigOnderwerp, String tekstOnderwerp){

        Onderwerp newVal = new Onderwerp(0,"actueel",tekstOnderwerp,facilitator);
        newVal.setvorigOnderwerp(vorigOnderwerp);
        
        // het vorige "Actueel" onderwerp moet "Vorig" onderwerp worden 
        if (vorigOnderwerp != null) vorigOnderwerp.veranderOnderwerp();
        
        // het vorige "Vorig" onderwerp moet "Gesloten" onderwerp worden
        if (vorigOnderwerp != null) {
            Onderwerp voorVorigOnderwerp = vorigOnderwerp.getvorigOnderwerp();
            if (voorVorigOnderwerp != null) voorVorigOnderwerp.veranderOnderwerp();
        }

        m_Onderwerpen.add(newVal);
        return newVal;
    }

    public void toonSessieResultaten() {
        // bedoeld voor preliminaire testen
        for (Onderwerp onderwerp : m_Onderwerpen){
            System.out.println("\nResultaten voor onderwerp: '"+onderwerp.getTitel()+"'");
            onderwerp.toonOnderwerpResultaten();
        }
    }

	public Onderwerp getActueelOnderwerp() {
		
		for (Onderwerp o : m_Onderwerpen) {
			if (o.getStatus().equals("actueel")) return o;
		}
		return null;
	}
}






























