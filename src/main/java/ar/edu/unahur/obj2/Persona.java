package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.marcas.Marca;
import java.util.ArrayList;
import java.util.List;

public class Persona {

    private Pais pais;
    private Double peso;
    private Boolean escuchaMusicaTradicional;
    private Double nivelDeAguante;
    // leGustaStrategy es una variable que va a ser una estrategia diferente según la persona.
    private ILeGusta leGustaStrategy;
    private List<Jarra> jarras = new ArrayList<>();

    public Persona(
        Pais pais,
        Double peso,
        //List<Jarra> jarras,
        Boolean escuchaMusicaTradicional,
        Double nivelDeAguante
    ) {
        this.pais = pais;
        this.peso = peso;
        //this.jarras = jarras;
        this.escuchaMusicaTradicional = escuchaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
    }

    public Double getPeso() {
        return peso;
    }

    public List<Jarra> getJarras() {
        return jarras;
    }

    public void tomarJarra(Jarra jarra) {
        jarras.add(jarra);
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
    // PERO después lo cambié a public porque era algo que pedía el test...
    public Double cantidadDeAlcoholIngerido() {
        return jarras
            .stream()
            .mapToDouble(Jarra::contenidoDeAlcoholLitros)
            .sum();
    }

    // La persona recibe el mensaje leGusta(marca) y se lo reenvía a la estrategia. La persona no sabe la respuesta. Pero sabe que **tiene** un objeto (leGustaStrategy) que sí sabe responder esa pregunta.
    public Boolean leGusta(Marca marca) {
        return leGustaStrategy.leGusta(marca);
    }
}
