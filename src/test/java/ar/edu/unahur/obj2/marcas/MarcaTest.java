package ar.edu.unahur.obj2.marcas;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.unahur.obj2.Jarra;
import ar.edu.unahur.obj2.Pais;
// No lo necesito porque el test está en el mismo paquete
// import ar.edu.unahur.obj2.marcas.CervezaRubia;
import org.junit.jupiter.api.Test;

public class MarcaTest {

    @Test
    public void dadaUnaJarraDeMarcaHofbrauConLitrosYGraduacion_saberSuContenidoDeAlcohol() {
        Pais alemania = new Pais("Alemania");
        CervezaRubia hofbrau = new CervezaRubia(alemania, 3.0, 0.05);
        Jarra jarra = new Jarra(hofbrau, 0.5);
        assertEquals(0.025, jarra.contenidoDeAlcoholLitros());
    }
}
