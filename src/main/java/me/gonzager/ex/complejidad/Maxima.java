package me.gonzager.ex.complejidad;

import me.gonzager.ex.tareas.Tarea;

public class Maxima extends Complejidad {

    @Override
    protected Double costoExtra(Tarea tarea) {
        var tiempo = tarea.getTiempo();
        var extra = this.costoBase(tarea) * 0.07;
        return tiempo <= 10
                ? extra
                : extra + (1000 * (tiempo - 10));
    }

    @Override
    public void reevaluar(Tarea tarea) {
        if (tarea.costo() <= 15000.0) {
            System.out.println(tarea.costo());
            tarea.setComplejidad(new Media());

        }
    }

}
