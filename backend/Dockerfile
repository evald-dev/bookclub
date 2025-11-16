# STAGE 1: Bauen der Anwendung mit Maven
# Wir verwenden ein offizielles Eclipse Temurin Image mit JDK 17
# Ändere "17" auf "21", falls du Java 21 verwendest.
FROM eclipse-temurin:21-jdk-jammy AS builder

# Setze das Arbeitsverzeichnis im Container
WORKDIR /app

# Kopiere zuerst den Maven Wrapper und die pom.xml
# Dies nutzt den Docker-Layer-Cache, um Abhängigkeiten nur bei Bedarf neu zu laden
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Mache den Maven Wrapper ausführbar (Dein "Permission denied" Problem)
RUN chmod +x ./mvnw

# Lade alle Abhängigkeiten herunter
RUN ./mvnw dependency:go-offline

# Kopiere den Rest des Quellcodes
COPY src ./src

# Baue die Anwendung. -DskipTests überspringt Tests für einen schnelleren Build.
RUN ./mvnw package -DskipTests


# ---
# STAGE 2: Erstellen des finalen, schlanken Images
# Wir verwenden das JRE (Java Runtime Environment), da wir das JDK nicht mehr brauchen
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Kopiere nur das gebaute .jar-File aus dem "builder" Stage
# Wir benennen es in "app.jar" um, damit wir einen festen Namen haben
COPY --from=builder /app/target/*.jar app.jar

# Informiert Docker, dass die App auf Port 8080 lauscht
# (Render wird dies sowieso über die $PORT Variable steuern)
EXPOSE 8080

# Der Befehl zum Starten deiner Anwendung
ENTRYPOINT ["java", "-jar", "app.jar"]