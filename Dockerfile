
# testing
FROM maven:latest
COPY target/*.jar /app.jar
CMD ["java","-jar","/app.jar"]

