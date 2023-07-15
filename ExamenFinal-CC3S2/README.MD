# Examen Final de Desarrollo de Software - CC3S2 <!-- omit in toc-->

# Pregunta 1

- **Antes**
  
    Primero tenemos tres clases: Airport, FLight y Passangers. Airport funciona aquí como cliente de las otras dos clases, que capturan la lógica de negocio. Imprime las listas de pasajeros de vuelos de negocios y de vuelos económicos.
    
    Para cada vuelo se crea una instancia de Flight cuyo contructor pide un ID y el tipo de vuelo como una cadena. Esto se debe refactorizar. También se añade cada pasajero a su vuelo correspondiente usando el método `addPassanger()` de la clase Flight y se remueve un pasajero usando `removePassanger()`. Todo esto implica una lógica de qué pasajeros se pueden añadir y remover de un vuelo según su estatus como pasajero VIP o regular.

- **Fase 1**

    Implementamos dos clases que se suman a la lógica del negocio: BusinessFlight y EconomyFlight. La prueba con covertura de código de ramas da un porcentaje del 66 % de forma global. La clase que no tiene 100 % de covertura de ramas es Flight. Esto es porque contiene dos estructuras switch en donde el caso por defecto lanza una excepción cuando no se introduce un tipo de vuelo correcto, pero este caso no se prueba. Puede evitarse la necesidad de usar esta estructura condicional, que indica una covertura incompleta, si refactorizamos guiándonos del principio abierto-cerrado usando polimorfismo.

- **Fase 2**

    Convertimos la clase Flight en una clase abstracta cuyos métodos abstractos son _addPassenger()_ y _removePassenger()_. La lógica para decidir agregar y eliminar pasajeros según su estatus como pasajero VIP o regular ahora es capturada por separado por las clase que implementan a la clase Flight: EconomyFlight y BusinessFlight. Esta refactorización nos permite poder agregar en el futuro nuevos tipos de vuelo que contenga nueva lógica sin necesidad de modificar la clase Flight.

    En este proceso de refactorización, IntelliJ nos ayudó a propagar los cambios efectuados en las demás clases. La que sufrió los cambios en su implementación fue la clase cliente Airport. Esta usaba directamente el constructor de la clase Flight y le pasaba como parámetro String el tipo de vuelo, lo cual en esta fase está completamente superado. Sin embargo, la clase de prueba AirportTest no cambió gracias a que no usaba ese constructor, ya que fue planteada para la refactorización que hicimos. 
    
    Lo que si notamos en la clase de pruebas AirportTest es que el código de covertura por ramas ahora es del 100 % en la clase Flight y en las que heredan de ella debido a que reemplazamos la estructura condicional con el uso del polimorfismo. La ventaja de esto es que ahora es imposible la situación en la que el vuelo creado tenga un tipo de vuelo no válido. Esto es un paso adelante en la conservación de la integridad de la información de los objetos que maneja nuestro sistema.

- **Fase 3**

    Siguiendo la métodología TDD, primero creamos las pruebas unitarias. Replicamos la estructura de clases anidadas de las pruebas que ya tenemos, que además usan anotaciones que siguen la plantilla GWT (given, when, then). Cuando ya están implementadas las pruebas, creamos una clase que hereda de Flight llamada PremiumFlight para implementar la lógica del nuevo tipo de vuelo. Sobreescribimos los métodos abstractos _addPassenger()_ y _removePassenger()_ de forma que se pueda agregar y eliminar un pasajero VIP, pero nada de lo anterior para un pasajero regular.
    

    

