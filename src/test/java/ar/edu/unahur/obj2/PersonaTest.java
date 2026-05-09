package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.Jarra;
import ar.edu.unahur.obj2.Pais;
import ar.edu.unahur.obj2.marcas.CervezaNegra;
import ar.edu.unahur.obj2.marcas.CervezaRoja;
import org.junit.jupiter.api.Test;

public class PersonaTest {

    @Test
    public void dadaUnaPersonaConJarrasDeAlcohol_saberSuCantidadDeAlcoholIngerido() {
        // El orden importa
        Pais holanda = new Pais("Holanda");
        CervezaNegra heinekenNegra = new CervezaNegra(holanda, 3.0);
        CervezaRoja heinekenRoja = new CervezaRoja(holanda, 3.0);
        // Recordar que una cerveza negra debe tener un seteo de graduación reglamentaria.
        CervezaNegra.setGraduacionReglamentaria(0.08);
        Persona persona = new Persona(80.0, true, 1.2);
        persona.tomarJarra(new Jarra(heinekenNegra, 1.0));
        persona.tomarJarra(new Jarra(heinekenRoja, 1.0));
        assertEquals(
            1.0 * 0.06 + 1.0 * 0.06 * 1.25,
            persona.cantidadDeAlcoholIngerido()
        );
    }
}
