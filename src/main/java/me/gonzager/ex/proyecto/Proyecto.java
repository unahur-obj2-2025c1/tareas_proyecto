package me.gonzager.ex.proyecto;

import java.util.List;

import me.gonzager.ex.tareas.Tarea;

public class Proyecto {
    private List<Tarea> tareas;

    public Proyecto(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Double costoTotal() {
        return tareas.stream().map(Tarea::costoTotal).reduce(0.0, Double::sum);
    }

    public void reevaluar() {
        tareas.stream().forEach(Tarea::reevaluar);
    }
}
