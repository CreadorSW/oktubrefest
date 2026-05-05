package ar.edu.unahur.obj2.marcas;

public class CervezaNegra extends Marca {

    // ponemos static para que sea una constante compartida por todas las instancias de CervezaNegra.
    protected static Double graduacionReglamentaria;

    public CervezaNegra(String pais, Double contenidoDeLupulo) {
        super(pais, contenidoDeLupulo);
    }

    public static void setGraduacionReglamentaria(Double valor) {
        CervezaNegra.graduacionReglamentaria = valor;
    }

    @Override
    public Double graduacion() {
        return Math.min(
            CervezaNegra.graduacionReglamentaria,
            2 * this.contenidoDeLupulo
        );
    }
}
