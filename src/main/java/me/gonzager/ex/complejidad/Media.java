package me.gonzager.ex.complejidad;

import me.gonzager.ex.tareas.Tarea;

public class Media extends Complejidad {

    @Override
    protected Double costoExtra(Tarea tarea) {
        return this.costoBase(tarea) * 0.05;
    }

    @Override
    public void reevaluar(Tarea tarea) {

        if (tarea.getTiempo() > 25 && tarea.cantidadSubTareas() > 3)
            tarea.setComplejidad(new Maxima());
    }

}
