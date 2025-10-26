package ui;

import java.time.LocalDate;
import java.util.Scanner;
import model.SchoolController;

public class SchoolApp {

    
    private Scanner input;
    private SchoolController controller;

    public static void main(String[] args) {

        SchoolApp ui = new SchoolApp();
        ui.menu();

    }

    // Constructor
    public SchoolApp() {
        input = new Scanner(System.in);
        controller = new SchoolController("Computaricemos");
    }

    
    public void menu() {

        System.out.println("Bienvenido a Computaricemos");

        int option = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("--------------------------------------------------------");
            System.out.println("Digite alguna de las siguientes opciones");
            System.out.println("1) Registrar computador");
            System.out.println("2) Registrar incidente en computador");
            System.out.println("3) Consultar el computador con mas incidentes");
            System.out.println("0) Salir del sistema");
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    registrarComputador();
                    break;
                case 2:
                    registrarIncidenteEnComputador();
                    break;
                case 3:
                    consultarComputadorConMasIncidentes();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios. Adios!");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Intente nuevamente.");
                    break;
            }

        } while (option != 0);

    }

    public void registrarComputador() {

        System.out.println("\n++++++++++++ REGISTRAR COMPUTADOR ++++++++++++++"); 
                
        System.out.println("\nNumero serial del computador a registrar: ");
        String serialNumber = input.nextLine();

        System.out.println("\nPiso donde se ubica: ");
        int floor = input.nextInt();
        input.nextLine();

        boolean nextWindow = true;
        
        String result = controller.addComputer(serialNumber, nextWindow, floor);

        System.out.println(result);

    }

    public void registrarIncidenteEnComputador() {

        System.out.println("\n++++++++++++ REGISTRAR INCIDENTE EN COMPUTADOR ++++++++++++++"); 
                
        System.out.println("\nNumero serial del computador donde se registrara el incidente: ");
        String serialNumber = input.nextLine();

        System.out.println("\nFecha del reporte: ");

        System.out.println("Anio: ");
        int anio = input.nextInt();
        input.nextLine();

        System.out.println("Mes(en numero): ");
        int mes = input.nextInt();
        input.nextLine();

        System.out.println("Dia: ");
        int dia = input.nextInt();
        input.nextLine();

        LocalDate dateReport = LocalDate.of(anio, mes, dia);

        System.out.println("\nDescripcion del incidente: ");
        String description = input.nextLine();
       
        
        String result = controller.addIncidentComputer(serialNumber, dateReport, description);

        System.out.println(result);


    }

    public void consultarComputadorConMasIncidentes() {

        System.out.println("\n++++++++++++ COMPUTADOR CON MAS INCIDENTES ++++++++++++++"); 

        String result = controller.computerMaxIncidents();
        System.out.println(result);

    }

}
