package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.Jarra;
import ar.edu.unahur.obj2.Pais;
import ar.edu.unahur.obj2.marcas.CervezaNegra;
import ar.edu.unahur.obj2.marcas.CervezaRoja;
import ar.edu.unahur.obj2.marcas.CervezaRubia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    // Como vamos a testear varias cosas para una persona, hagamos un BeforeEach. @BeforeEach` está pensado para cuando **varios tests comparten las mismas instancias**. Ahí las variables tienen que salir de cada método y pasar a ser atributos de la clase para que todos los tests puedan verlas. Si hay un solo test, no es necesario. Si hay varios, `@BeforeEach` ahorra repetir la misma inicialización en cada uno.
    //
    private Pais holanda;
    private Pais alemania;
    private CervezaNegra heinekenNegra;
    private CervezaRoja heinekenRoja;
    private CervezaRubia budweirserRubia;
    private Persona juan;
    private Persona pedro;

    @BeforeEach
    public void setUp() {
        // El orden importa
        holanda = new Pais("Holanda");
        alemania = new Pais("Alemania");
        heinekenNegra = new CervezaNegra(holanda, 3.0);
        heinekenRoja = new CervezaRoja(holanda, 3.0);
        budweirserRubia = new CervezaRubia(alemania, 3.5, 0.07);
        CervezaNegra.setGraduacionReglamentaria(0.08);
        juan = new Persona(80.0, true, 12.0);
        pedro = new Persona(77.0, false, 15.0);

        // Juan y Pedro escabian
        juan.tomarJarra(new Jarra(heinekenNegra, 1.0));
        juan.tomarJarra(new Jarra(heinekenRoja, 1.0));

        pedro.tomarJarra(new Jarra(heinekenNegra, 1.0));
        pedro.tomarJarra(new Jarra(heinekenRoja, 1.0));
        pedro.tomarJarra(new Jarra(budweirserRubia, 1.0));
    }

    @Test
    public void dadaUnaPersonaConJarrasDeAlcohol_saberSuCantidadDeAlcoholIngerido() {
        assertEquals(
            1.0 * 0.06 + 1.0 * 0.06 * 1.25,
            juan.cantidadDeAlcoholIngerido()
        );
    }

    @Test
    public void dadoQueUnaPersonaTomaAlcohol_saberSiEstaEbria() {
        assertFalse(juan.estaEbria());
        assertTrue(pedro.estaEbria());
    }
}
