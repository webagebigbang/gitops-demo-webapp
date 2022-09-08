FROM adoptopenjdk/openjdk11
COPY ./target/gitops-demo-webapp.jar gitops-demo-webapp.jar
ENTRYPOINT ["java","-jar","gitops-demo-webapp.jar"]