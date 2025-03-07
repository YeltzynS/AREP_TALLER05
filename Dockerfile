# Usa la imagen oficial de MySQL
FROM mysql:8

# Configurar variables de entorno
ENV MYSQL_ROOT_PASSWORD=root123
ENV MYSQL_DATABASE=properties_db
ENV MYSQL_USER=broot
ENV MYSQL_PASSWORD=root123

# Exponer el puerto 3306
EXPOSE 3306
