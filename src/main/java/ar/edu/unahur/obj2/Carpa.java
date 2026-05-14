package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.personas.Persona;
import java.util.ArrayList;
import java.util.List;

public class Carpa {

    protected Integer limiteDeGenteAdmitida;
    protected List<Persona> personasAdmitidas = new ArrayList<>();
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

    public Boolean dejaIngresarAPersona(Persona persona) {
        return (
            personasAdmitidas.size() < this.limiteDeGenteAdmitida &&
            !persona.estaEbria()
        );
    }

    public void admitirPersona(Persona persona) {
        if (dejaIngresarAPersona(persona)) {
            personasAdmitidas.add(persona);
        }
    }

    public void servirJarraAPersona(Persona persona, Double capacidadLitros) {
        if (!personasAdmitidas.contains(persona)) {
            throw new RuntimeException("La persona no está en la carpa");
        }
        Jarra jarraAServir = new Jarra(this.marcaDeCerveza, capacidadLitros);
        persona.tomarJarra(jarraAServir);
    }

    public Integer getEbriosEmpedernidos() {
        List<Persona> personasEbrias = personasAdmitidas
            .stream()
            .filter(Persona::estaEbria)
            .toList();
        List<Persona> ebriosEmpedernidos = personasEbrias
            .stream()
            .filter(p ->
                p
                    .getJarras()
                    .stream()
                    .allMatch(j -> j.getCapacidadLitros() >= 1)
            )
            .toList();
        return ebriosEmpedernidos.size();
    }
}
