import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Servidor extends UnicastRemoteObject implements Interfaz{

  protected Servidor() throws   RemoteException {
    super();
  }

public retornoLectura lectura(String nombreA, int cant, int pos) throws RemoteException  {

    retornoLectura lectura = new retornoLectura();
  	try {
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(nombreA));
      ByteArrayOutputStream bs = new ByteArrayOutputStream();
      BufferedOutputStream out = new BufferedOutputStream(bs);
      byte[] array = new byte[cant];
      in.skip(pos);
      lectura.setCantBytesLeidos(in.read(array, 0, cant));
      lectura.setRetBytes(array);
    }
  	catch (FileNotFoundException fe) {
  		System.out.println("El archivo a abrir no existe");
  	}
    catch (EOFException ee){
      System.out.println("End-of-file reached!");
    }
    catch (IndexOutOfBoundsException ioe){
      System.out.println("Indice fuera de rango");
      ioe.printStackTrace();
    }
    catch (IOException ie){
      System.out.println("Error de I/O");
    }
    catch (Exception e){
      System.out.println("Error desconocido");
    }
    return lectura;
  }


  public int escritura(String nombreEscritura, byte[] buffer, int cant) throws java.rmi.RemoteException{
        int i = 0, result = 0;
        File ficheroDestino = new File(nombreEscritura);//Creamos objeto de tipo fichero con la ruta destino.
        BufferedOutputStream escritorFichero;//Creo un objeto flujo buffer de escritura.
        try
        {
            escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino, true));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
            while (i<cant){
              escritorFichero.write(buffer[i]);//se copia el flujo de byes al fichero destino.
              result++;
              i++;
            }
            System.out.println("Escritura actual finalizada");
            escritorFichero.close();//cerramos el escritor
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

    return 0;
  }
}
