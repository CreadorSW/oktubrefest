package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public class GustoAleman implements LeGustaStrategy {
    @Override
    public boolean leGusta(Marca marca) {
        return true;
    }
}
