# Usa una imagen base oficial de OpenJDK
FROM openjdk:23-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /searchAJAX

# Copia el archivo JAR al contenedor
COPY target/searchAJAX-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escucha 
EXPOSE 8080

# Comando para ejecutar la aplicación Java
CMD ["java", "-jar", "app.jar"]




