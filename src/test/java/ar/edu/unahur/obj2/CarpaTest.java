package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarpaTest extends TestBase {

    @Test
    public void dadaUnaPersona_SaberSiLaCarpaLaDejaIngresar() {
        assertFalse(carpaHolanda.dejaIngresarAPersona(pedro));
        assertTrue(carpaHolanda.dejaIngresarAPersona(juan));
    }

    @Test
    public void dadaUnaPersonaEnLaCarpa_CuandoLaCarpaQuiereServirleUnaJarra_LaJarraSeSirve() {
        natalia.entrarACarpa(carpaBelgica);
        carpaBelgica.servirJarraAPersona(natalia, 1.0);
        // Ahora tenemos que chequear que natalia tiene esa jarra
        assertEquals(1.0, natalia.getJarras().size());
        assertEquals(
            carpaBelgica.getMarcaDeCerveza(),
            natalia.getJarras().get(0).getMarca()
        );
        assertEquals(1.0, natalia.getJarras().get(0).getCapacidadLitros());
    }
}
