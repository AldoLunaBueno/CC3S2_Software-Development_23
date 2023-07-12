# Examen Final de Desarrollo de Software - CC3S2 <!-- omit in toc-->

# Pregunta 1

- **Antes**
  
    Primero tenemos tres clases: Airport, FLight y Passangers. Airport funciona aquí como cliente de las otras dos clases, que capturan la lógica de negocio. Imprime las listas de pasajeros de vuelos de negocios y de vuelos económicos.
    
    Para cada vuelo se crea una instancia de Flight cuyo contructor pide un ID y el tipo de vuelo como una cadena. Esto se debe refactorizar. También se añade cada pasajero a su vuelo correspondiente usando el método `addPassanger()` de la clase Flight y se remueve un pasajero usando `removePassanger()`. Todo esto implica una lógica de qué pasajeros se pueden añadir y remover de un vuelo según su estatus como pasajero VIP o regular.

- **Fase 1**

    Implementamos dos clases que se suman a la lógica del negocio: BusinessFlight y EconomyFlight. La prueba con covertura de código de ramas da un porcentaje del 66 % de forma global. La clase que no tiene 100 % de covertura de ramas es Flight. Esto es porque contiene dos estructuras switch en donde el caso por defecto lanza una excepción cuando no se introduce un tipo de vuelo correcto, pero este caso no se prueba. Puede evitarse la necesidad de usar esta estructura condicional, que indica una covertura incompleta, si refactorizamos guiándonos del principio abierto-cerrado usando polimorfismo.

- **Fase 2**

    

