# Strategy Pattern — Apunte

## Arrancar de abajo hacia arriba

Lo primero que hacemos es dibujar las dependencias del dominio. Cada concepto depende de otro más básico. Si construimos de abajo hacia arriba, siempre nos paramos sobre algo firme y testeado antes de avanzar.

```
    Carpa (depende de Persona, Marca, Jarra)
      ↑
   Persona (depende de Jarra, Marca, Pais)
      ↑
    Jarra (depende de Marca)
      ↑
    Marca (depende de Pais)
      ↑
     Pais (no depende de nada) ← arrancamos acá
```

Arrancamos por `Pais`, que no depende de nadie. Después `Marca`, que necesita `Pais`. Después `Jarra`, que necesita `Marca`. Después `Persona`, que necesita `Jarra`, `Marca` y `Pais`. Por último `Carpa`, que necesita todo lo anterior.

No avanzamos al siguiente paso hasta que el actual funciona y está testeado. Así nunca tenemos que debuggear dos cosas a la vez.

## Mecanismo de decisión: herencia vs strategy

Cuando nos encontramos con un comportamiento que varía, nos preguntamos:

**"Esto que varía, ¿es algo que el objeto ES o algo que el objeto HACE?"**

- Si es algo que el objeto **es** (una Rubia es una Marca, una Negra es una Marca) → va bien con herencia.
- Si es algo que el objeto **hace** (una Carpa calcula un recargo, una Persona decide si le gusta una marca) → nos preguntamos: ¿esto podría necesitar cambiar sin reemplazar el objeto? ¿Podría haber formas distintas de hacerlo según el contexto? Ahí asoma Strategy.

La herencia ata el comportamiento al tipo del objeto para siempre. Strategy nos deja cambiarlo en el momento que queramos, sin crear un objeto nuevo.

## Sobre los paquetes

Los paquetes existen para agrupar clases relacionadas. No tiene sentido crear un paquete con una sola clase (ej: `pais/Pais.java`). Solo lo justificamos si el concepto crece y aparecen clases nuevas (ej: `Ciudad`, `Provincia`). Caso contrario, ponemos la clase en el paquete raíz y ahorramos ruido.
