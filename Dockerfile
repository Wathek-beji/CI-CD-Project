FROM openjdk:11
EXPOSE 8082
COPY target/ci-cd-project-1.0.jar ci-cd-project.jar
ENTRYPOINT ["java","-jar","/ci-cd-project.jar"]
