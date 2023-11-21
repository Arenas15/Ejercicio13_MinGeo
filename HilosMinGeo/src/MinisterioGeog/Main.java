package MinisterioGeog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Ciudad[] ciudades = new Ciudad[3];
        for (int i = 0; i < 3; i++) {
        	System.out.println("Nombre de la ciudad (ESP): ");
            String nombreCiudad = sc.nextLine();

            int cantidadHabitantes = 0;
            boolean validHabitantes = false;
            while (!validHabitantes) {
                System.out.println("Número de habitantes en " + nombreCiudad + ": ");
                try {
                    cantidadHabitantes = Integer.parseInt(sc.nextLine());
                    validHabitantes = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error. Ingrese un número entero para contabilizar los habitantes.");
                }
            }

            double superficie = 0;
            boolean validSuperficie = false;
            while (!validSuperficie) {
                System.out.println("Superficie en m2 de " + nombreCiudad + ":");
                try {
                    superficie = Double.parseDouble(sc.nextLine());
                    validSuperficie = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error. Ingrese un número entero para contabilizar los metros cuadrados de superficie.");
                }
            }

            ciudades[i] = new Ciudad(nombreCiudad, cantidadHabitantes, superficie);
        }

        GeneradorInformacion generadorInfo = new GeneradorInformacion();
        GeneradorDirectorio generadorDir = new GeneradorDirectorio();
        GeneradorArchivo generadorArchivo = new GeneradorArchivo();

        Thread hiloPrincipal = new Thread(() -> generadorInfo.generarInformacion(ciudades));
        Thread hiloDirectorio = new Thread(generadorDir::generarDirectorio);
        Thread hiloArchivo = new Thread(() -> generadorArchivo.generarArchivo(ciudades));

        hiloPrincipal.start();
        hiloDirectorio.start();
        hiloArchivo.start();
        
        try {
            hiloPrincipal.join();
            hiloDirectorio.join();
            hiloArchivo.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar a los hilos: " + e.getMessage());
        }

        sc.close();
    }
}