import java.io.*;
import java.net.*;

public class EchoClient {

  public static void main(String[] args) throws IOException {
    Socket pepeSocket = null; // ERA kkSocket
    PrintWriter out = null;
    BufferedReader in = null;

    try {
      pepeSocket = new Socket("localhost", 4444);
      out = new PrintWriter(pepeSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(pepeSocket.getInputStream()));

    } catch (UnknownHostException e) {

      System.err.println("No se a conectado al host");
      System.exit(1);

    } catch (IOException e) {
      System.err.println("No existe la conexion de I/O");
      System.exit(1);
    }

    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    String fromServer;
    String fromUser;

    while ((fromServer = in.readLine()) != null) {
      System.out.println("Server: " + fromServer);
      if (fromServer.equals("chau")) break;
          fromUser = stdIn.readLine();
      if (fromUser != null) {
        System.out.println("Client: " + fromUser);
        out.println(fromUser);
      }
    }

    // cerramos todas las conexiones con el servidor planteado.
    out.close();
    in.close();
    stdIn.close();
    pepeSocket.close(); // recorar siempre cerrar el socket ultimo, buena practica de programacion.
  }

}
