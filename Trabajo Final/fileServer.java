import java.net.*;
import java.io.*;

public class fileServer {

    public static void main(String[] args) throws IOException {
        String operacion; String leido; boolean continuar = true;
        parametrosLectura pl; parametrosEscritura pe;
        retornoLectura lectura = new retornoLectura();

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);

        try (
    
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

        ) {
        while(continuar == true){
            operacion = (String)ois.readObject();
            System.out.println("Operacion: "+operacion);

            if(operacion.equals("Lectura")){
                pl = (parametrosLectura)ois.readObject();
                byte array[] = new byte[pl.getCantLeer()];
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(pl.getFilename()));
                in.skip(pl.getPos());
                lectura.setCantBytesLeidos(in.read(array, 0, pl.getCantLeer()));
                lectura.setRetBytes(array);    
                System.out.println("Cant bytes leidos: "+ lectura.getCantBytesLeidos());
                
                if(lectura.getCantBytesLeidos() == -1)
                    continuar = false;
                
                oos.writeObject(lectura);
                oos.reset();    

            }
            else if(operacion.equals("Escritura")){
                pe = (parametrosEscritura)ois.readObject();
                File ficheroDestino = new File(pe.getNombreEscritura());
                BufferedOutputStream escritorFichero = new BufferedOutputStream(new FileOutputStream(ficheroDestino, true));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
                int i = 0;
                byte[] aux = pe.getBuffer();
                while (i<pe.getCantAEscribir()){
                    escritorFichero.write(aux[i]);//se copia el flujo de byes al fichero destino.
                    i++;
                }
                System.out.println("Escritura actual finalizada");
                escritorFichero.close();//cerramos el escritor
            }
        }
        while(true){}
        } 
        catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
 
    }
}
