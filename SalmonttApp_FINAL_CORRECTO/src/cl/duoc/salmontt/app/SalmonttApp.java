package cl.duoc.salmontt.app;

import cl.duoc.salmontt.model.RegistroProduccion;
import cl.duoc.salmontt.service.ProduccionService;

import java.util.List;
import java.util.Scanner;

public class SalmonttApp {

    public static void main(String[] args) {

        // Scanner para leer lo que el usuario escribe en consola
        Scanner scanner = new Scanner(System.in);

        // Instancia del servicio que contiene la lógica del programa
        ProduccionService service = new ProduccionService();

        // Variable para controlar el menú
        int opcion = -1;

        // Ciclo que mantiene el programa corriendo mientras no elija 0
        while (opcion != 0) {

            // Mostrar menú principal
            System.out.println("===== SalmonttApp - Gestión =====");
            System.out.println("1. Cargar datos");
            System.out.println("2. Listar");
            System.out.println("3. Buscar por centro");
            System.out.println("4. Buscar por estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");

            try {
                // Leer opción del usuario
                opcion = Integer.parseInt(scanner.nextLine());

                // Evaluar la opción seleccionada
                switch(opcion){

                    case 1:
                        // Opción para cargar los datos desde un archivo CSV
                        System.out.print("Ruta archivo CSV: ");
                        service.cargarDesdeArchivo(scanner.nextLine());
                        break;

                    case 2:
                        // Opción que lista todos los registros cargados
                        service.listarTodos();
                        break;

                    case 3:
                        // Buscar registros filtrando por centro
                        System.out.print("Centro: ");
                        List<RegistroProduccion> c = service.buscarPorCentro(scanner.nextLine());
                        c.forEach(System.out::println);
                        break;

                    case 4:
                        // Buscar registros filtrando por estado
                        System.out.print("Estado: ");
                        List<RegistroProduccion> e = service.buscarPorEstado(scanner.nextLine());
                        e.forEach(System.out::println);
                        break;

                    case 0:
                        // Salida del programa
                        break;

                    default:
                        // Opción inválida si no coincide con el menú
                        System.out.println("Opción inválida");
                }

            } catch(Exception ex){
                // Captura cualquier error (por ejemplo, si escribe letras donde van números)
                System.out.println("Error: " + ex.getMessage());
            }

            // Línea en blanco para separar visualmente entre ejecuciones
            System.out.println();
        }
    }
}
