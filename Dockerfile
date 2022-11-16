FROM openjdk:11
COPY ./app .
RUN javac *.java
EXPOSE 8999
CMD ["java", "Server"]