package ar.edu.unahur.obj2.personas;

import ar.edu.unahur.obj2.marcas.Marca;

public class GustoChecoStrategy implements ILeGusta {

    @Override
    public boolean leGusta(Marca marca) {
        return (marca.graduacion() > 0.08);
    }
}
