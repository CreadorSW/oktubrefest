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

    // Paises
    private Pais holanda;
    private Pais alemania;
    private Pais belgica;
    private Pais republicaCheca;
    // Cervezas
    private CervezaNegra heinekenNegra;
    private CervezaRoja heinekenRoja;
    private CervezaRubia budweirserRubia;
    // Personas
    private Persona juan;
    private Persona pedro;
    private Persona natalia;

    @BeforeEach
    public void setUp() {
        // El orden importa
        holanda = new Pais("Holanda");
        alemania = new Pais("Alemania");
        belgica = new Pais("Belgica");
        republicaCheca = new Pais("República Checa");

        heinekenNegra = new CervezaNegra(holanda, 3.0);
        heinekenRoja = new CervezaRoja(holanda, 3.0);
        budweirserRubia = new CervezaRubia(alemania, 3.5, 0.09);
        CervezaNegra.setGraduacionReglamentaria(0.08);

        juan = new Persona(
            alemania,
            80.0,
            true,
            12.0,
            new GustoAlemanStrategy()
        );
        pedro = new Persona(
            belgica,
            77.0,
            false,
            15.0,
            new GustoBelgaStrategy()
        );
        natalia = new Persona(
            republicaCheca,
            68.0,
            true,
            9.0,
            new GustoChecoStrategy()
        );

        // Juan y Pedro escabian
        juan.tomarJarra(new Jarra(heinekenNegra, 1.0));
        juan.tomarJarra(new Jarra(heinekenRoja, 1.0));

        pedro.tomarJarra(new Jarra(heinekenNegra, 1.0));
        pedro.tomarJarra(new Jarra(heinekenRoja, 1.0));
        pedro.tomarJarra(new Jarra(budweirserRubia, 1.0));
    }

    //Given-When-Then furioso
    @Test
    public void dadasJarras_cuandoUnaPersonaLasToma_saberlaCantidadDeAlcoholIngerido() {
        assertEquals(
            1.0 * 0.06 + 1.0 * 0.06 * 1.25,
            juan.cantidadDeAlcoholIngerido()
        );
    }

    @Test
    public void dadasJarras_cuandoUnaPersonaLasToma_saberSiEstaEbria() {
        assertFalse(juan.estaEbria());
        assertTrue(pedro.estaEbria());
    }

    @Test
    public void dadaUnaMarca_cuandoUnaPersonaLaRecibe_saberSiLeGusta() {
        assertFalse(natalia.leGusta(heinekenNegra));
        assertFalse(natalia.leGusta(heinekenRoja));
        assertTrue(natalia.leGusta(budweirserRubia));
    }
}
