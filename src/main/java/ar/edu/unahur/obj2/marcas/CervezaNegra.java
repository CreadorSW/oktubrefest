package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Pais;

public class CervezaNegra extends Marca {

    // ponemos static para que sea una constante compartida por todas las instancias de CervezaNegra.
    protected static Double graduacionReglamentaria;

    public CervezaNegra(Pais pais, Double gramosLupulo) {
        super(pais, gramosLupulo);
    }

    public static void setGraduacionReglamentaria(Double valor) {
        CervezaNegra.graduacionReglamentaria = valor;
    }

    @Override
    public Double graduacion() {
        return Math.min(
            CervezaNegra.graduacionReglamentaria,
            2 * this.gramosLupulo
        );
    }
}
