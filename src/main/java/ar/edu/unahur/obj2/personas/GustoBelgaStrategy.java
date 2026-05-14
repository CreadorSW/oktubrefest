package ar.edu.unahur.obj2.personas;

import ar.edu.unahur.obj2.marcas.Marca;

public class GustoBelgaStrategy implements ILeGusta {

    @Override
    public boolean leGusta(Marca marca) {
        return (marca.getGramosLupulo() > 4);
    }
}
