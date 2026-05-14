// TestBase.java
//  Como las personas y marcas luego interactuan con las carpas, hacemos una clase base para inicializar los objetos comunes.
package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.*;
import ar.edu.unahur.obj2.personas.*;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    // Como vamos a testear varias cosas para una persona, hagamos un BeforeEach. @BeforeEach` está pensado para cuando **varios tests comparten las mismas instancias**. Ahí las variables tienen que salir de cada método y pasar a ser atributos de la clase para que todos los tests puedan verlas. Si hay un solo test, no es necesario. Si hay varios, `@BeforeEach` ahorra repetir la misma inicialización en cada uno.

    // Paises
    protected Pais holanda;
    protected Pais alemania;
    protected Pais belgica;
    protected Pais republicaCheca;

    // Marcas
    protected CervezaRubia coronaRubia;
    protected CervezaNegra guinessNegra;
    protected CervezaRoja hofbrauRoja;

    // Personas
    protected Persona juan;
    protected Persona pedro;
    protected Persona natalia;

    // Carpas
    protected Carpa carpaHolanda;
    protected Carpa carpaAlemania;
    protected Carpa carpaBelgica;
    protected Carpa carpaRepublicaCheca;

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
        carpaHolanda = new Carpa(3, true, guinessNegra);
        carpaAlemania = new Carpa(3, false, hofbrauRoja);
        carpaBelgica = new Carpa(2, true, coronaRubia);
        carpaRepublicaCheca = new Carpa(2, false, coronaRubia);
    }
}
