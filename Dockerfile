# openjdk 8
FROM java:8
# image maintainer
LABEL maintainer="f.leeap1004@gmail.comSS"

# data directory
# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
#EXPOSE 8080

# The application's jar file
ARG JAR_FILE=Spring/build/libs/springboot-webatoz-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} springboot-webatoz.jar

# Run the jar file
ENTRYPOINT ["java", "-Ddbkey=${DBKEY}","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-webatoz.jar"]