package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Pais;

public class CervezaRoja extends CervezaNegra {

    public CervezaRoja(Pais pais, Double gramosLupulo) {
        super(pais, gramosLupulo);
    }

    @Override
    public Double graduacion() {
        return super.graduacion() * 1.25;
    }
}
