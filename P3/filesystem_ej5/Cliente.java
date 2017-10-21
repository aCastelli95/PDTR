import java.io.*;
import java.rmi.*;
import java.rmi.registry.Registry; /* REGISTRY_PORT */

public class Cliente {

  public static void main(String[] args){

    if (args.length != 2){
			System.out.println("2 arguments needed: (remote) hostname filename (sin comillas)");
			System.exit(1);
		}//inicio de archivos en clientes.
    File ficheroDestinoCliente = new File("Copia local");
    BufferedOutputStream escritorFicheroCliente;
    retornoLectura rl = new retornoLectura();
    String nombreArchivo = args[1];
    int pos = 0;
    //Creamos objeto de tipo fichero con la ruta destino.
    try
    {
      String rname = "//" + args[0] + ":" + Registry.REGISTRY_PORT + "/remote";
      Interfaz mir = (Interfaz)java.rmi.Naming.lookup(rname);
      escritorFicheroCliente=new BufferedOutputStream(new FileOutputStream(ficheroDestinoCliente));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
      int cantEsc=0, i=0;
      rl = mir.lectura(nombreArchivo, 255, pos);
      while (rl.getCantBytesLeidos() != -1){
        System.out.println("Realizando escritura...");
        cantEsc=mir.escritura("Copia Remota", rl.getRetBytes(), rl.getCantBytesLeidos());
        escritorFicheroCliente.write(rl.getRetBytes(),0,rl.getCantBytesLeidos());//se copia el flujo de byes al fichero destino.
        pos += 255;
        rl = mir.lectura(nombreArchivo, 255, pos);
      }
      escritorFicheroCliente.close();
    } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
    } catch (RemoteException re){
        re.printStackTrace();
    } catch (IOException ex) {
            System.out.println(ex.getMessage());
    } catch (Exception e){
        System.out.println("Error desconocido");
        e.printStackTrace();
    }
  }
}
