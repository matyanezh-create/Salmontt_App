SalmonttApp : Organización modular y creación de una librería personalizada
Descripción del proyecto
SalmonttApp es una aplicación de consola desarrollada en Java que apoya la gestión de información de la empresa salmonera ficticia Salmontt, ubicada en Puerto Montt.

El sistema permite:

Cargar registros de producción desde un archivo de texto (.csv o .txt).
Almacenar los registros en una estructura de datos basada en colecciones.
Listar todos los registros cargados.
Realizar búsquedas simples por centro de cultivo y por estado.
Mostrar los resultados de manera clara por consola.
Este proyecto corresponde a la segunda fase de desarrollo, donde se refuerza la modularidad, la reutilización de código y el empaquetamiento profesional en Java.

Estructura de paquetes
cl.duoc.salmontt.app

SalmonttApp
Clase principal con el método main y el menú por consola.
cl.duoc.salmontt.model

RegistroProduccion
Modelo con atributos privados, constructores, getters, setters y toString().
cl.duoc.salmontt.service

ProduccionService
Servicio que gestiona una colección (ArrayList) de RegistroProduccion, permite cargar datos desde archivo, listar y buscar.
cl.duoc.salmontt.util

FileUtils
Utilidad para leer líneas desde un archivo de texto.
Formato de archivo de entrada
Archivo datos_produccion.csv (separado por punto y coma ;):

Cómo ejecutar
Abrir el proyecto en IntelliJ IDEA.
Configurar el SDK (por ejemplo JDK 17).
Asegurarse de que la clase principal SalmonttApp está en el paquete cl.duoc.salmontt.app.
Ejecutar el método main de SalmonttApp.
Usar el menú:
Opción 1: cargar datos desde un archivo CSV.
Opción 2: listar todos los registros.
Opción 3: buscar por centro.
Opción 4: buscar por estado.
Opción 0: salir.
En la opción 1, puedes usar la ruta absoluta al archivo datos_produccion.csv incluido en el proyecto, o copiarlo a otra carpeta y usar esa ruta.
