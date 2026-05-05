# Strategy Pattern — Apunte

## Arrancar la primera parte

Leemos la primera parte del enunciado: marcas, jarras. Ahí nomás tenemos que decidir cómo modelar las marcas y las jarras. Reflexionamos y nos damos cuenta que Marca debe ser una clase abstracta de donde salen marcas concretas.

Nos damos cuenta en el proceso de codeo que Marca debe tener un método abstracto para calcular la graduación.

## Mecanismo de decisión: herencia vs strategy

Cuando nos encontramos con un comportamiento que varía, nos preguntamos:

**"Esto que varía, ¿es algo que el objeto ES o algo que el objeto HACE?"**

- Si es algo que el objeto **es** (una Rubia es una Marca, una Negra es una Marca) → va bien con herencia.
- Si es algo que el objeto **hace** (una Carpa calcula un recargo, una Persona decide si le gusta una marca) → nos preguntamos: ¿esto podría necesitar cambiar sin reemplazar el objeto? ¿Podría haber formas distintas de hacerlo según el contexto? Ahí Strategy.

La herencia ata el comportamiento al tipo del objeto para siempre. Strategy nos deja cambiarlo en el momento que queramos, sin crear un objeto nuevo.

## Sobre los paquetes

Los paquetes existen para agrupar clases relacionadas. No tiene sentido crear un paquete con una sola clase (ej: `pais/Pais.java`). Solo lo justificamos si el concepto crece y aparecen clases nuevas (ej: `Ciudad`, `Provincia`). Caso contrario, ponemos la clase en el paquete raíz y ahorramos ruido.
