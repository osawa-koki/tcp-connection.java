FROM openjdk:17
WORKDIR /src
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew build
ENTRYPOINT ["java", "-classpath", "./build/classes/java/main/", "org.example.Main"]
