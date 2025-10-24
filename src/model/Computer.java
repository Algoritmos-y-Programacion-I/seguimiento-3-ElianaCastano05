package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Computer {

    //Atributos
    private String serialNumber;
    private boolean nextWindow;
    private ArrayList <Incident> incidents;

    // Metodo Constructor
    public Computer(String serialNumber, boolean nextWindow){
        this.serialNumber = serialNumber;
        this.nextWindow = nextWindow;
        this.incidents = new ArrayList<Incident>();
    }

    
    public void addIncident(LocalDate dateReport, String description){
        
        incidents.add(new Incident(dateReport, description));

    }

    // Getters y setters
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean getNextWindow(){
        return nextWindow;
    }

    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(ArrayList<Incident> incidents) {
        this.incidents = incidents;
    }
    
}
