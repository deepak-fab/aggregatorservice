FROM java:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/aggregator-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} aggregator-0.0.1-SNAPSHOT.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/aggregator-0.0.1-SNAPSHOT.jar"]

EXPOSE 8003

