package ar.edu.unahur.obj2.marcas;

public abstract class Marca {

    protected Double gramosLupulo;
    protected String pais;

    public Marca(String pais, Double gramosLupulo) {
        this.pais = pais;
        this.gramosLupulo = gramosLupulo;
    }

    public String getPais() {
        return pais;
    }

    public Double getGramosLupulo() {
        return gramosLupulo;
    }

    // La gracia de poner el modificador abstract es que las subclases deben implementarlo. Sino el compilador tira un error.
    public abstract Double graduacion();
}
