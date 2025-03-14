package me.gonzager.ex.complejidad;

import me.gonzager.ex.tareas.Tarea;

public class Minima extends Complejidad {

    @Override
    public Double costoExtra(Tarea tarea) {
        return 0.0;
    }

    @Override
    public void reevaluar(Tarea tarea) {
        if (tarea.getTiempo() >= 15) {
            tarea.setComplejidad(new Media());
        }
    }

}
