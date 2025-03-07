# **Create a CRUD System to Manage Propertiess**


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

## **Resumen del Proyecto**

 **frontend** desarrollado en HTML, CSS y JavaScript.
   **backend** construido con **Spring Boot** y MySQL para la persistencia de datos.
  **base de datos** alojada en AWS EC2 utilizando MySQL.







