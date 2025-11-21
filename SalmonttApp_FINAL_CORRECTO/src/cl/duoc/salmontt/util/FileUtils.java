package cl.duoc.salmontt.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Método que lee todas las líneas de un archivo y las devuelve en una lista
    public static List<String> leerLineas(String ruta){

        // Lista donde se guardarán todas las líneas leídas
        List<String> l = new ArrayList<>();

        // Usamos un BufferedReader para leer el archivo línea por línea.

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            // Ciclo que se ejecuta mientras existan líneas por leer
            while ((linea = br.readLine()) != null) {
                l.add(linea);  // Agregamos cada línea a la lista
            }

        } catch (Exception ex) {
            // Si ocurre algún error (archivo no existe, permisos, etc.) se muestra este mensaje
            System.out.println("Error leyendo archivo: " + ex.getMessage());
        }

        // Retornamos la lista con las líneas del archivo
        return l;
    }
}
