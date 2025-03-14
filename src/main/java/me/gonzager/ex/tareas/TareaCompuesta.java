package me.gonzager.ex.tareas;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.complejidad.Complejidad;

public class TareaCompuesta extends Tarea {
    private List<Tarea> tareas = new ArrayList<>();

    public TareaCompuesta(Integer tiempo, Complejidad complejidad, List<Tarea> tareas) {
        super(tiempo, complejidad);
        this.tareas = tareas;
    }

    @Override
    public Integer getTiempo() {
        return super.getTiempo();
    }

    @Override
    public Integer getTiempoTotal() {
        return super.getTiempo() + this.getTiempoSubTareas();
    }

    private Integer getTiempoSubTareas() {
        return tareas.stream().map(Tarea::getTiempoTotal).reduce(0, Integer::sum);
    }

    @Override
    protected Double costoOverHead() {
        return this.tareas.size() > 3
                ? this.costoComplejidad() * 0.04
                : 0.0;
    }

    @Override
    public Double costoTotal() {
        return super.costo() + tareas.stream().map(Tarea::costoTotal).reduce(0.0, Double::sum);
    }

    @Override
    public Integer cantidadSubTareas() {
        return tareas.size();
    }

    @Override
    public void reevaluar() {
        super.reevaluar();
        this.tareas.forEach(Tarea::reevaluar);
    }

    public void quitarTodasLasTareas() {
        tareas.clear();
    }
}
