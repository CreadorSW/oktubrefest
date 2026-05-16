#import "@preview/octique:0.1.1": *
#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.10": *
#codly(languages: codly-languages)


#show: codly-init.with()

#codly(
  zebra-fill: none,
  display-icon: false,
  display-name: false,
  //smart-indent: false
)




#set text(size: 12pt, lang: "es", font: "New Computer Modern")

#set page(
  fill: white,
  margin: (top: 2.5cm, right: 2.5cm, left: 3cm, bottom: 3cm),
  numbering: "1 de 1"
)

#show outline.entry.where(level: 1): set text(weight: "bold")
#outline()

// Returns an image for the given name.
//#let gitBranch = octique("git-branch", color: rgb("#000000"), width: 1em, height: 1em)

#let purpleBranch = rgb("#995BD5")
// Returns a boxed image for the given name.
#let gitBranch =octique-inline("git-branch", color: purpleBranch, width: 0.9em, height: 0.9em, baseline: 25%)


#set table(
    stroke: none,
    gutter: 0.2em,
    fill: (x, y) =>
      if y == 0  {
        gray
      } else if y > 0 {
        rgb("ffdfba").lighten(60%)
      },
    inset: (x: 0.5em, y: 1em),
)

#show table.cell: it => {
    if it.y == 0 {
      set text(
        size: 14pt,
        fill: white,
        weight: "bold"
      )
      it
    } else {
      it
    }
}
#show table.cell.where(x: 0): strong



#v(0.5em)

= Oktubre Fest -- (#gitBranch #text(fill: purpleBranch)[try-1])


Los paquetes existen para agrupar clases relacionadas. No tiene sentido crear un paquete con una sola clase (ej: `pais/Pais.java`). Solo lo justificamos si el concepto crece y aparecen clases nuevas (ej: `Ciudad`, `Provincia`). Caso contrario, ponemos la clase en el paquete raíz y ahorramos ruido.



== Arrancar la primera parte


Leemos la primera parte del enunciado: marcas, jarras. Ahí nomás tenemos que decidir cómo modelar las marcas y las jarras. Reflexionamos y nos damos cuenta que Marca debe ser una clase abstracta de donde salen marcas concretas.

Podemos dibujar las dependencias de lo que se ve en la parte 1 del enunciado.

#codly(number-format: none)
```
  Persona (depende de Jarra, Marca)
    ↑
  Jarra (depende de Marca)
    ↑
  Marca (depende de nada — en principio Pais podría ser un String, no una clase)
```

En la parte 1, `Pais` solo es un atributo (un String). No lo modelamos como clase separada porque el dominio no lo exige todavía. Arrancamos por `Marca`, después `Jarra`, después `Persona`. Cada paso se para sobre el anterior y lo testeamos antes de avanzar.

Nos damos cuenta en el proceso de codeo que Marca debe tener un método abstracto para calcular la graduación.

== Mecanismo de decisión: herencia vs strategy

Cuando nos encontramos con un comportamiento que varía, nos preguntamos:

*'Esto que varía, ¿es algo que el objeto ES o algo que el objeto HACE?'*

- Si es algo que el objeto *es* (una Rubia es una Marca, una Negra es una Marca) $=>$ va bien con herencia.
- Si es algo que el objeto *hace* (una Carpa calcula un recargo, una Persona decide si le gusta una marca) $=>$ nos preguntamos: ¿esto podría necesitar cambiar sin reemplazar el objeto? ¿Podría haber formas distintas de hacerlo según el contexto? Ahí Strategy.

La herencia ata el comportamiento al tipo del objeto para siempre. Strategy nos deja cambiarlo en el momento que queramos, sin crear un objeto nuevo.

*Hay dos tipos de "is-a":*

#table(
  columns: (auto, auto, auto),
  table.header[][Herencia de clase (`extends`)][Herencia de interfaz (` implements`)],

  [Qué comparte],[Estado + comportamiento],[Solo contrato (métodos)],
  [Ej],[`Rubia extends Marca`],[`Pato implements Nadador`],
  [Significado],['es un tipo de'],['es capaz de'],
)



