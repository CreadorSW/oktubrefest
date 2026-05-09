package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Pais;

public class CervezaRubia extends Marca {

    private Double graduacion;

    public CervezaRubia(Pais pais, Double gramosLupulo, Double graduacion) {
        super(pais, gramosLupulo);
        this.graduacion = graduacion;
    }

    @Override
    public Double graduacion() {
        return this.graduacion;
    }
}
