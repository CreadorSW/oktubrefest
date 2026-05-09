package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {

    private Marca marca;
    private Double capacidadLitros;

    public Jarra(Marca marca, Double capacidadLitros) {
        this.marca = marca;
        this.capacidadLitros = capacidadLitros;
    }

    public Marca getMarca() {
        return marca;
    }

    public Double getCapacidadLitros() {
        return capacidadLitros;
    }

    // Es algo que va con el dominio y además lo pide el test
    public Double contenidoDeAlcoholLitros() {
        return marca.graduacion() * capacidadLitros;
    }
}
