# Usar una imagen base de Java 17
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app


# Exponer el puerto en el que corre la aplicación
EXPOSE 35000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]