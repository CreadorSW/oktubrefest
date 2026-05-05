package ar.edu.unahur.obj2.marcas;

public class CervezaRubia extends Marca {

    private Double graduacion;

    public CervezaRubia(
        String pais,
        Double contenidoDeLupulo,
        Double graduacion
    ) {
        super(pais, contenidoDeLupulo);
        this.graduacion = graduacion;
    }

    @Override
    public Double graduacion() {
        return this.graduacion;
    }
}
