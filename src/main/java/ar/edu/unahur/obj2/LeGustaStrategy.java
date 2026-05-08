package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public interface LeGustaStrategy {
    // En Java los métodos de una interfaz son babstractos por defecto.
    boolean leGusta(Marca marca);
}
