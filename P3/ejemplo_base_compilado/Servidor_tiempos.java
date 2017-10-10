import java.io.*;

public class Servidor_tiempos
extends java.rmi.server.UnicastRemoteObject 
implements Interfaz_tiempos
{
  
  public Servidor_tiempos() throws java.rmi.RemoteException
  {
      // nada
  }

  public int prueba_tiempos() throws java.rmi.RemoteException
  {

    return 1;

  }


    public static void main(String[] args)
  {
    try
    {
      Interfaz_tiempos mir = new Servidor_tiempos();
      java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress() +
                              ":" + args[0] + "/PruebaRMI", mir);
    }
    catch (Exception e)
    {
    }
  }
  
}