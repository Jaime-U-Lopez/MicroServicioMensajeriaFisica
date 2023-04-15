
# Microservicio de Mensajeria Fisica


Este proyecto consiste en un microservicio que se encarga de la gestión de la mensajería física de paquetes. Está desarrollado en Java 11 con el framework Spring Boot 2.7.11 y cuenta con conexión a una base de datos MySQL a través del conector com.mysql:mysql-connector-j:8.0.32.

El microservicio proporciona diferentes operaciones CRUD para las entidades de paquete, remitente y destinatario, implementadas utilizando el patrón de diseño DAO para Repository y siguiendo los principios SOLID. Además, se han desarrollado querys personalizados de JPA para mejorar la eficiencia y la velocidad de acceso a la base de datos.

El proyecto también incorpora patrones de diseño como la inyección de dependencias y los patrones de comportamiento Chain of Responsibility y Structural Flyweight.

El patrón Chain of Responsibility se utiliza para la validación de entradas, lo que permite pasar solicitudes a través de una cadena de manejadores, asegurando que las entradas sean válidas antes de que se realice cualquier operación de almacenamiento en la base de datos.

Las entidades del proyecto incluyen paquete, remitente y destinatario. Cada una de ellas cuenta con sus propios atributos y operaciones CRUD para su gestión.

En resumen, este microservicio de mensajería física de paquetes es una solución eficiente y escalable para la gestión de la mensajería física de paquetes, con operaciones CRUD, querys personalizados de JPA, patrones de diseño, principios SOLID y patrones de comportamiento.


La API del Microservicio de Mensajería Física se puede ver en http://localhost:8080/swagger-ui/index.html#/. Allí, podrás probar y documentar las diferentes operaciones CRUD que se pueden realizar en las entidades de cliente, reserva y habitación.



* Java 11
* Spring boot 2.7.11
* Con concexión a la base de datos de MYSQL ( com.mysql:mysql-connector-j:8.0.32)
* Con Data Jpa 2.7.11
* Con Junit 4 version 2.7.11
* Mokito para pruebas unitarias, como interceptor y emulador de base de datos
* Con Swagger 3.0.0
* Queryz personalizados de Jpa
* Inyección de dependencias
* Maven como gestor de dependencias
* Patrones DTO y Diseño DAO para Repository

### Patron de comportamiento Chain of Responsibility

Chain of Responsibility es un patrón de diseño de comportamiento que te permite pasar solicitudes a lo largo de una cadena de manejadores.
validación de entradas.


## Entidades :

- Cliente
- Reserva
- Habitación


Microservicio de Mensajería Física



Ejemplos de Uso
Para crear un cliente, envía una petición POST a http://localhost:8080/clientes con un JSON como el siguiente:





Para actualizar un cliente, envía una petición PUT a http://localhost:8080/clientes/{id} con un JSON como el siguiente:

json
Copy code
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@gmail.com",
  "telefono": "555-4321"
}
Para obtener todos los clientes, envía una petición GET a http://localhost:8080/clientes.
