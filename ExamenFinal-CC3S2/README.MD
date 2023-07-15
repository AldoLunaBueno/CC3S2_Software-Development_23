# Examen Final de Desarrollo de Software - CC3S2 <!-- omit in toc-->

# Pregunta 1

- **Antes**
  
    Primero tenemos tres clases: Airport, FLight y Passangers. Airport funciona aquí como cliente de las otras dos clases, que capturan la lógica de negocio. Imprime las listas de pasajeros de vuelos de negocios y de vuelos económicos.
    
    Para cada vuelo se crea una instancia de Flight cuyo contructor pide un ID y el tipo de vuelo como una cadena. Esto se debe refactorizar. También se añade cada pasajero a su vuelo correspondiente usando el método `addPassanger()` de la clase Flight y se remueve un pasajero usando `removePassanger()`. Todo esto implica una lógica de qué pasajeros se pueden añadir y remover de un vuelo según su estatus como pasajero VIP o regular.

- **Fase 1**

    Siguiendo la métodología TDD, implementamos la clase de prueba FlightTest, que codifica los requerimientos dados sobre el vuelo económico y el de negocios para pasajeros regulares y VIP. La prueba con covertura de código de ramas da un porcentaje del 66 % de forma global. La clase que no tiene 100 % de covertura de ramas es Flight. Esto es porque contiene dos estructuras switch en donde el caso por defecto lanza una excepción cuando no se introduce un tipo de vuelo correcto, pero no probamos este caso. Podemos evitar usar esta estructura condicional si refactorizamos guiándonos del principio abierto-cerrado usando polimorfismo.

- **Fase 2**

    Convertimos la clase Flight en una clase abstracta cuyos métodos _addPassenger()_ y _removePassenger()_ ahora son abstractos. La lógica para decidir agregar y eliminar pasajeros según su estatus como pasajero VIP o regular ahora es capturada por separado por las clases que implementan a la clase Flight: EconomyFlight y BusinessFlight. Esta refactorización nos permite poder agregar en el futuro nuevos tipos de vuelo que contenga nueva lógica sin necesidad de modificar la clase Flight, preservando el principio abierto-cerrado.

    En este proceso de refactorización, IntelliJ nos ayudó a propagar los cambios efectuados en las demás clases reportando distintos problemas en el código. Tanto la clase cliente Airport como la clase de prueba AirportTest sufrieron cambios en su implementación. Ambas clases usaban el constructor de la clase Flight y se les pasaba como parámetro el tipo de vuelo como String, lo cual en esta fase fue eliminado y superado. Ahora es necesario crear una instancia de una de las clases concretas que extienden a Flight según corresponda.  Otra cosa interesante es que no tuvimos la necesidad de cambiar la llamada de los métodos gracias al polimorfismo.

    Algo más que notamos en la clase de pruebas AirportTest es que el código de covertura por ramas ahora es del 100 % en la clase Flight y en las que heredan de ella. Esto se logró sin agregar nuevos casos de prueba. La razón es que reemplazamos la estructura condicional con el uso del polimorfismo. La ventaja de esto es que ahora es imposible la situación en la que el vuelo creado tenga un tipo de vuelo no válido. Esto es un paso adelante en la conservación de la integridad de la información de los objetos que maneja nuestro sistema.

- **Fase 3**

    Cambiamos la clase de pruebas AirportTest que habíamos implementado por la que se nos ha dado para esta pregunta. Ejecutamos las pruebas y todas nos dan verde, así que podemos seguir.
    
- **Fase 4**
    
    Basándonos en esta clase de pruebas refactorizada, AirportTest, implementamos los requerimientos del nuevo tipo de vuelo replicando la estructura y las anotaciones de clases anidadas y los mensajes que siguen la plantilla GWT (given, when, then). Creamos la clase de prueba anidada PremiumFlightTest, y en ella a su vez las clases anidadas RegularPassenger y VipPassenger, donde implementamos respectivamente los casos de prueba _testPremiumFlightRegularPassenger()_ y _testPremiumFlightVipPassenger()_. 

    Ahora que ya están implementadas las pruebas, creamos una clase que hereda de Flight llamada PremiumFlight para implementar la lógica del nuevo tipo de vuelo. Sobreescribimos los métodos abstractos _addPassenger()_ y _removePassenger()_ en esta nueva clase de forma que se pueda agregar y eliminar un pasajero VIP, pero nada de lo anterior para un pasajero regular.

    Primero nos damos cuenta que con una implementación mínima de los métodos en la que estos solo retornan _false_, el caso de prueba para un pasajero regular pasa. Completamos la implemenación para que los dos casos de prueba abregados den verde.

    La covertura del código es del 100 % en todas las métricas, sin considerar la clase cliente Airport.

- **Fase 5**

    En la clase Flight, el cambio de lista a conjunto se propagó solo al método _getPassengersList()_, en donde convertimos de conjunto a lista para no modificar el tipo de dato de retorno. Los métodos que usamos aquí aplicados a las listas tienen el mismo nombre que sus equivalentes para conjuntos, así que no cambiamos nada más en la clase Flight. Además, la clase de pruebas queda intacta y las pruebas pasan sin problemas.

    Creamos la clase de prueba anidada UniquenessFlightTest, que a su vez anida las clases RegularPassenger y VipPassanger, análogamente a las demás pruebas. En ellas implementamos los casos de prueba _testUniquenessFlightRegularPassenger()_ y _testUniquenessFlightVipPassenger()_, las cuales verifican que un pasajero regular no se puede agregar más de una vez al mismo vuelo. Solo lo hacemos para el caso de un vuelo de tipo económico porque, aunque la lógica de los métodos _addPassenger()_ y _removePassenger()_ cambian entre las clases hijas de Flight, la pieza clave que aquí se prueba es el conjunto passengers, el cual solo está en la clase abstracta Flight. Por eso pensamos que basta probar este comportamiento con una sola implementación de la clase Flight, y elegimos la clase EconomyFlight porque pensamos que es muy difícil que se tome la decisión empresarial de quitarla en el futuro.

    No conseguimos mejor covertura de código. Esto constata el hecho de que la covertura de código solo es un indicador de la calidad del software, no una medida de esta.

        
    
