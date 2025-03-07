# **Create a CRUD System to Manage Propertiess**

## **Resumen del Proyecto**

 **frontend** desarrollado en HTML, CSS y JavaScript.
   **backend** construido con **Spring Boot** y MySQL para la persistencia de datos.
  **base de datos** alojada en AWS EC2 utilizando MySQL.

  
  # Property Management System

# Project 
El Property Management System es una aplicación web que permite gestionar propiedades mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar). Los usuarios pueden registrar propiedades con detalles como dirección, precio, tamaño, descripción y teléfono.

## Objective:
Create new property listings.
Read or view a list of all properties and individual property details.
Update existing property details.
Delete property listings.
Requirements:
Frontend (HTML + JavaScript):

Create a simple user interface with forms to capture property information (e.g., address, price, size, description).
Display a list of all properties with options to view, update, and delete each one.
Implement client-side validation (e.g., required fields, valid data types).
Use AJAX or Fetch API to communicate with the backend REST services.
Backend (Spring Boot REST API):

Develop RESTful endpoints for each CRUD operation:
POST to create a new property.
GET to retrieve all properties or a single property by ID.
PUT to update an existing property.
DELETE to remove a property by ID.
Handle errors such as invalid inputs or requests for non-existent properties.
Ensure that each property has the following attributes:
Property ID (generated automatically)
Address
Price
Size
Description
Database (MySQL):

Create a properties table with columns for ID, address, price, size, and description.
Use JPA/Hibernate to map the property objects to the database.
Implement data persistence for all CRUD operations.
4. The backend services and the database should be deployed in separate servers in AWS.


 

## System Architecture
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

### **Diagrama de Clases (Simplificado)**








