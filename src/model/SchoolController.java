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

    // Constructor
    public SchoolController(String name) {
        this.name = name;
        this.computersMatrix = new Computer[FLOORS][COLUMNS];
    }

    /* --- Metodo searchComputer ---
     * Tipo de metodo: analizador 
     * Descripcion: Este metodo permite buscar un computador dentro de computersMatrix
     * a partir del dato recibido como parametro
     * @param String serialNumber es el numero serial que identifica al computador que se quiere buscar
     * @return Computer computerFound es el computador encontrado o null
     */
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

    /* --- Metodo addComputer---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite añadir un computador a la matriz de 
     * computadores de acuerdo a los datos recibidos por parametro
     * @param String serialNumber es el numero identificador de un computador 
     * @param boolean nextWindow atributo booleano
     * @int floor es el piso del edificio donde se quiere añadir el computador
     * @return String message retorna un mensaje de exito o error al añadir un computador 
     */
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

    /* --- Metodo addIncidentComputer---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite añadir un incidente a un computador 
     * de acuerdo a los datos recibidos por parametro
     * @param String serialNumber es el numero identificador del computador al que se le añadira el incidente
     * @param LocalDate dateReport fecha de reporte del incidente
     * @param String description es la descripcion del incidente
     * @return String message retorna un mensaje de exito o error al añadir un incidente a un computador 
     */
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

    /* --- Metodo computerMaxIncidents---
     * Tipo de metodo: analizador
     * Descripcion: Este metodo permite consultar el computador del edificio con 
     * mayor cantidad de incidentes 
     * @return String message retorna un mensaje mostrando el computador con mayor 
     * cantidad de incidentes, con su ubicacion y cantidad de incidentes
     */
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

    /* --- Metodo setName---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo name del objeto SchoolController 
     * de acuerdo a lo recibido por parametro
     * @param String name es el nombre de la escuela
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getHourSpentSupport() {
        return hourSpentSupport;
    }

    /* --- Metodo setHourSpentSupport ---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo hourSpentSupport del objeto 
     * SchoolController de acuerdo a lo recibido por parametro
     * @param int hourSpentSupport son las horas gastadas en el soporte 
     */
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

    /* --- Metodo setComputersMatrix---
     * Tipo de metodo: modificador
     * Descripcion: Este metodo permite cambiar el estado del atributo computersMatrix del objeto 
     * SchoolController de acuerdo a lo recibido por parametro
     * @param Computer[][] computersMatrix  es una matriz que contiene objetos de tipo Computer 
     */
    public void setComputersMatrix(Computer[][] computersMatrix) {
        this.computersMatrix = computersMatrix;
    }

}
