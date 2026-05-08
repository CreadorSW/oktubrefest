package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public class GustoCheco implements ILeGusta {

    @Override
    public boolean leGusta(Marca marca) {
        return (marca.graduacion() > 0.8);
    }
}
