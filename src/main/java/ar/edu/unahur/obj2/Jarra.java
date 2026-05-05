package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {

    private Marca marca;
    private Double contenido;

    public Jarra(Marca marca, Double contenido) {
        this.marca = marca;
        this.contenido = contenido;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getContenido() {
        return contenido;
    }
}
