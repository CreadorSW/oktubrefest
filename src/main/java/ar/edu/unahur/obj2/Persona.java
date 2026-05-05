package ar.edu.unahur.obj2;

import java.util.List;

public class Persona {

    private Double peso;
    private List<Jarra> jarras;
    private Boolean escuchaMusicaTradicional;
    private Double nivelDeAguante;

    public Persona(
        Double peso,
        List<Jarra> jarras,
        Boolean escuchaMusicaTradicional,
        Double nivelDeAguante
    ) {
        this.peso = peso;
        this.jarras = jarras;
        this.escuchaMusicaTradicional = escuchaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
    }

    public Double getPeso() {
        return peso;
    }

    public List<Jarra> getJarras() {
        return jarras;
    }

    public Boolean getEscuchaMusicaTradicional() {
        return escuchaMusicaTradicional;
    }

    public Double getNivelDeAguante() {
        return nivelDeAguante;
    }

    public Boolean estaEbria() {
        return cantidadDeAlcoholIngerido() * this.peso > this.nivelDeAguante;
    }

    private Double cantidadDeAlcoholIngerido() {
        return jarras.stream().mapToDouble(Jarra::getContenido).sum();
    }
}
