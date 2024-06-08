FROM openjdk:17
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/jobs-and-reviews-portal.jar
ENTRYPOINT ["java", "-jar", "jobs-and-reviews-portal.jar"]