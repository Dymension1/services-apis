# =========================================================
# Etapa 1: Construcción (nombrada como "build")
# =========================================================
# Usamos una imagen oficial de Maven con JDK 17. Es más eficiente que instalarlo en Ubuntu.
FROM maven:3.8-openjdk-17 AS build

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos solo el pom.xml para aprovechar el caché de Docker
# Las dependencias solo se descargarán de nuevo si el pom.xml cambia
COPY pom.xml .
RUN mvn dependency:go-offline

# Ahora copiamos el resto del código fuente
COPY src ./src

# Ejecutamos el comando de Maven para compilar y empaquetar el .jar
# Usamos -DskipTests para no correr pruebas unitarias durante la construcción de la imagen
RUN mvn package -DskipTests

# =========================================================
# Etapa 2: Ejecución (la imagen final y ligera)
# =========================================================
# Partimos de una imagen ligera que solo contiene Java para ejecutar la app
FROM openjdk:17-jdk-slim

# Exponemos el puerto en el que corre la aplicación
EXPOSE 8080

# Copiamos el .jar que se generó en la etapa "build"
# El JAR estará en /app/target/ porque establecimos el WORKDIR en la etapa anterior
COPY --from=build /app/target/services-apis-0.0.1-SNAPSHOT.jar app.jar

# El comando para iniciar la aplicación cuando el contenedor se ejecute
ENTRYPOINT ["java", "-jar", "app.jar"]