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
            // Para comparar estas maginitudes, lo que tiene sentido es que la graduación reglamentaria esté en porcentaje (multiplicada por 100).
            CervezaNegra.graduacionReglamentaria * 100,
            2 * this.gramosLupulo
        );
    }
}
