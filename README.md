
# Microservicio de Mensajeria Fisica 📦


Este proyecto consiste en un microservicio que se encarga de la gestión de la mensajería física de paquetes. Está desarrollado en Java 11 con el framework Spring Boot 2.7.11 y cuenta con conexión a una base de datos MySQL.

El microservicio proporciona diferentes operaciones CRUD para las entidades de Paquete, Cliente  Empleado, implementadas utilizando el patrón de diseño DAO para Repository y siguiendo los principios SOLID. Además, se han desarrollado querys personalizados de JPA para mejorar la eficiencia y la velocidad de acceso a la base de datos.

El proyecto también incorpora patrones de diseño como la inyección de dependencias y los patrones de comportamiento Chain of Responsibility, Dto, Dao, Factory.

El patrón Chain of Responsibility se utiliza para la validación de entradas, lo que permite pasar solicitudes a través de una cadena de manejadores, asegurando que las entradas sean válidas antes de que se realice cualquier operación de almacenamiento en la base de datos.

En resumen, este microservicio de mensajería física de paquetes es una solución eficiente y escalable para la gestión de la mensajería física de paquetes, con operaciones CRUD, querys personalizados de JPA, patrones de diseño, principios SOLID y patrones de comportamiento.


Para acceder a la documentación de la API 💻, haz clic [aquí](https://microserviciomensajeriafisica-production.up.railway.app/swagger-ui/index.html#/)

<div style="display:flex;">

<img src="https://user-images.githubusercontent.com/50783391/232255841-ca02df30-398c-4b98-b9eb-098f2adc092c.png" width="200">
<img src="https://user-images.githubusercontent.com/50783391/233194943-8b5fa737-8ee7-4a30-8ee7-fc961b901dae.png" width="250">

</div >


👷 Tecnologias utlizadas

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


## 🏛 Entidades :

- Customer
- Package
- SendPackage


## 🌐 Diagrama de entidades :

![diagrama de clases](https://user-images.githubusercontent.com/50783391/233198946-f2bd91f6-eb1c-4634-ab08-8bd649f5ed55.png)



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




para crear un empleado 
{

  "cedula": 1212,
  "name": "javier enrique",
  "lastName": "urgo",
  "numeroCelular": 1212121,
  "correoElectronico": "pedro@string.com",
  "direccionResidencia": "los colores",
  "ciudad": "medellin",
  "antiguedad": "2022-04-17",
  "tipoSangreRH": "o+",
  "typeEmpleoyer": "CONTADOR"
}


respuesta 

	
Response body
Download
{
  "cedula": 1212,
  "name": "javier enrique",
  "lastName": "urgo",
  "numeroCelular": 1212121,
  "correoElectronico": "pedro@string.com",
  "direccionResidencia": "los colores",
  "ciudad": "medellin",
  "typeEmpleoyer": "CONTADOR",
  "antiguedad": "2022-04-17T00:00:00.000+00:00",
  "tipoSangreRH": "o+"
  
  
  
}

 { "cedula": 1212, "name": "javier enrique", "lastName": "urgo", "numeroCelular": 1212121, "correoElectronico": "pedro@string.com", "direccionResidencia": "los colores", "ciudad": "medellin", "typeEmpleoyer": "CONTADOR", "antiguedad": "2022-04-17T00:00:00.000+00:00", "tipoSangreRH": "o+" }
