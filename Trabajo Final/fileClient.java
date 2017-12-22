import java.io.*;
import java.net.*;

public class fileClient {
  
    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number> <filename>");
            System.exit(1);
        }
        
        parametrosLectura pl = new parametrosLectura();
        parametrosEscritura pe = new parametrosEscritura();
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        pl.setFilename(args[2]);    //Guardo en los parametros de lectura el archivo a abrir

        int number = 1;
        String nombreLocal = "Copia local_" + number+(pl.getFilename().substring(pl.getFilename().lastIndexOf(".")));
        String nombreRemoto = "Copia remota_" + number+(pl.getFilename().substring(pl.getFilename().lastIndexOf(".")));
        File ficheroDestinoCliente = new File(nombreLocal); 

        while (ficheroDestinoCliente.exists() == true){ //Chequea que no exista un archivo con el mismo nombre. Si existe, incrementa el numero hasta que no haya uno igual. 
            number++;
            nombreLocal = "Copia local_" + number + (pl.getFilename().substring(pl.getFilename().lastIndexOf(".")));
            nombreRemoto = "Copia remota_" + number + (pl.getFilename().substring(pl.getFilename().lastIndexOf(".")));
            ficheroDestinoCliente = new File(nombreLocal);
        }

        retornoLectura rl = new retornoLectura();
        pe.setNombreEscritura(nombreRemoto);

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            ObjectOutputStream oos = new ObjectOutputStream(echoSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(echoSocket.getInputStream());

        ) {
            BufferedOutputStream escritorFicheroCliente=new BufferedOutputStream(new FileOutputStream(ficheroDestinoCliente));
            oos.writeObject("Lectura");
            oos.reset();

            pl.setCantALeer(255);
            pl.setPos(0);
            oos.writeObject(pl);    //Manda los parametros de lectura  
            oos.reset();
            
            rl = (retornoLectura)ois.readObject();
            
            while(rl.getCantBytesLeidos() != -1){
                
                System.out.println("Realizando escritura...");
                
                oos.writeObject("Escritura");
                oos.reset();

                pe.setBuffer(rl.getRetBytes());
                pe.setCantAEscribir(rl.getCantBytesLeidos());
                oos.writeObject(pe);
                oos.reset();
                
                int cantEscrito=(Integer)ois.readObject();
                System.out.println("Cantidad de bytes escritos en el archivo remoto: " + cantEscrito);

                escritorFicheroCliente.write(rl.getRetBytes(),0,rl.getCantBytesLeidos());//se copia el flujo de byes al fichero destino.

                oos.writeObject("Lectura");
                oos.reset();

                pl.setPos(pl.getPos() + 255);
                oos.writeObject(pl);
                oos.reset();
                
                rl = (retornoLectura)ois.readObject();
                
            }
            escritorFicheroCliente.close();
            //echoSocket.close();

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            e.printStackTrace();
            System.exit(1);
        } 
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
