package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Pais;

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

    // La gracia de poner el modificador abstract es que las subclases deben implementarlo. Sino el compilador tira un error.
    public abstract Double graduacion();
}
