package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Pais;
import java.util.Calendar;

public abstract class Marca {

    protected Double gramosLupulo;
    protected Pais pais;

    public Marca(Pais pais, Double gramosLupulo) {
        this.pais = pais;
        this.gramosLupulo = gramosLupulo;
    }

    public Pais getPais() {
        return pais;
    }

    public Double getGramosLupulo() {
        return gramosLupulo;
    }

    // Template method. Método concreto que define el esqueleto y llama a pasos internos.
    public Double graduacion() {
        return calcularGraduacion(); // <- llama a un paso
    }

    protected abstract Double calcularGraduacion(); // <- el paso que varía.
}
