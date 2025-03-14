package me.gonzager.ex.tareas;

import me.gonzager.ex.complejidad.Complejidad;

public class TareaSimple extends Tarea {
    public TareaSimple(Integer tiempo, Complejidad complejidad) {
        super(tiempo, complejidad);
    }

    @Override
    protected Double costoOverHead() {
        return 0.0;
    }

    @Override
    public Integer cantidadSubTareas() {
        return 0;
    }
}
