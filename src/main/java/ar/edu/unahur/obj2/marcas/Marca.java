package ar.edu.unahur.obj2.marcas;

public abstract class Marca {

    protected Double contenidoDeLupulo;
    protected String pais;

    public Marca(String pais, Double contenidoDeLupulo) {
        this.pais = pais;
        this.contenidoDeLupulo = contenidoDeLupulo;
    }

    public String getPais() {
        return pais;
    }

    public Double getContenidoDeLupulo() {
        return contenidoDeLupulo;
    }

    // La gracia de poner el modificador abstract es que las subclases deben implementarlo. Sino el compilador tira un error.
    public abstract Double graduacion();
}
