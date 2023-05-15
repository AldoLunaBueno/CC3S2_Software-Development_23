# Examen parcial - CC3S2 <!-- omit in toc -->

- [Pregunta 1](#pregunta-1)
  - [Requisito 1](#requisito-1)
  - [Requisito 2](#requisito-2)


## Pregunta 1

### Requisito 1

**1. Cuando una pieza se coloca en cualquier lugar fuera del eje x, se lanza RuntimeException**

El método para colocar la pieza no lo llamamos `jugar()`, sino `putPiece()` porque así empezamos a programarlo y nos parece más descriptivo. En el siguiente punto mostramos la implementación para este y el siguiente criterio de aceptación.

**2. Cuando una pieza se coloca en cualquier lugar fuera del eje y, se lanza RuntimeException**

![](sources/2023-05-15-11-36-48.png)

![](sources/2023-05-15-11-42-45.png)

**3. Cuando una pieza se coloca en un espacio ocupado, se lanza RuntimeException**

![](sources/2023-05-15-11-57-41.png)

En este punto nos dimos cuenta de que habíamos presupuesto erróneamente que los límites de las entradas de la posición en el tablero iban de 0 a 2, porque así se maneja en la programación. Tuvimos que correrlo todo una unidad.

Ahora añadimos la matriz de cadenas `grid` para registrar las jugadas, y así avanzar un poco más la funcionalidad del método `putPiece()`. Si bien no hemos definido un sistema de turnos aún, al menos las jugadas se registran con una _X_ gracias a nuestro método:

![](sources/2023-05-15-12-44-49.png)

Aprovechamos también para refactorizar las pruebas y así hacerlas más legibles y concisas usando varias anotaciones de JUnit4 como `@BeforeEach`:

![](sources/2023-05-15-12-51-51.png)

Como se ve, las pruebas pasan.

### Requisito 2




