
import java.net.*;
import java.io.*;

public class MultiServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean entrada = true;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("no existe el puerto 4444.");
            System.exit(-1);
        }

        while (entrada)
          new MultiServerThread(serverSocket.accept()).start();

        serverSocket.close();
    }
}
