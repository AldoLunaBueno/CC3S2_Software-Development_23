# Historias de usuarios (US) y criterios de aceptación <!-- omit in toc -->

- [1. Ejemplos de US](#1-ejemplos-de-us)
- [2. Más ejemplos de US](#2-más-ejemplos-de-us)
- [3. Ventajas de las US](#3-ventajas-de-las-us)
- [4. Desventajas de las US](#4-desventajas-de-las-us)
- [5. Sistema escalable](#5-sistema-escalable)
- [6. ¿Cuándo Agile no conviene?](#6-cuándo-agile-no-conviene)
- [7. Pet Store](#7-pet-store)
- [8. Planificación de Poker](#8-planificación-de-poker)
- [9. Given-When-Then](#9-given-when-then)
- [10. ¿Dónde escribir US?](#10-dónde-escribir-us)

## 1. Ejemplos de US

¿Cuáles de las siguientes no son buenas historias? ¿Por qué?

- El usuario puede ejecutar el sistema en Windows XP y Linux.
- Todos los gráficos y tablas se realizan utilizando una biblioteca de terceros.
- El usuario puede deshacer hasta cincuenta comandos. 
- El software se lanzará el 30 de junio. 
- El software estará escrito en Java. 
- El usuario puede seleccionar su país de una lista desplegable. 
- El sistema utilizará Log4J para registrar todos los mensajes de error en un archivo. 
- Se le pedirá al usuario que guarde su trabajo si no lo ha guardado durante 15 minutos. 
- El usuario puede seleccionar la función "Exportar a XML". 
- El usuario puede exportar datos a XML

**Solución**

- El usuario puede ejecutar el sistema en Windows XP y Linux.
  - ✔ Buena. Es una característica específica del software. Aunque pensamos que podría tratarse más bien como una decisión crítica que se hace en la planificación previa a todos los sprints.
- Todos los gráficos y tablas se realizan utilizando una biblioteca de terceros.
  - ✔ Buena. Aunque falta el beneficio (que podría ser lograr una uniformidad en la presentación de los datos), el objetivo apunta a una restricción del software bien definida.
- El usuario puede deshacer hasta cincuenta comandos. 
  - ❌ Mala. Es muy específica (el requerimiento de deshacer hasta cincuenta comandos es para los criterios de aceptación).
  - ❔ Propuesta: _Como usuario, necesito deshacer los comandos para tener control sobre el flujo de trabajo._
- El software se lanzará el 30 de junio.
  - ❌ Mala. Es una decisión comercial que, aunque puede ser importante, nada tiene que ver con las características del software. Se debería considerar durante la planificación. Además, no está claro cuál es el rol ni cuál es el beneficio.
- El software estará escrito en Java.
  - ❌ Mala. Es una decisión crítica, pero no dice nada sobre lo que hace el software en favor del usuario. Además, no está claro cuál es el rol ni cuál es el beneficio.
- El usuario puede seleccionar su país de una lista desplegable. 
  - ❌ Mala. Considera el rol y el objetivo, pero no el beneficio. Es más, el objetivo está mal planteado porque hace referencia a un elemento gráfico, una lista desplegable.
  - ❔ Propuesta: _Como usuario, necesito seleccionar un país para obtener la hora correspondiente en el sistema de husos horarios._
- El sistema utilizará Log4J para registrar todos los mensajes de error en un archivo.
  - ❌ Mala. Aporta datos irrelevantes. Sigue la plantilla de rol, objetivo y beneficio, pero el rol es incorrecto. Las US se deben mostrar desde la perspectiva de un usuario humano, no desde la de un sistema informático como en este caso.
  - ❔ Propuesta: _Como usuario, necesito que todos los mensajes de error vayan a un archivo para depurarlos._
- Se le pedirá al usuario que guarde su trabajo si no lo ha guardado durante 15 minutos.
  - ❌ Mala. No sigue la plantilla y es muy específico.
  - ❔ Propuesta: _Como usuario, necesito que se me recuerde guardar el trabajo para no perder los nuevos avances._
- El usuario puede seleccionar la función "Exportar a XML".
  - ❌ Mala. Los detalles de la implementación, como el nombre de una función del software, no importan.
- El usuario puede exportar datos a XML.
  - ✔ Buena. Solo faltaría específicar el beneficio. Hay muchos motivos por los que podría querer hacerlo, pero el más inmediato es que quiere usar los datos fuera de la aplicación.
  - ❔ Propuesta: _Como usuario, necesito exportar los datos a XML para usarlos fuera de la aplicación._
## 2. Más ejemplos de US

¿Cuáles de las siguientes no son buenas historias? ¿Por qué?

- Un usuario puede dominar rápidamente el sistema. 
- Un usuario puede editar la dirección en un currículum. 
- Un usuario puede agregar, editar y eliminar múltiples currículos. 
- El sistema puede calcular aproximaciones de puntos de silla para distribuciones de formas cuadráticas en variables normales. 
- Todos los errores de tiempo de ejecución se registran de manera coherente.

**Solución**

- Un usuario puede dominar rápidamente el sistema. 
  - ❌ Mala. Expresa un requerimiento demasiado general y ambiguo.
- Un usuario puede editar la dirección en un currículum.
  - ❌ Mala. Demasiado específico. Un currículum tiene por lo general muchos campos que pueden ser editados de la misma forma en que se edita la dirección, así que sería mejor generalizar el objetivo. Por otro lado, falta especificar el beneficio.
  - ❔ Propuesta: _Como usuario, necesito editar los campos de un currículum para presentarlo a una oposición laboral._
- Un usuario puede agregar, editar y eliminar múltiples currículos.
  - ❌ Mala. Se muestran múltiples objetivos y no se especifica el beneficio. Quizás sería más útil como una épica.
  - ❔ Propuesta épica: _Como usuario, necesito agregar, editar y eliminar múltiples currículos para gestionarlos._
- El sistema puede calcular aproximaciones de puntos de silla para distribuciones de formas cuadráticas en variables normales.
  - ❌ Mala. El cliente seguramente maneja el lenguaje tan específico que usa esta US, pero los desarrolladores pueden tener problemas para entenderlo en esos términos. Además, el rol no es el de un usuario humano. Probablemente el cliente haya escrito la US. (Cualquier agente relacionado con el producto puede crear US). Convendría conversar con el cliente para llegar a un entendimiento mayor de lo que quiere el cliente, porque es muy específico de su área.
- Todos los errores de tiempo de ejecución se registran de manera coherente.
  - ✔ Buena. No se especifica cuál es el rol ni cuál es el beneficio, pero el objetivo está bien.
  - ❔ Propuesta: _Como usuario desarrollador, necesito que se registren todos los errores de tiempo de ejecución de manera coherente para depurarlos._

## 3. Ventajas de las US

¿Cuáles son cuatro buenas razones para usar historias de usuarios para expresar requisitos? 

**Solución**



## 4. Desventajas de las US

¿Cuáles pueden ser dos inconvenientes de usar historias de usuario? 

**Solución**

- Lenguaje ambiguo. Las US deben ser entendibles para todas las personas alrededor del proyecto para que así todos puedan contribuir. Sin embargo, para ello se debe sacrificar la precisión de un lenguaje más técnico.
- No escalables. En un proyecto grande se pueden plantear miles de requerimientos. Las US se desbordan frente a la complejidad de estas situaciones, y hacen falta otros recursos adicionales a las US para hacerlas escalables.

## 5. Sistema escalable

¿Cómo debes manejar un requisito para que un sistema escale y lo usen 1000 usuarios simultáneos? 

**Solución**

- No es la mejor opción, pero una forma sería definir US que progresivamente vayan aumentando el número de usuarios simultáneos. Por ejemplo, una que especifíque 10 usuarios simultáneos, luego otra con 50, otra con 100, 200, 500 y 1000.


## 6. ¿Cuándo Agile no conviene?

Proporciona algunos ejemplos de sistemas que podrían beneficiarse de una consideración más directa de la interfaz de usuario de lo que normalmente se da en un proyecto ágil.

**Solución**



## 7. Pet Store

Imaginemos que tú y un amigo tienen una web de Pet Store y, durante este mes, presentan un 10% de descuento en la suscripción Premium. Entonces, cada vez que un usuario de una cuenta gratuita inicia sesión, se le muestra un mensaje que dice:

```
 ¡Suscríbete a Premium ahora con un 10 % de descuento!

``` 
En este punto y técnicamente hablando, queremos crear un punto final desde donde podamos obtener un descuento de suscripción para un usuario determinado.

**Planificación**

Tú eres el que crea este punto final! Comenzamos reuniendo y creando un ticket de trabajo. Allí, queremos asegurarnos de incluir un  criterios de aceptación. Cuando termines tu trabajo, le pasarás el boleto a tu amigo. El será responsable de probarlo y de asegurarse  de que la implementación  cubra todos los casos de uso que escribimos en esos criterios de aceptación. 

Completa: 

**Descripción** 

```
Queremos crear un punto final en nuestra API que nos permita obtener el descuento disponible para un usuario determinado. 
Más tarde, la interfaz de usuario manejará el valor de descuento recibido y proporcionará el mensaje. 

```

**Criterios de aceptación** 

**Dado**

**Cuando**

**Entonces**

## 8. Planificación de Poker
 
```
Grupos de 3 estudiantes 
    Cartas  0, 1/2, 1, 2, 3, 5, 8, 13, 20, 40, 100, ∞ y ? 
 ```
Estima el esfuerzo (en horas):

```
"Como jugador, necesito un tablero vacío de 3*3  para jugar un juego de TicTacToe".

```


## 9. Given-When-Then

Given-When-Then es un estilo de representación de pruebas, o como dirían sus defensores, especifica el comportamiento de un sistema utilizando [SpecificationByExample](https://en.wikipedia.org/wiki/Specification_by_example). Es un enfoque desarrollado por Daniel Terhorst-North y Chris Matts como parte del [Behavior-Driven Development (BDD)](https://en.wikipedia.org/wiki/Behavior-driven_development). Aparece como un enfoque de estructuración para muchos frameworks  de prueba como Cucumber. 

También puedes verlo como una reformulación del [Four-Phase Test](https://medium.com/test-go-where/developing-automated-tests-with-the-four-phase-test-pattern-b5fe05c24c67) .

Como estamos hablando de usar ejemplos como especificaciones, tiene sentido mostrar esto con un ejemplo: 

```
Característica: el usuario negocia acciones 
Escenario: el usuario solicita una venta antes del cierre de operaciones 
   Dado que tengo 100 acciones de MSFT 
     Y tengo 150 acciones de APPL 
      Y el tiempo es antes del cierre de operaciones.
     Cuando pido vender 20 acciones de MSFT 
      
      Entonces debería tener 80 acciones de MSFT 
       Y debería tener 150 acciones de APPL
        Y debería haberse ejecutado una orden de venta de 20 acciones de MSFT
``` 
El ejemplo anterior usa [Cucumber](https://cucumber.io/), que es una forma popular de escribir [BusinessFacingTest](https://www.martinfowler.com/bliki/BusinessFacingTest.html), pero puedes usar el estilo Given-When-Then con cualquier tipo de prueba. 

Encuentra más ejemplos usando Cucumber.

**Solución**




## 10. ¿Dónde escribir US?

¿Prefieres escribir historias en tarjetas de notas o en un sistema de software? 

En un sistema de software. El trabajo remoto es muy común hoy en día y escribir historias en tarjetas físicas es muy inconveniente en ese contexto.