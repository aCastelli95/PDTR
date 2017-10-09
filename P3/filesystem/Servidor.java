import java.io.*;
public class Servidor
extends java.rmi.server.UnicastRemoteObject 
implements Interfaz
{
  
  public Servidor() throws java.rmi.RemoteException
  {

  }

  public int lectura(String nombreA, int pos, int cant) throws java.rmi.RemoteException

  {
    
    //Aqui ponemos el codigo que queramos
    System.out.println("Lectura de archivo Finalizada.");
    
    return 1;

  }

  public int escritura(String nombreAescritura, String buffer, int cant) throws java.rmi.RemoteException

  {     //Lectura apertura
        File ficheroOrigen=new File("prueba.pdf");//Creamos objeto de tipo fichero con la ruta origen.
        File ficheroDestino=new File("pruebaServidor.pdf");//Creamos objeto de tipo fichero con la ruta destino.
        BufferedInputStream lectorFichero;//Creo un objeto flujo buffer de lectura .
        BufferedOutputStream escritorFichero;//Creo un objeto flujo buffer de escritura.
        
        try
        {   
            lectorFichero=new BufferedInputStream(new FileInputStream(ficheroOrigen));//Inicializa el buffer de lectura con un objeto de tipo FileInputStream(Flujo de entrada a fichero).
            escritorFichero=new BufferedOutputStream(new FileOutputStream(ficheroDestino));//Inicializa el buffer de escritura con un objeto de tipo FileOutputStream( flujo de salida a fichero).
            int bytes;//variable ke ira conteniendo el byte a copiar en cada momento.
            while((bytes=lectorFichero.read())!=-1){ //mientras no llegue a fin de fichero...
                System.out.println((char)bytes);//se imprime el byte a copiar convertido a caracter por consola(no tiene sentido) 
                escritorFichero.write(bytes);//se copia el flujo de bytes al fichero destino.
            }
            System.out.println("Escritura de archivo finalizada");
            lectorFichero.close();//cerramos el lector
            escritorFichero.close();//cerramos el escritor
            
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    return 0;
  }

  public static void main(String[] args)
  {
    try
    {
      Interfaz mir = new Servidor();
      java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress() +
                              ":" + args[0] + "/PruebaRMI", mir);
    }
    catch (Exception e)
    {
    }
  }
}