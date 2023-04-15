
# Microservicio de Mensajeria Fisica


El Microservicio de Mensajería Física es una Api Rest  que proporciona operaciones CRUD (crear, leer, actualizar, eliminar) para las entidades de cliente, reserva y habitación.



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


### Patron Structural Flyweight

Flyweight es un patrón de diseño estructural que te permite mantener más objetos dentro de la cantidad disponible de RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.



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
