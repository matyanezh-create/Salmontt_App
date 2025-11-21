package cl.duoc.salmontt.model;

import java.time.LocalDate;

public class RegistroProduccion {

    // Atributos privados que representan un registro de producción
    private int id;              // Identificador único del registro
    private String centro;       // Centro donde se produjo el salmón
    private String especie;      // Especie de salmón
    private double kilos;        // Kilos producidos
    private LocalDate fecha;     // Fecha del registro
    private String estado;       // Estado del proceso (ej: EN_PROCESO, ENVIADO, etc.)

    // Constructor vacío (necesario para usar objetos sin inicializar completamente)
    public RegistroProduccion() {}

    // Constructor completo para crear el registro con todos sus datos
    public RegistroProduccion(int id, String centro, String especie, double kilos, LocalDate fecha, String estado) {
        this.id = id;
        this.centro = centro;
        this.especie = especie;
        this.kilos = kilos;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Métodos getter y setter para acceder y modificar los atributos privados
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCentro() { return centro; }
    public void setCentro(String centro) { this.centro = centro; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public double getKilos() { return kilos; }
    public void setKilos(double kilos) { this.kilos = kilos; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Método toString para mostrar el contenido del objeto de forma legible en consola
    @Override
    public String toString() {
        return "RegistroProduccion{" +
                "id=" + id +
                ", centro='" + centro + '\'' +
                ", especie='" + especie + '\'' +
                ", kilos=" + kilos +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}
