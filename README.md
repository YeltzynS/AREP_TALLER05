# **Create a CRUD System to Manage Propertiess**

## **Resumen del Proyecto**

 **frontend** desarrollado en HTML, CSS y JavaScript.
   **backend** construido con **Spring Boot** y MySQL para la persistencia de datos.
  **base de datos** alojada en AWS EC2 utilizando MySQL.


# Proyecto 
El Property Management System es una aplicación web que permite gestionar propiedades mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar). Los usuarios pueden registrar propiedades con detalles como dirección, precio, tamaño, descripción y teléfono.

## Objetivo:
Crear nuevos listados de propiedades.
Leer o ver una lista de todas las propiedades y detalles de propiedades individuales.
Actualizar detalles de propiedades existentes.
Eliminar listados de propiedades.
Requisitos:
Interfaz de usuario (HTML + JavaScript):

Crear una interfaz de usuario simple con formularios para capturar información de propiedades (por ejemplo, dirección, precio, tamaño, descripción).
Mostrar una lista de todas las propiedades con opciones para ver, actualizar y eliminar cada una.
Implementar la validación del lado del cliente (por ejemplo, campos obligatorios, tipos de datos válidos).
Usar AJAX o Fetch API para comunicarse con los servicios REST del backend.
Backend (API REST de Spring Boot):

Desarrollar puntos finales RESTful para cada operación CRUD:
POST para crear una nueva propiedad.
GET para recuperar todas las propiedades o una sola propiedad por ID.
PUT para actualizar una propiedad existente.
DELETE para eliminar una propiedad por ID.
Manejar errores como entradas no válidas o solicitudes de propiedades inexistentes.
Asegúrese de que cada propiedad tenga los siguientes atributos:
ID de la propiedad (generada automáticamente)
Dirección
Precio
Tamaño
Descripción
Base de datos (MySQL):

Cree una tabla de propiedades con columnas para ID, dirección, precio, tamaño y descripción.
Use JPA/Hibernate para asignar los objetos de propiedad a la base de datos.
Implemente la persistencia de datos para todas las operaciones CRUD.
4. Los servicios de backend y la base de datos deben implementarse en servidores separados en AWS.



 

## Arquitectura
```Bash
AREP-TALLER05/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/edu/eci/arep/arep_taller05/Contoller
│   │   │   │   ├── PropertyController.java
│   │   │   ├── com/edu/eci/arep/arep_taller05/Model
│   │   │   │   ├── Property.java
│   │   │   ├── com/edu/eci/arep/arep_taller05/Repository
│   │   │   │   ├── PropertyRepository.java
│   │   │   ├── com/edu/eci/arep/arep_taller05/Service
│   │   │   │   ├── PropertyService.java
│   │   │   ├── ApplicationProperty.java
│   ├── resources/
│   │   ├── img
│   │   ├── static
│   │   │   │── style.css
│   │   │   │── script.js
│   │   │   ├── index.html
│   │   ├── application.properties
│── pom.xml
│── README.md
│── Dockerfile
│── docker-compose.yml
```

La arquitectura del sistema sigue un modelo en tres capas:

- **Frontend:** Aplicación web estática (HTML, CSS, JavaScript) alojada en el servidor y comunicándose con el backend mediante llamadas REST.
- **Backend:** API REST desarrollada en Java con Spring Boot, que expone servicios para la gestión de propiedades.
- **Base de Datos:** MySQL, con JPA/Hibernate para la persistencia de datos.

### Flujo de interacción:
1. El frontend envía solicitudes HTTP al backend.
2. El backend procesa las solicitudes y consulta la base de datos.
3. La respuesta se devuelve al frontend para ser mostrada en la UI.

## Class Design

### **1. Modelo de Datos**
- `Property`: Entidad que representa una propiedad con los atributos:
  - `id`
  - `address`
  - `price`
  - `size`
  - `description`
  - `phone`

### **2. Capa de Persistencia**
- `PropertyRepository`: Interfaz que extiende `JpaRepository`, permitiendo operaciones CRUD sobre la base de datos.

### **3. Capa de Servicio**
- `PropertyService`: Contiene la lógica de negocio y métodos para manejar propiedades.

### **4. Capa de Controlador**
- `PropertyController`: Expone los endpoints REST para interactuar con las propiedades.

## **Instalación** 

1. Descarga el repositorio remoto a tu local
    
    ```
    git clone https://github.com/YeltzynS/AREP_TALLER05.git
    
    ```
    
2. Entra en el directorio.
    
    ```
    cd AREP_TALLER05
    ```
    
3. Compila el proyecto:
    
    `mvn clean install`
   


### **Conexión mysql**

1. Crear la instancia con mysql.
2. Conectarse por SSH:
    
    ``` bash
    ssh -i "myfirstkey.pem" ec2-user@<instance-ip>
    ```
    
3. Instala docker y corre mysql:
    
    ``` bash
    sudo yum update -y
    sudo yum install docker -y
    sudo usermod -a -G docker ec2-user
    docker run --name contenedor_mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=properties_db -p 3306:3306 -d mysql:latest
    ```
  

4. Ver que se creo la tabla:

   ![image](https://github.com/user-attachments/assets/9e7493a9-b3e7-48b8-9fa6-580e7550382)



### **Backend**

1. Crear el dockerfile
Usar una imagen base de Java 17
FROM openjdk:17-jdk-alpine
WORKDIR /app
EXPOSE 35000
Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

2. Par los paquetes de la aplicación
   
    ``` bash
    mvn clean package
    ```

3. Construimos la imagen:

    ``` bash
    docker build -t app .
    ```
4. Agregamos el tag de docker y cargamos el repositorio de dockerhub
   
    ``` bash
    docker tag app yeltzyns/app
    ```

    ``` bash
    docker push <your-dockerhub-username>/property-app
    ```
    
#### AWS:
1.Lanzamos la instancia para el backend.
2. Nos conectamos por SSh:
    
    ``` bash
    ssh -i "myfrist.key.pem" ec2-user@<instance-ip>
    ```
    
3. Intslamos docker y traemos la imagen del repositorio:
    
    ``` bash
    sudo yum update -y
    sudo yum install docker -y
    sudo service docker start
    docker pull yeltzyns/app
    ```
    
  4. Corremos el backen:
    
    ``` bash
    docker run -d -p 35000:35000 --name app yeltzyns/app
    ```



      
## SCREENSHOOTS: 📷
#### Final work:
- GET
![image](https://github.com/user-attachments/assets/7c4ab991-37a9-4bd1-96be-996ffcf2fd6)

- POST
![image](https://github.com/user-attachments/assets/5f1f8f02-0e36-4c42-9469-a1ec36131f5)

- PUT
![image](https://github.com/user-attachments/assets/24a1e030-74e9-4cdb-b034-f49c5319b43)

- DELETE
![image](https://github.com/user-attachments/assets/c0b16c17-1f12-478e-99f6-ad9b04b0b8d)
![image](https://github.com/user-attachments/assets/b56beeba-3225-48c9-ae58-e5cc7c208b2)



---
## Running the tests 

To run the automated tests:

```
mvn test
```
![image](https://github.com/user-attachments/assets/0ca2ad17-b12e-42a4-968c-c3a6d9ea939)

These tests verify the server's correct response to different requests.

![image](https://github.com/user-attachments/assets/403a3d45-de56-4888-b873-7eb68cee151)


## Built With

- [Java SE](https://www.oracle.com/java/) - Programming language
- [Maven](https://maven.apache.org/) - Dependency management and build tool


## Authors

-- Yeltzyn Sierra








