package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarpaTest extends TestBase {

    @Test
    public void dadaUnaPersona_SaberSiLaCarpaLaDejaIngresar() {
        assertFalse(carpaHolanda.dejaIngresarAPersona(pedro));
        assertTrue(carpaHolanda.dejaIngresarAPersona(juan));
    }
}
