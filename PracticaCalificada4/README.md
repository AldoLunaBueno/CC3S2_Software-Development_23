# Práctica calificada 4 <!-- omit in toc -->

- [Pregunta 1](#pregunta-1)
  - [Parte 2 y 3. Pruebas](#parte-2-y-3-pruebas)
  - [Parte 1. Implementación](#parte-1-implementación)
  - [Parte 4](#parte-4)
- [Pregunta 2](#pregunta-2)
- [Pregunta 3](#pregunta-3)


## Pregunta 1

Como seguimos las metodología TDD y RGR, vamos primero a hacer las pruebas y luego la implementación.

### Parte 2 y 3. Pruebas

Empezamos con una implementación mínima que haga fallar todas las pruebas al retornar un valor no esperado:

![](sources/2023-06-21-09-16-51.png)

Escribimos e implementamos los casos de prueba de la siguiente forma:

![](sources/2023-06-21-09-29-19.png)

Escribimos otras dos pruebas como esta:

![](sources/2023-06-21-09-32-54.png)

![](sources/2023-06-21-09-34-38.png)

Y agregamos una prueba adicional T4 que prueba más casos límite:

![](sources/2023-06-21-09-34-08.png)

Posteriormente, si el método fuera muy importante, haría falta una refactorización de las redundancias con utilidades como las pruebas paramétricas.

Lo que importa es que todas y cada una de las pruebas dan rojo, fallaron:

![](sources/2023-06-21-09-18-16.png)

### Parte 1. Implementación

Esta es la primera aproximación a la solución del problema de encontrar en un arreglo de valores cuántas secuencias de más de dos valores iguales hay:

![](sources/2023-06-21-10-32-58.png)

Y logramos que todas las pruebas den verde en el primer intento:

![](sources/2023-06-21-10-32-32.png)

### Parte 4

Usamos la cobertura de código que nos proporciona JaCoCo. Para esto lo configuramos para nuestras pruebas:

![](sources/2023-06-21-11-19-42.png)

Y obtenemos el siguiente resultado:

![](sources/2023-06-21-11-20-26.png)

## Pregunta 2

## Pregunta 3

Implementamos como nos piden una sistema mínimo de reservas con una pequeña documentación en el método clave:

![](sources/2023-06-21-11-52-40.png)

