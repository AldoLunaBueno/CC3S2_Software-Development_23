# SOLID <!-- omit in toc -->

- [SRP - Principio de responsabilidad única](#srp---principio-de-responsabilidad-única)
  - [Programa inicial](#programa-inicial)
  - [Demostración sin SRP](#demostración-sin-srp)
  - [Mejor programa](#mejor-programa)
  - [Demostración con SRP](#demostración-con-srp)
- [OCP - Principio abierto/cerrado](#ocp---principio-abiertocerrado)
  - [Programa inicial](#programa-inicial-1)
  - [Demostración sin OCP](#demostración-sin-ocp)
  - [Mejor programa](#mejor-programa-1)
  - [Demostración con OCP](#demostración-con-ocp)
- [LSP - Principio de Sustitución de Liskov](#lsp---principio-de-sustitución-de-liskov)
  - [Programa inicial](#programa-inicial-2)
  - [¿Cuál es la solución?](#cuál-es-la-solución)
  - [ISP - Principio de segregación de interfaz](#isp---principio-de-segregación-de-interfaz)
  - [Programa inicial](#programa-inicial-3)
  - [Mejor programa](#mejor-programa-2)
- [DIP - Principio de inversión de dependencia](#dip---principio-de-inversión-de-dependencia)
  - [Programa inicial](#programa-inicial-4)
  - [Mejor programa](#mejor-programa-3)


**Actividad grupal**

Descarga la actividad incompleta desde aquí:
https://github.com/kapumota/Actividades/tree/main/SOLID/SOLID  
Inicia un repositorio llamado CC-3S2 y dentro una carpeta llamada Actividades. Dentro de esta carpeta abre una carpeta llamada SOLID y coloca todas tus respuestas.
No es una tarea calificada, solo es un repaso de lo realizado en clase.

## SRP - Principio de responsabilidad única
Una clase actúa como un contenedor que puede contener muchas cosas, como datos, propiedades o
métodos. Si ingresas demasiados datos o métodos que no están relacionados entre sí, terminarás con
una clase voluminosa que te puede crear problemas en el futuro. 

### Programa inicial
El código inicial tiene una clase Empleado con tres métodos diferentes. Aquí están los detalles:

- `displayEmpDetail()` muestra el nombre del empleado y su experiencia laboral en años.

- `generateEmpId()` genera una identificación de empleado mediante la concatenación
de cadenas. La lógica es simple: concateno la primera palabra del primer nombre con un número
aleatorio para formar una identificación de empleado. Después de la demostración dentro del
método main() (el código del cliente) creo dos instancias de Empleado y uso estos métodos para
mostrar los detalles relevantes.

- `checkSeniority()` evalúa si un empleado es una persona con mayor experiencia. Supongamos que si el
empleado tiene más de 5 años de experiencia, es un empleado senior; de lo contrario, es un
empleado junior

### Demostración sin SRP

- Empleado.java
- Cliente.java

**Pregunta:** Realiza una salida de muestra. Ten en cuenta que la identificación(ID) de un empleado puede
variar en tu caso porque genera un número aleatorio para obtener la identificación (ID) del empleado.

![](sources/2023-05-14-19-49-45.png)

Esta salida es proporcionada por el método `showEmpDetail()` de la clase `Cliente`:

![](sources/2023-05-14-20-48-05.png)

**Pregunta:** ¿Cuál es el problema con este diseño?

El problema es que la clase `Empleado` hay métodos que podrían crecer mucho, y mantenerlos dentro de esta clase haría su uso y mantenimiento más difícil. 

En la clase `Empleado` tenemos dos métodos que en el futuro pueden mejorarse y volverse complejos: `checkSeniority()` y `generateEmpId()`. ¿Por qué? En cuanto al primer método, se pueden añadir etapas intermedias entre junior y senior, o añadir más parámetros en el cálculo como la calidad de la experiencia, o la cantidad e impacto de los proyectos desarrollados. En cuanto al segundo, se pueden generar los códigos de identificación con algoritmos más elaborados, que tomen en cuenta factores como el año de ingreso a la empresa.

En la clase `Empleado` hay un tercer método llamado  `displayEmpDetail()`. También puede cambiar, pero no con la misma fuerza que los otros dos métodos, por lo que no parece necesario crear una clase específica para él.

### Mejor programa

En la siguiente demostración, se presentan dos clases más. La clase SeniorityChecker ahora contiene el
método checkSeniority() y la clase GeneradorIDEmpleado contiene el método generateEmpId(...) para
generar la identificación del empleado. Como resultado, en el futuro, si necesitas cambiar la lógica del
programa para determinar el nivel de antigüedad o utilizar un nuevo algoritmo para generar una
identificación del empleado, puedes realizar los cambios en las clases respectivas. Otras clases están
intactas, por lo que no necesitas volver a probar esas clases.

Para mejorar la legibilidad del código y evitar torpezas dentro del método main(), se utiliza el método
estático showEmpDetail(...). Este método llama al método displayEmpDetail() de Empleado, al método
generateEmpId() de GeneradorIDEmpleado y al método checkSeniority() de SeniorityChecker. 

Debes entender que este método no era necesario, pero hace que el código del cliente sea simple y fácilmente
comprensible.

### Demostración con SRP

- Empleado.java
- GeneradorIdEmpleado.java
- SeniorityChecker.java
- Cliente.java

**Pregunta:** Realiza una demostración completa que sigue a SRP. Explica los resultados.

La salida es la misma de antes. Sin embargo, vemos la primera diferencia en la implementación del método `showEmpDetail()` de la clase `Cliente`.

![](sources/2023-05-14-20-46-01.png)

Aquí nos damos cuenta de que, por ejemplo, el método `checkSeniority()` ahora es llamado por un objeto de la clase `SeniorityChecker`. Además, se le pasa como parámetro de número entero la experiencia del empleado. Si bien este y el otro método `generateEmpId()` se separaron en clases distintas, se ve que su uso es un poco precario. Esto porque nada nos previene de introducir, por ejemplo en el primer método, un entero arbitrario.

**Importante:** Ten en cuenta que el SRP no dice que una clase deba tener como máximo un método. Aquí el
énfasis está en la responsabilidad individual. puede haber métodos estrechamente relacionados que
pueden ayudarte a implementar una responsabilidad. 

## OCP - Principio abierto/cerrado

El Principio Abierto-Cerrado (OCP) fue acuñado en 1988 por Bertrand Meyer. Dice: Un artefacto de
software debe estar abierto para extensión pero cerrado para modificación. 

En 1988, Bertrand Meyer sugirió el uso de la herencia en este contexto. Wikipedia
(https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle), el menciona su cita de la siguiente
manera:

"Una clase está cerrada, ya que puede compilarse, almacenarse en una biblioteca, establecer una línea de
base y ser utilizada por clases de clientes. Pero también es abierto, ya que cualquier clase nueva puede
usarlo como padre, agregando nuevas funciones. Cuando se define una clase descendiente, no hay
necesidad de cambiar el original o molestar a sus clientes."

Pero la herencia promueve un acoplamiento estrecho. En programación, se busca eliminar estos
acoplamientos estrechos. Robert C. Martin mejoró la definición y la convirtió en OCP polimórfico. La
nueva propuesta usa clases base abstractas que usan los protocolos en lugar de una superclase para
permitir diferentes implementaciones. Estos protocolos están cerrados a la modificación y proporcionan
otro nivel de abstracción que permite un acoplamiento débil.


### Programa inicial

Supongamos que hay un pequeño grupo de estudiantes que toman un examen semestral. 
Irene, Jessica, Chalo y Claudio son los cuatro estudiantes de
este ejemplo. Todos ellos pertenecen a la clase Estudiante. Para crear una instancia de clase de
Estudiante, debes proporcionar un nombre, un número de registro y las calificaciones obtenidas en el
examen. También se debe mencionar si un estudiante pertenece al departamento de Ciencias o al departamento
de Artes. 

Para simplificar, supongamos que una universidad en particular tiene los siguientes cuatro
departamentos:

- Ciencias de la Computación
- Física
- Historia
- Inglés

Cuando un estudiante opta por informática o física, decimos que opta por la rama de ciencias. De igual
forma, cuando un estudiante pertenece al departamento de Historia o Inglés, es un estudiante de artes.
Comenzamos con dos métodos de instancia en este ejemplo. displayResult() que muestra el resultado con
todos los detalles necesarios de un estudiante y el método de evaluateDistinction() que evalúa si un
estudiante es elegible para un certificado de distinción. 

Si un estudiante de ciencias obtiene una puntuación superior a 80 en este examen, obtiene el certificado con distinción. 
Pero el criterio para un estudiante de artes se relaja un poco. Un estudiante de artes obtiene la distinción si su puntaje es
superior a 70.
Si entiendes el principio SRP mencionado anteriormente no querrás colocar displayResult() y evaluateDistinction()
en la misma clase.

```
class Student {
public void displayResult() {
   // código
  }
public void evaluateDistinction() {   
   // código
   }
}
`
```

**Pregunta:** ¿Por qué?

El método `evaluateDistinction()` puede tener que modificarse según el criterio para evaluar a los estudiantes, y también se puede complicar. Conviene entonces manejarlo en una clase aparte.

### Demostración sin OCP

- Estudiante.java
- DistinctionDecider.java
- Cliente.java


**Pregunta:** Realiza una salida de muestra.

![](sources/2023-05-14-22-43-36.png)

![](sources/2023-05-14-22-43-05.png)

**Pregunta:** Modifica el método de evaluateDistinction() y agrega otra instrucción if para considerar a
los estudiantes de comercio. ¿Está bien modificar el método evaluateDistinction() de esta manera?

En la clase `DistinctionDecider` primero nos vimos obligados a agregar la línea 8 para definir el nuevo arreglo de departamentos de comercio, con la variable `trade`. Luego recién agregamos el condicional en la línea 23.

![](sources/2023-05-14-23-02-24.png)

Y, para mostrar su uso, en el método `enrollStudents()` de la clase `Cliente` instanciamos dos estudiantes de esta nueva rama de comercio.

![](sources/2023-05-14-23-09-37.png)

Aquí mostramos la ejecución:

![](sources/2023-05-15-06-08-50.png)

![](sources/2023-05-14-22-59-23.png)

Si bien logramos la salida esperada, nos dimos cuenta de dos cosas. La primera es que para modificar el método `evaluateDistinction()` tuvimos que cambiar algo fuera del método, pero dentro de la clase: crear una nueva variable de instancia `trade`. La segunda es que nos pasó que, intentando mejorar la ortografía de los departamentos, la salida de las distinciones cambió porque los departamentos escritos en `Cliente` tenían una tilde más o menos respecto de los escritos en `DistinctionDecider` y ya no eran reconocidos por los condicionales dentro del método `evaluateDistinction()`. 

Claramente esta implementación da problemas a la hora de modificar cosas.

### Mejor programa

El OCP se puede lograr de diferentes maneras, pero la abstracción es el corazón de este principio. Si puedes diseñar tu aplicación siguiendo el OCP, tu aplicación es flexible y extensible. No siempre es fácil implementar completamente este principio, pero el cumplimiento parcial de OCP puede generarte un mayor beneficio. 

### Demostración con OCP

- Estudiante.java
- ArteEstudiante.java
- CienciaEstudiante.java
- DistinctionDecider.java
- ScienceDistinctionDecider.java
- ArtsDistinctionDecider.java
- Cliente.java

**Pregunta:**. Para abordar este problema, puedes escribir un mejor programa. Puedes modificar el código dado de la actividad y utilizar el principio OCP que sugiere que escribamos segmentos de código (como clases o métodos) que están abiertos para la extensión pero cerrados para la modificación. Realiza una salida de muestra de tu respuesta. Explica los cambios realizados

La salida es la misma que antes:

![](sources/2023-05-15-06-38-56.png)

Pero ahora tenemos abstracción: la clase abstracta `Estudiante` y la interface `DistinctionDecider`. La clase abstracta es extendida por `ArteEstudiante` y `CienciaEstudiante`. La interface es implementada por `ArtsDistinctionDecider` y `ScienceDistinctionDecider`.

Creemos que no era necesario crear la clase abstracta, ya que las clases que la extienden por ahora son exxactamente iguales.

![](sources/2023-05-15-06-56-05.png)

Además, ¿qué pasa si uno crea la clase `TradeDistinctionDecider` pero se olvida de crear la clase `ComercioEstudiante`?

Pero, bueno, ahora veamos una de las implementaciones de la interface:

![](sources/2023-05-15-06-59-10.png)

El método `evaluateDistinction()` de la interface es implementado aquí. Para esto de todos modos es necesario crear un lista de nombres de los departamentos profesionales. La llamamos `science`. Además, refactorizamos el método con una técnica llamada cláusula de guarda para evitar caer en un futuro en el anidamiento masivo, que ya es hasta un meme:

![](sources/2023-05-15-07-09-57.png)


**Pregunta:**  ¿Cuáles son las principales ventajas ahora?



## LSP - Principio de Sustitución de Liskov

El LSP dice que deberías poder sustituir un tipo padre (o base) con un subtipo. Significa que en un segmento de programa. puedes usar una clase derivada en lugar de una clase base sin alterar la correción del programa.

### Programa inicial

**Pregunta:** Utilizas un portal de pago en línea para pagar una factura. Como eres un usuario registrado, cuando realizas una solicitud de pago en este portal, también se muestra tus pagos anteriores. Considera un ejemplo simplificado basado en este escenario de la vida real. 
Supongamos que también tienes un portal de pago donde un usuario registrado puede realizar una solicitud de pago. Utiliza el método newPayment() para esto. En este portal, también puedes mostrar los detalles del último pago del usuario utilizando un método llamado previousPaymentInfo(). Se crea la clase de ayuda PaymentHelper para mostrar todos los pagos anteriores y las nuevas solicitudes de pago de estos usuarios. Utiliza showPreviousPayments() y processNewPayments() para estas actividades.
Estos métodos llaman a previousPaymentInfo() y newPayment() en las respectivas instancias de pago. 

Utiliza una instrucción for mejorada (a menudo se denomina bucle for mejorado) para cumplir estos propósitos.
Dentro del código del cliente, crea dos usuarios y muestra sus solicitudes de pago actuales junto con los pagos anteriores.  Eso lleva a lo siguiente:


- Payment.java
- RegisteredUserPayment.java
- PaymentHelper.java
- Cliente.java

**Pregunta:**. Realiza una salida de muestra.

Este programa parece estar bien. Ahora supongamos que tienes un nuevo requisito que dice que necesitas admitir usuarios invitados en el futuro. Puedes procesar la solicitud de pago de un usuario invitado, pero no se muestra su último detalle de pago. Entonces, creas la siguiente clase que implementa la interfaz de pago:

```
class GuestUserPayment implements Payment {
String name;
   public GuestUserPayment() {
   this.name = "guest"; 
   }
   @Override
   public void previousPaymentInfo(){
      throw new UnsupportedOperationException();
}
@Override
   public void newPayment(){
   System.out.println("Procesando de "+name+ "pago actual
   request.");
   }
}
```
**Pregunta:** Dentro del método main(), ahora crea una instancia de usuario invitado e intenta usar su clase auxiliar de la misma manera. 

**Pregunta:** Realiza una salida de muestra y describe la excepción resultante. ¿Cuál es el problema?.

### ¿Cuál es la solución?

La primera solución obvia que se te puede ocurrir es introducir una cadena if-else para verificar si la instancia de pago es un pago de usuario invitado (GuestUserPayment) o un pago de usuario registrado (RegisteredUserPayment). ¿Es una buena solución?

**Pregunta:** Elimina el método newPayment() de la interfaz de payment. Coloca este método en otra interfaz llamada NewPayment. Ahora tienes dos interfaces con las operaciones específicas. Dado que todos los tipos de usuarios pueden generar una nueva solicitud de pago, las clases concretas de RegisteredUserPayment y GuestUserPayment implementan la interfaz NewPayment y muestran el último detalle de pago solo para los usuarios registrados. Así la clase RegisteredUser implementa la interfaz payment. 
Dado que Payment contiene el método previousPaymentInfo(), tiene sentido elegir un nombre mejor, como PreviousPayment en lugar de Payment. Entonces, ahora deberías ver las siguientes interfaces:


```
interface PreviousPayment {
   void previousPaymentInfo();
}
interface NewPayment {
   void newPayment();
}
```

Ajusta estos nuevos nombres en la clase auxilial. Debes tener completados los siguientes archivos.

- PreviousPayment.java
- NewPayment.java
- RegisteredUserPayment.java
- GuestUserPayment.java
- PaymentHelper.java
- Cliente.java

**Problema:** ¿cuáles son los cambios clave?. Explica tus resultados.

### ISP - Principio de segregación de interfaz

Sugiere que no contamines una interfaz con  métodos innecesarios solo para admitir una (o algunas) de las clases de implementación de esta interfaz. La idea es que un cliente no debe depender de un método que no utiliza.

### Programa inicial

Supongamos que tiene la interfaz Impresora con dos métodos, printDocument() y sendFax(). Hay varios usuarios de esta clase. Para simplificar, consideremos solo dos de ellos: BasicPrinter y AdvancedPrinter.

Una impresora básica puede imprimir documentos. No es compatible con ninguna otra funcionalidad. Por lo tanto, BasicPrinter solo necesita el método printDocument(). Una impresora avanzada puede imprimir documentos y enviar faxes. Entonces, AdvancedPrinter necesita ambos métodos.
En este caso, un cambio en el método sendFax() en AdvancedPrinter puede obligar a la interfaz Printer a cambiar, lo que a su vez obliga al código de BasicPrinter a recompilarse. Esta situación no es deseada y puede causarte problemas potenciales en el futuro.

**Pregunta:** En este caso ISP sugiere que diseñes tu interfaz con los métodos adecuados que un cliente en particular pueda necesitar. ¿Por qué un usuario necesita cambiar una clase base (o una interfaz)?

**Pregunta:** ¿Ayuda escribir código polimórfico como el siguiente?. Explica tu respuesta.

```
Impresora impresora = new ImpresoraAvanzada();
impresora.printDocument();
impresora.sendFax();
impresora = new ImpresoraBasica();
impresora.printDocument();
// impresora.sendFax();
``` 

**Pregunta:** ¿Qué sucede si escribimos algo así en el código dado?

```
List<Impresora> impresoras = new ArrayList<Impresoras>();
impresoras.add(new ImpresoraAvanzada());
impresoras.add(new ImpresoraBasica());
for (Impresora device : impresoras) {
  device.printDocument();
// device.sendFax();
}
```

Realiza una demostración:

- Impresora.java
- ImpresoraBasica.java
- ImpresoraAvanzada.java
- Cliente.java

**Problema:** Supongamos que necesitas admitir otra impresora que pueda imprimir, enviar faxes y fotocopiar. En este caso, si agregas un método de fotocopiado en la interfaz Impresora, los dos clientes existentes, ImpresoraBasica y Impresora Avanzada, deben adaptarse al cambio.

### Mejor programa

Busquemos una mejor solución. Entiendes que hay dos actividades diferentes: una es imprimir unos documentos y la otra es enviar un fax. Entonces, en el siguiente ejemplo, crea dos interfaces llamada Impresora y DispositivoFax. Impresora contiene el método printDocument() y FaxDevice contiene el
método SendFax(). La idea es sencilla:

- La clase que desea la función de impresión implementa la interfaz Impresora y la clase que desea la función de fax implementa la interfaz DispositivoFax.
- Si una clase quiere ambas funcionalidades, implementa ambas interfaces.
-
No debes asumir que el ISP dice que una interfaz debe tener solo un método. En este ejemplo, hay dos métodos en la interfaz de Impresora y la clase ImpresoraBasica necesita solo uno de ellos. Es por eso que ves las interfaces segregadas con un solo método.

**Pregunta - SOLID :** Realiza una salida de muestra 

- Impresora.java
- DispositivoFax.java
- ImpresoraBasica.java
- ImpresoraAvanzada.java
- Cliente.java

**Pregunta:**¿Qué sucede si usas un método predeterminado dentro de la interfaz? Por ejemplo, si proporcionas un método de fax predeterminado en una interfaz (o una clase abstracta), ImpresoraBasica debes sobreescribirlo y decir algo similar a lo siguiente:

```
@Override
public void sendFax() {
  throw new UnsupportedOperationException();
}
```

**Pregunta:** ¿Viste el problema potencial con esto! . Pero, ¿qué sucede si usas un método vacío, en lugar de lanzar la excepción?.

## DIP - Principio de inversión de dependencia

El DIP cubre dos cosas importantes:

- Una clase concreta de alto nivel no debe depender de una clase concreta de bajo nivel. En cambio, ambos deberían depender de abstracciones.
- Las abstracciones no deben depender de los detalles. En cambio, los detalles deberían depender
de abstracciones.

La razón del primer punto es simple. Si la clase de bajo nivel cambia, la clase de alto nivel necesita adaptarse al cambio; de lo contrario, la aplicación se rompe. ¿Qué significa esto? Significa que debes evitar crear una clase concreta de bajo nivel dentro de una clase de alto nivel. En su lugar, debes utilizar clases o interfaces abstractas. Como resultado, elimina el acoplamiento estrecho entre las clases.

El segundo punto también es fácil de entender cuando analizas el caso de estudio discutido en la sección ISP. Viste que si una interfaz necesita cambiar para admitir uno de sus clientes, otros clientes pueden verse afectados por el cambio. A ningún cliente le gusta ver una aplicación así. Entonces, en tu aplicación, si tus módulos de alto nivel son independientes de los módulos de bajo nivel, puedes reutilizarlos
fácilmente. Esta idea también te ayuda a diseñar frameworks agradables.

Robert C. Martin explica que un modelo de desarrollo de software tradicional en esos días (como el análisis y el diseño estructurados) tiende a crear software en el que los módulos de alto nivel solían depender de módulos de bajo nivel. Pero en OOP, un programa bien diseñado se opone a esta idea. Aquí se invierte la estructura de dependencia que a menudo resulta de un método de procedimiento tradicional. Esta es la razón por la que usó la palabra "inversión" en este principio.

### Programa inicial

Supongamos que tienes una aplicación de dos capas. Usando esta aplicación, un usuario puede guardar una identificación de empleado en una base de datos. Para demostrar esto, usamos una aplicación de consola en lugar de una aplicación GUI. Tiene dos clases, InterfazUsuario y OracleDatabase. Según su
nombre. InterfazUsuario representa una interfaz de usuario como un formulario donde un usuario puede escribir una identificación de empleado y hacer clic en el botón Guardar para guardar la identificación en una base de datos. OracleDatabase se utiliza para imitar una base de datos Oracle.

Nuevamente, para simplificar, no hay una base de datos real en esta aplicación y no hay un código para validar una identificación de empleado. Aquí tu atención se centra únicamente en el DIP. Al usar el método saveEmployeeId() de UserInterface, puedes guardar una identificación de empleado en una base de datos. Observa el código para la clase InterfazUsuario:

```
public class InterfazUsuario {
 private OracleDatabase oracleDatabase;
 public InterfazUsuario() {
   this.oracleDatabase = new OracleDatabase();
}
   public void saveEmployeeId(String empId) {
      oracleDatabase.saveEmpldlnDataBase(empld);
      }
  }
```

Tienes los archivos siguientes:

- InterfaceUsuario.java
- OracleDataBase.java
- Cliente.java

**Pregunta:** Realiza una salida de muestra. ¿Cuáles son los problemas que adolece el código?

### Mejor programa

En la lista de programas verás la siguiente jerarquía:

- BaseDatos.java
- OracleDatabase.java

La primera parte del DIP sugiere que nos centramos en la abstracción. Esto hace que el programa sea eficiente. Entonces, esta vez la clase InterfazUsuario tiene como objetivo la base de datos de abstracción, en lugar de una implementación concreta como OracleDatabase. Aquí está la nueva construcción de InterfazUsuario:

```
class InterfazUsuario {
 BaseDatos basedatos;
   public InterfazUsuario(BaseDatos basedatos) {
      this.basedatos = basedatos;
   }
  public void saveEmployeeId(String empId) {
   basedatos.saveEmpIdInDatabase(empId);
   }
}

``` 

Esto brinda la flexibilidad de considerar una nueva base de datos, como MYSQLDatabase también.

La segunda parte del DIP sugiere hacer la interfaz de la base de datos considerando la necesidad de la clase UserInterface. Es importante porque si una interfaz necesita cambiar para admitir a uno de sus clientes, otros clientes pueden verse afectados por el cambio.

Se tienen los archivos siguientes:

- InterfazUsuario.java
- BaseDatos.java
- OracleDataBase.java
- MySQLDatabase.java
- Cliente.java

**Pregunta:** Realiza una salida de muestra. ¿Esto resuelve todos los problemas que adolece el código?.

En resumen, en OOP, sugiero seguir la cita de Robert C. Martin:

"Los módulos de alto nivel simplemente no deberían depender de los módulos de bajo nivel de ninguna manera".

Entonces, cuando tienes una clase base y una clase derivada, tu clase base no debe conocer ninguna de sus clases derivadas. Pero hay pocas excepciones a esta sugerencia. Por ejemplo, considera el caso en el que tu clase base necesita restringir el recuento de las instancias de la clase derivada en un punto
determinado.

**Pregunta:** Puedes ver que en la demostración, el constructor de la clase InterfazUsuario acepta un parámetro de base de datos.
Puedes proporcionar una instalación adicional a un usuario cuando utilizas tanto el constructor como el
método setter (setDatabase) dentro de esta clase. Aquí hay un código de muestra.


```
class InterfazUsuario {
   BaseDatos basedatos;
   public InterfazUsuario(BaseDatos basedatos) {
      this.basedatos = basedatos;
   }
   public void setDatabase(BaseDatos basedatos) {
      this.basedatos = basedatos;
   }
   public void saveEmployeeId(String empId) {
      basedatos.saveEmpIdInDatabase(empId);
   }
}
```

**Pregunta:** ¿Cuál es el beneficio de hacer esto?.

Puedes agregar la última parte de este segmento al final de main() para ver el nuevo resultado.


```
// Usando Mysql
basedatos = new MySQLDatabase();
usuario = new InterfazUsuario(basedatos);
usuario.saveEmployeeId("E002");

// Cambiando la base de datos objetivo
//usuario = new InterfazUsuario(new OracleDatabase());
usuario.setDatabase(new OracleDatabase());
usuario.saveEmployeeId("E002");
``` 

**Pregunta:** Verifica tus resultados.

