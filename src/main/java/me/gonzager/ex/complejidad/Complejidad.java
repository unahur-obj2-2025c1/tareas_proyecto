package me.gonzager.ex.complejidad;

import me.gonzager.ex.tareas.Tarea;

public abstract class Complejidad {
    private static Double importeBaseComplejidad = 0.0;

    public static Double getImporteBaseComplejidad() {
        return importeBaseComplejidad;
    }

    public static void setImporteBaseComplejidad(Double importeBaseComplejidad) {
        Complejidad.importeBaseComplejidad = importeBaseComplejidad;
    }

    public Double costo(Tarea tarea) {
        return this.costoBase(tarea) + this.costoExtra(tarea);
    }

    protected Double costoBase(Tarea tarea) {
        return tarea.getTiempo() * importeBaseComplejidad;
    }

    protected abstract Double costoExtra(Tarea tarea);

    public abstract void reevaluar(Tarea tarea);

}
