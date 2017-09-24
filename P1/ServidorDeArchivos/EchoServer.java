
import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null; // concepto sacado de documentacion

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("estoy después de crear el socket");

        } catch (IOException e) {

            System.err.println("No existe el puerto: 4444.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("estoy después de aceptar un cliente");

        } catch (IOException e) {

            System.err.println("Fallo de aceptación.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;
        Protocolo pepeP = new Protocolo();

        // prueba si se trasmite el vacio
        outputLine = pepeP.procesoInput(null);
        out.println(outputLine);

        // blucle que se queda esperando para trasmitir por pepeP
        while ((inputLine = in.readLine()) != null) {
             outputLine = pepeP.procesoInput(inputLine);
             out.println(outputLine);
             if (outputLine.equals("Bye."))
                break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
