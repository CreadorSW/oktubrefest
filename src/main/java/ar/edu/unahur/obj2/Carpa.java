package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;

public class Carpa {

    protected Integer limiteDeGenteAdmitida;
    protected Boolean tieneBandaTradicional;
    protected Marca marcaDeCerveza;

    public Carpa(
        Integer limiteDeGenteAdmitida,
        Boolean tieneBandaTradicional,
        Marca marcaDeCerveza
    ) {
        this.limiteDeGenteAdmitida = limiteDeGenteAdmitida;
        this.tieneBandaTradicional = tieneBandaTradicional;
        this.marcaDeCerveza = marcaDeCerveza;
    }

    public Integer getLimiteDeGenteAdmitida() {
        return limiteDeGenteAdmitida;
    }

    public Boolean getTieneBandaTradicional() {
        return tieneBandaTradicional;
    }

    public Marca getMarcaDeCerveza() {
        return marcaDeCerveza;
    }
}
