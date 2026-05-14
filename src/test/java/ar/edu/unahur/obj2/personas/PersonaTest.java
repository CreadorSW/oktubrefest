package ar.edu.unahur.obj2.personas;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.Carpa;
import ar.edu.unahur.obj2.Jarra;
import ar.edu.unahur.obj2.Pais;
import ar.edu.unahur.obj2.marcas.CervezaNegra;
import ar.edu.unahur.obj2.marcas.CervezaRoja;
import ar.edu.unahur.obj2.marcas.CervezaRubia;
import ar.edu.unahur.obj2.personas.GustoChecoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    // Como vamos a testear varias cosas para una persona, hagamos un BeforeEach. @BeforeEach` está pensado para cuando **varios tests comparten las mismas instancias**. Ahí las variables tienen que salir de cada método y pasar a ser atributos de la clase para que todos los tests puedan verlas. Si hay un solo test, no es necesario. Si hay varios, `@BeforeEach` ahorra repetir la misma inicialización en cada uno.

    // Paises
    private Pais holanda;
    private Pais alemania;
    private Pais belgica;
    private Pais republicaCheca;

    // Marcas
    private CervezaRubia coronaRubia;
    private CervezaNegra guinessNegra;
    private CervezaRoja hofbrauRoja;

    // Personas
    private Persona juan;
    private Persona pedro;
    private Persona natalia;

    // Carpas
    private Carpa carpaHolanda;
    private Carpa carpaAlemania;
    private Carpa carpaBelgica;
    private Carpa carpaRepublicaCheca;

    @BeforeEach
    public void setUp() {
        // El orden importa
        holanda = new Pais("Holanda");
        alemania = new Pais("Alemania");
        belgica = new Pais("Belgica");
        republicaCheca = new Pais("República Checa");

        guinessNegra = new CervezaNegra(holanda, 3.0);
        hofbrauRoja = new CervezaRoja(holanda, 3.0);
        coronaRubia = new CervezaRubia(alemania, 3.5, 0.09);
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
        juan.tomarJarra(new Jarra(guinessNegra, 1.0));
        juan.tomarJarra(new Jarra(hofbrauRoja, 1.0));

        pedro.tomarJarra(new Jarra(guinessNegra, 1.0));
        pedro.tomarJarra(new Jarra(hofbrauRoja, 1.0));
        pedro.tomarJarra(new Jarra(coronaRubia, 1.0));

        // Carpas
        carpaHolanda = new Carpa(12, true, guinessNegra);
        carpaAlemania = new Carpa(15, false, hofbrauRoja);
        carpaBelgica = new Carpa(17, true, coronaRubia);
        carpaRepublicaCheca = new Carpa(7, false, coronaRubia);
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
        assertFalse(natalia.leGusta(guinessNegra));
        assertFalse(natalia.leGusta(hofbrauRoja));
        assertTrue(natalia.leGusta(coronaRubia));
    }

    @Test
    public void dadaUnaCarpa_cuandoUnaPersonaLlega_saberSiQuiereEntrar() {
        assertTrue(natalia.quiereEntrarACarpa(carpaBelgica));
        assertFalse(natalia.quiereEntrarACarpa(carpaHolanda));
    }
}
