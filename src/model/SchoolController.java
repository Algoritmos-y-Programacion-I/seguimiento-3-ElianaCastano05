package model;

import java.time.LocalDate;

public class SchoolController {

    // Atributos
    private String name;
    private int hourSpentSupport;
    public final int FLOORS = 5;
    public final int COLUMNS = 10;
    public final int HOURMAXSUPPORT = 100;
    private Computer[][] computersMatrix;

    public SchoolController(String name) {
        this.name = name;
        this.computersMatrix = new Computer[FLOORS][COLUMNS];

    }

    public Computer searchComputer(String serialNumber) {
       
        Computer computerFound = null;

        for(int i = 0; i < computersMatrix.length; i++) {

            for(int j = 0; j < computersMatrix.length; j++){

                if(computersMatrix[i][j] != null){
                    if(computersMatrix[i][j].getSerialNumber().equalsIgnoreCase(serialNumber)){

                        computerFound = computersMatrix[i][j];
                    }
                }
            }
        }
   
        return computerFound;
    }

    
    public String addComputer(String serialNumber, boolean nextWindow, int floor){

        String message = "";
        Computer computer = searchComputer(serialNumber);

        
        if(computer == null && (floor >= 1 && floor <= 5)){
            
            for(int i = 0; i < computersMatrix.length; i++) {

                if(computersMatrix[floor-1][i] == null){ 

                    computersMatrix[floor-1][i] = new Computer(serialNumber, nextWindow);

                    message = "\n---> El computador ha sido agregado correctamente.";
                    break;
                }
                else{
                    message = "\n---> Error.No hay espacio para otro computador en este piso.";
                }
            }
        }
        else{

            message = "\n---> Error. Ya hay un computador registrado con el mismo numero serial o el piso ingresado no existe.";

        }

        return message;
    }

    public String addIncidentComputer(String serialNumber, LocalDate dateReport, String description) {

        String message = "";

        Computer computer = searchComputer(serialNumber);

        if(computer != null){
            
            computer.addIncident(dateReport, description);
            message = "\n---> El incidente ha sido agregado correctamente.";
        }
        else{
            message = "\n---> Error. No es posible agregar un incidente porque el computador al que quiere asignarlo no existe";
        }

        return message;
    }

    public String computerMaxIncidents() {

        String message = "";
        int numIncidents = 0;
        Computer computer, computerMaxIncidents = null;
        int floor = 0, column = 0;

        for(int i = 0; i < computersMatrix.length; i++){
            for(int j = 0; j < computersMatrix.length; j++){
                
                computer = computersMatrix[i][j];
                if(computer != null){
                    if(computer.getIncidents().size() > numIncidents){

                        numIncidents = computer.getIncidents().size();
                        computerMaxIncidents = computer;
                        floor = i+1;
                        column = j+1;
                    }
                }
            }
        }

        message += "\n---> El computador con mayor cantidad de incidentes en el edificio es:";
        message += "\nNumero serial: " + computerMaxIncidents.getSerialNumber();
        message += "\nUbicacion:   Piso(Fila): " + floor +  " Columna: " + column;
        message += "\nNumero de incidentes: " + numIncidents;

        return message;
    }

    // Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHourSpentSupport() {
        return hourSpentSupport;
    }

    public void setHourSpentSupport(int hourSpentSupport) {
        this.hourSpentSupport = hourSpentSupport;
    }

    public int getFLOORS() {
        return FLOORS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public int getHOURMAXSUPPORT() {
        return HOURMAXSUPPORT;
    }

    public Computer[][] getcomputersMatrix() {
        return computersMatrix;
    }

    public void setcomputersMatrix(Computer[][] computersMatrix) {
        this.computersMatrix = computersMatrix;
    }

}
