
# Microservicio de Mensajeria ULTRA FAST 📦


Este proyecto consiste en un microservicio que se encarga de la gestión de la mensajería física de paquetes. Está desarrollado en Java 11 con el framework Spring Boot 2.7.11 y cuenta con conexión a una base de datos MySQL.

El microservicio proporciona diferentes operaciones CRUD para las entidades de Paquete, Cliente  Empleado, implementadas utilizando el patrón de diseño DAO para Repository y siguiendo los principios SOLID. Además, se han desarrollado querys personalizados de JPA para mejorar la eficiencia y la velocidad de acceso a la base de datos.

El proyecto también incorpora patrones de diseño como de  Chain of Responsibility, Dto, Dao, Template design.

El patrón Chain of Responsibility se utiliza para la validación de entradas, lo que permite pasar solicitudes a través de una cadena de manejadores, asegurando que las entradas sean válidas antes de que se realice cualquier operación de almacenamiento en la base de datos.

En resumen, este microservicio de mensajería física de paquetes es una solución eficiente y escalable para la gestión de la mensajería física de paquetes, con operaciones CRUD, querys personalizados de JPA, patrones de diseño, principios SOLID.


Para acceder a la documentación de la API 💻, haz clic en  [enlace Swagger](https://microserviciomensajeriafisica-production.up.railway.app/swagger-ui/index.html#/)

<div style="display:flex">

<img src="https://user-images.githubusercontent.com/50783391/232255841-ca02df30-398c-4b98-b9eb-098f2adc092c.png" 
width="100">
<img src="https://user-images.githubusercontent.com/50783391/236566733-2c54ccfd-7a19-4be0-840e-c8d177ce1015.png"
width="100">




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
* Spring Security
* Inyección de dependencias
* Maven como gestor de dependencias
* Patrones DTO y Diseño DAO para Repository

### Patron de comportamiento Chain of Responsibility

Chain of Responsibility es un patrón de diseño de comportamiento que te permite pasar solicitudes a lo largo de una cadena de manejadores
validando sus de entradas.

##
## 🏛 Entidades :

- Customer
- Employeer
- Package
- SendPackage



##
## 🏛 Flujo del proceso :

![image](https://github.com/Jaime-U-Lopez/MicroServicioMensajeriaFisica/assets/50783391/bb4f7203-f368-4849-aed8-610e2620d269)




##
## 🌐 Diagrama de entidades :

![diagrama de clases](https://user-images.githubusercontent.com/50783391/233198946-f2bd91f6-eb1c-4634-ab08-8bd649f5ed55.png)

##
## 🌐 Diagrama de carpetas  :

![ProyectoIntegradorBack2 drawio (7)](https://user-images.githubusercontent.com/50783391/233716114-ae4d0bfe-d05a-49af-b9f8-6711bfc7d071.png)

##
## Peticiones HTTP

#### Para Package :


<table>
  <thead>
    <tr style="background-color:#FFA500;color:#FFFFFF;">
      <th>Entity</th>
      <th>EndPoint</th>
      <th>HTTP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
     <td>packages</td>
      <td>/mensajeria/v1/packages</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>packages</td>
      <td>/mensajeria/v1/packages/{id}</td>
      <td>GET</td>
    </tr>
    <tr>
         <td>packages</td>
      <td>/mensajeria/v1/packages</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>packages</td>
      <td>/mensajeria/v1/packages</td>
      <td>PUT</td>
    </tr>
    <tr>
           <td>packages</td>
      <td>/mensajeria/v1/packages/{id}</td>
      <td>DELETE</td>
    </tr>
  </tbody>
</table>

##### Solicitud Http Post en Package : 

	{
	  "id": 0,
	  "pesoPaquete": 0,
	  "typePackage": "GRANDE",
	  "valorPaquete": 0
	}



#### Para Customer :


<table>
  <thead style="background-color: red; color: white;">
    <tr>
      <th>Entity</th>
      <th>EndPoint</th>
      <th>HTTP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Customer</td>
      <td>/mensajeria/v1/customers</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>Customer</td>
      <td>/mensajeria/v1/customers/{id}</td>
      <td>GET</td>
    </tr>
    <tr>
      <td>Customer</td>
      <td>/mensajeria/v1/customers</td>
      <td>POST</td>
    </tr>
    <tr>
      <td>Customer</td>
      <td>/mensajeria/v1/customers</td>
      <td>PUT</td>
    </tr>
    <tr>
      <td>Customer</td>
      <td>/mensajeria/v1/customers/{id}</td>
      <td>DELETE</td>
    </tr>
  </tbody>
</table>



##### Solicitud Http Post en Custumer: 


	{
		"nombre": "Juan",
		"apellido": "Pérez",
		"email": "juan.perez@gmail.com",
		"telefono": "555-4321"
	}

#### Para Employee :

| Entity   | EndPoint                         | HTTP  |
| -------- | ------------------------------- | ----- |
| Employee | /mensajeria/v1/employees         | GET   |
| Employee | /mensajeria/v1/employees/{id}    | GET   |
| Employee | /mensajeria/v1/employees         | POST  |
| Employee | /mensajeria/v1/employees         | PUT   |
| Employee | /mensajeria/v1/employees/{id}    | DELETE|



#### Solicitud Http Post en un employee:


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

#### Para Servicio de Mensajeria :

| Entity   | EndPoint                         | HTTP  |
| -------- | ------------------------------- | ----- |
| SendPackage | /mensajeria/v1/SendPackage         | GET   |
| SendPackage | /mensajeria/v1/employees/{id}    | GET   |
| SendPackage | /mensajeria/v1/SendPackage         | POST  |
| SendPackage | /mensajeria/v1/SendPackage         | PUT   |
| SendPackage | /mensajeria/v1/SendPackage/{id}    | DELETE|


#####  Solicitud Http Post en para Enviar un paquete:


	{
	  "cedulaCliente": 3254330,
	  "celular": 3099989870,
	  "ciudadDestino": "Medellin",
	  "ciudadOrigen": "Bogota",
	  "direccionDestino": "los andes amedro",
	  "nombrePersonaRecibe": "san juaquin",
	  "pesoPaquete": 50,
	  "valorPaquete": 30000
	}