El ejemplo del profesor (`Pato implements Nadador`) sigue siendo is-a: el pato *es capaz de* nadar. No es Strategy. Es polimorfismo con interfaces, pero no es el patrón Strategy.

*Strategy* es otra cosa: es *has-a* (composición). La persona no implementa `LeGustaStrategy`. La persona *tiene* un objeto que implementa `LeGustaStrategy`.

Los tres patterns usan interfaces, pero la relación es distinta:

#table(
  columns: (auto, auto),
  table.header[Patrón][Relación],

  [Herencia (class/subclass)],[*is-a* $=>$ `extends`],
  [Interfaz (Pato/Nadador)],[*is-a (capaz de)* $=>$ `implements`],
  [Strategy],[*has-a* $=>$ atributo de tipo interfaz],
)


Notemos la diferencia entre una interfaz Strategy `LeGustaStrategy`, y la que mostró el profesor, `Nadador`, que es un polimorfismo con herencia de interfaz. Son dos usos distintos de interfaces.

== Template method

En nuestro código actual, *no* es exactamente Template Method. Tanto `CervezaNegra` como `CervezaRoja` redefinen `graduacion()` enteras. Cada una tiene su propia implementación completa. `CervezaRoja` llama a `super.graduacion()` como un atajo, pero es una decisión de ella, no un diseño del padre.

En Template Method clásico, el *padre* tiene un método *concreto* (no abstracto) que es la plantilla, y llama adentro a métodos abstractos o sobrescribibles que las subclases implementan.

/*

#codly(number-format: numbering.with("1"))
```java
CervezaNegra:
  // Este es el método plantilla (template method) - es concreto, no abstracto
  public Double graduacion() {
    return calcularGraduacionBase();        ← llama a un paso
  }

  // Este es el paso que las subclases pueden ajustar
  protected Double calcularGraduacionBase() {
    return Math.min(graduacionReglamentaria * 100, 2 * gramosLupulo) / 100;
}
```
*/
Nosotros tenemos
```java
public class CervezaNegra extends Marca {
  //lógica

  @Override
  public Double graduacion() {
    // Al final dividimos por 100 para obtener la el porcentaje en formato decimal (entre 0 y 1).
    return (
      Math.min(
        // Para comparar estas maginitudes, lo que tiene sentido es que la graduación reglamentaria esté en porcentaje (multiplicada por 100).
        CervezaNegra.graduacionReglamentaria * 100,
        2 * this.gramosLupulo
      ) / 100
    );
  }
}
```
Y algo similar para la clase `CervezaRoja`. Entonces no tenemos un Padre que gestiona.

- *Lo que tenemos:* cada hijo redefine `graduacion()` entero. El padre no controla nada.
- *Template Method:* el padre tiene un método plantilla concreto (`graduacion()`) que define el esqueleto, y los hijos solo modifican pasos específicos (`calcularGraduacionBase()`) sin reescribir la estructura completa.

En principio en este caso no hay problema con que sea así nomás. Es simple y funciona. Template Method tendría más sentido si el cálculo de graduación tuviera varios pasos y quisiéramos que algunos varíen y otros no.

Igualmente implementaremos Template Method en la rama *#gitBranch #text(fill:purpleBranch)[refactor-template-method]*.

= Template Method (#gitBranch #text(fill:purpleBranch)[refactor-template-method])

Fuimos a `Marca.java` y refactorizamos el método `graduacion()` para que se transforme en Template Method.

```java
public abstract class Marca {
  // lógica

  // Template method. Método concreto que define el esqueleto y llama a pasos internos.
  public Double graduacion() {
      return calcularGraduacion(); // <- llama a un paso
  }

  protected abstract Double calcularGraduacion(); // <- el paso que varía.
}
```
Luego cada cerveza sobreescribe `calcularGraduacion()` para implementar su propia lógica.  Con un solo paso, Template Method es puramente ceremonial. Es lo mismo que tener `graduacion()` abstracto directamente. La diferencia es conceptual, no práctica. El patrón muestra su valor cuando el esqueleto tiene *varios pasos*, algunos fijos y otros variables.
