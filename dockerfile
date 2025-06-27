FROM openjdk:17
EXPOSE 8081
ADD target/Candidat2AL4-0.0.1-SNAPSHOT.jar candidat.jar
ENTRYPOINT ["java","-jar","candidat.jar"]