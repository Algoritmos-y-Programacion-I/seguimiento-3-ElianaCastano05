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

    //Metodos
        
    /* --- Metodo addIncident ---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite añadir un incidente al arreglo de incidentes de un computador
     * @param LocalDate dateReport es la fecha de reporte del incidente
     * @param String description es la descripcion del incidente
     */
    public void addIncident(LocalDate dateReport, String description){
        
        incidents.add(new Incident(dateReport, description));

    }

    // Getters y setters
    public String getSerialNumber() {
        return serialNumber;
    }


    /* --- Metodo setSerialNumber---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo serialNumber del objeto Computer 
     * de acuerdo a lo recibido por parametro
     * @param String serialNumber numero serial que identifica a un computador
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean getNextWindow(){
        return nextWindow;
    }

    /* --- Metodo setNextWindow---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo nextWindow del objeto Computer 
     * de acuerdo a lo recibido por parametro
     * @param boolean nextWindow parametro booleano
     */
    public void setNextWindow(boolean nextWindow) {
        this.nextWindow = nextWindow;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    /* --- Metodo setIncidents---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo incidents del objeto Incident 
     * de acuerdo a lo recibido por parametro
     * @param ArrayList<Incident> incidents es un ArrayList de incidentes 
     */
    public void setIncidents(ArrayList<Incident> incidents) {
        this.incidents = incidents;
    }
    
}
