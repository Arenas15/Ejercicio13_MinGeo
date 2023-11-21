package MinisterioGeog;

import java.io.FileWriter;
import java.io.IOException;

class GeneradorInformacion {
    public void generarInformacion(Ciudad[] ciudades) {
        for (Ciudad ciudad : ciudades) {
            System.out.println("Ciudad: " + ciudad.getNombreCiudad());
            System.out.println("Habitantes: " + ciudad.getCantidadHabitantes());
            System.out.println("Superficie: " + ciudad.getSuperficie());
            System.out.println("Proyección habitantes 2030: " + ciudad.proyeccionHabitantes2030());
            System.out.println("Superficie ocupada: " + ciudad.superficieOcupada());
            System.out.println();
        }
    }
}

class GeneradorDirectorio {
    public void generarDirectorio() {
        System.out.println("Creando el directorio...\n");
    }
}

class GeneradorArchivo {
    public void generarArchivo(Ciudad[] ciudades) {
        try (FileWriter fw = new FileWriter("informacion_ciudades.txt")) {
            for (Ciudad ciudad : ciudades) {
                fw.write("Ciudad: " + ciudad.getNombreCiudad() + "\n");
                fw.write("Habitantes: " + ciudad.getCantidadHabitantes() + "\n");
                fw.write("Superficie: " + ciudad.getSuperficie() + "\n");
                fw.write("Proyección habitantes 2030: " + ciudad.proyeccionHabitantes2030() + "\n");
                fw.write("Superficie ocupada: " + ciudad.superficieOcupada() + "\n\n");
            }
            System.out.println("Archivo generado con la información de las ciudades.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}