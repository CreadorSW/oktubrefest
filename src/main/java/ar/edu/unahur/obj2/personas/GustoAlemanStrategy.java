package ar.edu.unahur.obj2.personas;

import ar.edu.unahur.obj2.marcas.Marca;

public class GustoAlemanStrategy implements ILeGusta {

    @Override
    public boolean leGusta(Marca marca) {
        return true;
    }
}
