package router;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Router extends Thread {
    private Socket socket;

    public Router(Socket socket) {
        // System.out.println("Router");
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("MADE A CONNECTION --|-- MADE A CONNECTION");
        try {
            OutputStream o = socket.getOutputStream();
            String message = "HTTP/1.1 200 OK";
            System.out.println(message);
            for (int i = 0; i < message.length(); i++) {
                o.write((byte) message.charAt(i));
            }
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}