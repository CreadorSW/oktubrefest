package ar.edu.unahur.obj2.personas;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.TestBase;
import org.junit.jupiter.api.Test;

public class PersonaTest extends TestBase {

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
