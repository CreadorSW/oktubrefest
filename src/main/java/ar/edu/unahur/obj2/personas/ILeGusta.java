package ar.edu.unahur.obj2.personas;

import ar.edu.unahur.obj2.marcas.Marca;

public interface ILeGusta {
    // En Java los métodos de una interfaz son babstractos por defecto.
    boolean leGusta(Marca marca);
}
