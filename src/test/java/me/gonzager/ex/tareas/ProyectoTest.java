package me.gonzager.ex.tareas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.gonzager.ex.complejidad.Complejidad;
import me.gonzager.ex.complejidad.Maxima;
import me.gonzager.ex.complejidad.Media;
import me.gonzager.ex.complejidad.Minima;
import me.gonzager.ex.proyecto.Proyecto;

public class ProyectoTest {

    private Complejidad minima = new Minima();
    private Complejidad media = new Media();
    private Complejidad maxima = new Maxima();
    private Tarea tarea11 = new TareaSimple(4, minima);
    private Tarea tarea12 = new TareaSimple(3, minima);
    private Tarea tarea13 = new TareaSimple(16, maxima);
    private Tarea tarea14 = new TareaSimple(14, media);
    private Tarea tarea1 = new TareaCompuesta(30, media, Arrays.asList(tarea11, tarea12, tarea13, tarea14));

    private Tarea tarea21 = new TareaSimple(8, media);
    private Tarea tarea221 = new TareaSimple(2, minima);
    private Tarea tarea222 = new TareaSimple(5, maxima);
    private Tarea tarea22 = new TareaCompuesta(10, maxima, Arrays.asList(tarea221, tarea222));
    private Tarea tarea2 = new TareaCompuesta(15, maxima, Arrays.asList(tarea21, tarea22));

    private Tarea tarea31 = new TareaSimple(12, media);
    private Tarea tarea32 = new TareaSimple(8, minima);
    private Tarea tarea3 = new TareaCompuesta(20, minima, Arrays.asList(tarea31, tarea32));

    Proyecto proyecto = new Proyecto(Arrays.asList(tarea1, tarea2, tarea3));

    @BeforeEach
    void initEachTest() {
        Complejidad.setImporteBaseComplejidad(2500.00);
    }

    @Test
    void testTarea1() {
        assertEquals(67, tarea1.getTiempoTotal());
        assertEquals(81900, tarea1.costo());
    }

    @Test
    void alCambiarElTiempoDeUnaTarea_SeCambiaTiempoTolaDelProyecto() {
        tarea11.setTiempo(5);
        assertEquals(68, tarea1.getTiempoTotal());
    }

    @Test
    void testTarea11Minima() {
        assertEquals(4, tarea11.getTiempoTotal());
        assertEquals(4 * 2500, tarea11.costo());
    }

    @Test
    void testTarea12Minima() {
        assertEquals(3, tarea12.getTiempoTotal());
        assertEquals(3 * 2500, tarea12.costo());
    }

    @Test
    void testTarea13Maxima() {
        assertEquals(16, tarea13.getTiempoTotal());
        // 48800 = ((16 * 2500) * 1.07 + 6 * 1000)
        assertEquals(48800, tarea13.costo());
    }

    @Test
    void testTarea14Media() {
        assertEquals(14, tarea14.getTiempoTotal());
        // 36750 = (14 * 2500) * 1.05
        assertEquals(36750, tarea14.costo());
    }

    @Test
    void testDuracionTarea2Maxima() {
        assertEquals(40, tarea2.getTiempoTotal());
        // 45125 = (15 * 2500) * 1.07 + (5 * 1000),
        assertEquals(45125, tarea2.costo());
    }

    @Test
    void testDuracionTarea21Media() {
        assertEquals(8, tarea21.getTiempoTotal());
        // 21000 = (8 * 2500) * 1.05,
        assertEquals(21000, tarea21.costo());
    }

    @Test
    void testDuracionTarea22Maxima() {
        assertEquals(17, tarea22.getTiempoTotal());
        // 26750 = (15 * 2500) * 1.07,
        assertEquals(26750, tarea22.costo());
    }

    @Test
    void testDuracionTarea221Minima() {
        assertEquals(2, tarea221.getTiempoTotal());
        assertEquals(5000, tarea221.costo());
    }

    @Test
    void testDuracionTarea222Maxima() {
        assertEquals(5, tarea222.getTiempoTotal());
        assertEquals(13375, tarea222.costo());
    }

    @Test
    void testDuracionTarea3() {
        assertEquals(40, tarea3.getTiempoTotal());
        // 50000 = 20 * 2500
        assertEquals(50000, tarea3.costo());
    }

    @Test
    void testCostoTarea31Media() {
        assertEquals(12, tarea31.getTiempoTotal());
        // 31500 = 12 * 2500 * 1.05
        assertEquals(31500, tarea31.costo());
    }

    @Test
    void testCostoTarea32Minima() {
        assertEquals(8, tarea32.getTiempoTotal());
        assertEquals(20000, tarea32.costo());

    }

    @Test
    void proyectoCostoTotal() {
        assertEquals(397700, proyecto.costoTotal());
    }

    @Test
    void proyectoReevaluar() {

        proyecto.reevaluar();
        assertEquals(104260, tarea1.costo());
        assertEquals(52500, tarea3.costo());
        assertEquals(13125, tarea222.costo());
        assertEquals(422310, proyecto.costoTotal());
    }
}
