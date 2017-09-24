
import java.net.*;
import java.io.*;

public class MultiServerThread extends Thread {
    private Socket socket = null;

    public MultiServerThread(Socket socket) {
      super("MultiServerThread");
      this.socket = socket;
    }

    public void run() {
      try {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));

        String inputLine, outputLine;
        Protocolo pepeP = new Protocolo();

        outputLine = pepeP.procesoInput(null);
        out.println(outputLine);

        while ((inputLine = in.readLine()) != null) {
          outputLine = pepeP.procesoInput(inputLine);
          out.println(outputLine);
          if (outputLine.equals("chau"))
            break;
        }
        out.close();
        in.close();
        socket.close();

     } catch (IOException e) {
        e.printStackTrace();
     }
   }
}
