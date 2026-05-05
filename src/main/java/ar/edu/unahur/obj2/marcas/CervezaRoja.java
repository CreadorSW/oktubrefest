package ar.edu.unahur.obj2.marcas;

public class CervezaRoja extends CervezaNegra {

    public CervezaRoja(String pais, Double contenidoDeLupulo) {
        super(pais, contenidoDeLupulo);
    }

    @Override
    public Double graduacion() {
        return super.graduacion() * 1.25;
    }
}
