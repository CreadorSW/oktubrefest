# Strategy Pattern — Apunte

## Mecanismo de decisión: herencia vs strategy

Cuando nos encontramos con un comportamiento que varía, nos preguntamos:

**"Esto que varía, ¿es algo que el objeto ES o algo que el objeto HACE?"**

- Si es algo que el objeto **es** (una Rubia es una Marca, una Negra es una Marca) → va bien con herencia.
- Si es algo que el objeto **hace** (una Carpa calcula un recargo, una Persona decide si le gusta una marca) → nos preguntamos: ¿esto podría necesitar cambiar sin reemplazar el objeto? ¿Podría haber formas distintas de hacerlo según el contexto? Ahí asoma Strategy.

La herencia ata el comportamiento al tipo del objeto para siempre. Strategy nos deja cambiarlo en el momento que queramos, sin crear un objeto nuevo.

## Sobre los paquetes

Los paquetes existen para agrupar clases relacionadas. No tiene sentido crear un paquete con una sola clase (ej: `pais/Pais.java`). Solo lo justificamos si el concepto crece y aparecen clases nuevas (ej: `Ciudad`, `Provincia`). Caso contrario, ponemos la clase en el paquete raíz y ahorramos ruido.

## Parte 1: Marca, Jarra, Persona

Arrancamos dibujando las dependencias de lo que se ve en la parte 1 del enunciado.

```
   Persona (depende de Jarra, Marca)
      ↑
    Jarra (depende de Marca)
      ↑
    Marca (depende de nada — Pais es un String, no una clase)
```

En la parte 1, `Pais` solo es un atributo (un String). No lo modelamos como clase separada porque el dominio no lo exige todavía. Arrancamos por `Marca`, después `Jarra`, después `Persona`. Cada paso se para sobre el anterior y lo testeamos antes de avanzar.

## Parte 2: aparece Carpa

_(completar cuando leamos la parte 2)_

## Bonus: aparece EstrategiaRecargo

_(completar cuando leamos el bonus)_
