package me.gonzager.ex.tareas;

import me.gonzager.ex.complejidad.Complejidad;

public abstract class Tarea {
    private Integer tiempo;
    private Complejidad complejidad;

    public Tarea(Integer tiempo, Complejidad complejidad) {
        this.tiempo = tiempo;
        this.complejidad = complejidad;
    }

    public Double costo() {
        return this.costoComplejidad() + this.costoOverHead();
    }

    protected abstract Double costoOverHead();

    public Double costoTotal() {
        return this.costo();
    }

    protected Double costoComplejidad() {

        return complejidad.costo(this);
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public Integer getTiempoTotal() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public void setComplejidad(Complejidad complejidad) {
        this.complejidad = complejidad;
    }

    public void reevaluar() {
        this.complejidad.reevaluar(this);
    }

    public abstract Integer cantidadSubTareas();
}
