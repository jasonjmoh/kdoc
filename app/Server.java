import java.net.*;
import java.io.*;

import router.Router;

public class Server {
    private static final int PORT = 8999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(-1);
        }
        while (true) {
            System.out.println("Waiting for connection on " + PORT + ".....");
            new Router(serverSocket.accept()).start();
        }
    }
}