FROM openjdk:11
COPY ./app .
RUN javac *.java
EXPOSE 8999
<<<<<<< HEAD
CMD ["java", "Server"]
=======
CMD ["java", "Server"]
>>>>>>> 30de73aa3f38acd507d175642b84332b7448ae6f
