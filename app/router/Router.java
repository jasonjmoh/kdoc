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
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}