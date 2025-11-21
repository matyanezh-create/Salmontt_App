package cl.duoc.salmontt.service;

import cl.duoc.salmontt.model.RegistroProduccion;
import cl.duoc.salmontt.util.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProduccionService {

    // Lista que guarda todos los registros de producción cargados en memoria
    private List<RegistroProduccion> registros = new ArrayList<>();

    // Método que carga los datos desde un archivo de texto (CSV)
    public void cargarDesdeArchivo(String ruta) {

        // Le pedimos a FileUtils que lea todas las líneas del archivo
        List<String> lineas = FileUtils.leerLineas(ruta);

        // Si la lista viene vacía, mostramos mensaje y salimos del método
        if (lineas.isEmpty()) {
            System.out.println("Archivo vacío o no encontrado");
            return;
        }

        // Variable para saltarnos la primera línea (cabecera del CSV)
        boolean header = true;

        // Recorremos cada línea del archivo
        for (String linea : lineas) {

            // La primera línea es el encabezado, así que la omitimos
            if (header) {
                header = false;
                continue;
            }

            try {
                // Separamos la línea usando el punto y coma como separador
                String[] p = linea.split(";");

                // Convertimos y limpiamos cada campo
                int id = Integer.parseInt(p[0].trim());
                String centro = p[1].trim();
                String especie = p[2].trim();
                double kilos = Double.parseDouble(p[3].trim());
                LocalDate fecha = LocalDate.parse(p[4].trim());
                String estado = p[5].trim();

                // Creamos un nuevo objeto RegistroProduccion con los datos de la línea
                registros.add(new RegistroProduccion(id, centro, especie, kilos, fecha, estado));

            } catch (Exception ex) {
                // Si alguna línea viene mal formada, mostramos un mensaje
                System.out.println("Error procesando línea: " + linea);
            }
        }

        // Al final mostramos cuántos registros se cargaron correctamente
        System.out.println("Registros cargados: " + registros.size());
    }

    // Método para listar todos los registros en consola
    public void listarTodos() {
        // Si la lista está vacía avisamos
        if (registros.isEmpty()) {
            System.out.println("Sin registros");
            return;
        }
        // Si hay datos, recorremos la lista e imprimimos cada registro
        registros.forEach(System.out::println);
    }

    // Método que busca registros según el nombre del centro
    public List<RegistroProduccion> buscarPorCentro(String centro) {
        List<RegistroProduccion> out = new ArrayList<>();

        // Recorremos todos los registros y comparamos el centro
        for (RegistroProduccion r : registros) {
            if (r.getCentro().equalsIgnoreCase(centro)) {
                out.add(r);
            }
        }
        // Devolvemos la lista con los resultados encontrados
        return out;
    }

    // Método que busca registros según el estado (EN_PROCESO, ENVIADO, etc.)
    public List<RegistroProduccion> buscarPorEstado(String estado) {
        List<RegistroProduccion> out = new ArrayList<>();

        // Recorremos todos los registros y comparamos el estado
        for (RegistroProduccion r : registros) {
            if (r.getEstado().equalsIgnoreCase(estado)) {
                out.add(r);
            }
        }
        // Devolvemos la lista filtrada
        return out;
    }
}
