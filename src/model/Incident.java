package model;
import java.time.LocalDate;

public class Incident {
    
    //Atributos

    private LocalDate dateReport;
    private String description;
    private boolean solution;
    private int solutionHours;

    // Metodo Constructor

    public Incident(LocalDate dateReport, String description){
        
        this.dateReport = dateReport;
        this.description = description;
    }

    //Getters y setters

    public LocalDate getDateReport(){
        return dateReport;
    }

    /* --- Metodo setDateReport---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo dateReport del objeto Incident 
     * de acuerdo a lo recibido por parametro
     * @param LocalDate dateReport fecha actualizada del reporte del incidente
     */
    public void setDateReport(LocalDate dateReport){
        this.dateReport = dateReport;
    }

    public String getDescription() {
        return description;
    }

    /* --- Metodo setDescription---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo description del objeto Incident 
     * de acuerdo a lo recibido por parametro
     * @param String description descripcion del incidente para actualizar
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getSolution(){
        return solution;
    }

    /* --- Metodo setDSolution---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo solution del objeto Incident 
     * de acuerdo a lo recibido por parametro
     * @param boolean solution estado de solucion del incidente
     */
    public void setSolution(boolean solution){
        this.solution = solution;
    }

    public int getSolutionHours() {
        return solutionHours;
    }

    /* --- Metodo setSolutionHours---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo solutionHours del objeto Incident 
     * de acuerdo a lo recibido por parametro
     * @param int solutionHours horas de solucion del incidente
     */
    public void setSolutionHours(int solutionHours) {
       this.solutionHours = solutionHours;
    }
}
