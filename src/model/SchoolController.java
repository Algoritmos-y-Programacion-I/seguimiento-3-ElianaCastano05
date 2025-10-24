package model;

import java.util.ArrayList;

public class SchoolController {

    // Atributos
    private String name;
    private int hourSpentSupport;
    private final int FLOORS = 5;
    private final int COLUMS = 10;
    private final int HOURMAXSUPPORT = 100;
    private Computer[][] computersMatriz;

    public SchoolController(String name) {
        this.name = name;
        this.computersMatriz = new Computer[FLOORS][COLUMS];

    }

    public Computer searchComputer(String serialNumber) {
       
        Computer computerFound = null;

        for(int i = 0; i < computersMatriz.length; i++) {

           for(int j = 0; j < computersMatriz.length; j++){

            if(computersMatriz[i][j].getSerialNumber().equalsIgnoreCase(serialNumber)){

                computerFound = computersMatriz[i][j];
            }
           }
        }
   
        return computerFound;
    }

    
    public void agregarComputador(String serialNumbrer, boolean nextWindow, int floor){

        Computer computer = searchComputer(serialNumbrer);

        if(computer == null){

            computersMatriz.add(ne)
        }



    }





    public void agregarIncidenteEnComputador() {

    }

    public void getComputerList() {

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

    public int getCOLUMS() {
        return COLUMS;
    }

    public int getHOURMAXSUPPORT() {
        return HOURMAXSUPPORT;
    }

    
    



}
