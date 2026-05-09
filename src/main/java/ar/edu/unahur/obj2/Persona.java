package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;
import java.util.List;

public class Persona {

    private Double peso;
    private List<Jarra> jarras;
    private Boolean escuchaMusicaTradicional;
    private Double nivelDeAguante;
    // leGustaStrategy es una variable que va a ser una estrategia diferente según la persona.
    private ILeGusta leGustaStrategy;

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

    // refactor. siempre privado.
    // Si lo pusiese en público, estoy cambiando el qué. Doy una posibilidad más de que alguien me mensajee. Un refactor siempre es mejor tenerlo privado. Nadie tiene que saber cosas de más.
    private Double cantidadDeAlcoholIngerido() {
        return jarras.stream().mapToDouble(Jarra::getCapacidad).sum();
    }

    // La persona recibe el mensaje leGusta(marca) y se lo reenvía a la estrategia. La persona no sabe la respuesta. Pero sabe que **tiene** un objeto (leGustaStrategy) que sí sabe responder esa pregunta.
    public Boolean leGusta(Marca marca) {
        return leGustaStrategy.leGusta(marca);
    }
}
