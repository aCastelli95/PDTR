
public class MiClaseRemota 
extends java.rmi.server.UnicastRemoteObject 
implements MiInterfazRemoto
{
  public MiClaseRemota() throws java.rmi.RemoteException
  {
    // Codigo del constructor
  }

  public void miMetodo1() throws java.rmi.RemoteException
  {
    // Aqui ponemos el codigo que queramos
    System.out.println("Estoy en miMetodo1()");
  }

  public int miMetodo2() throws java.rmi.RemoteException
  {
    return 5; // Aqui ponemos el codigo que queramos
  }

  public void otroMetodo()
  {
    // Si defenimos otro metodo, este no podria llamarse
    // remotamente al no ser del interfaz remoto
  }

  public static void main(String[] args)
  {
    try
    {
      MiInterfazRemoto mir = new MiClaseRemota();
      java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress() +
                              ":" + args[0] + "/PruebaRMI", mir);
    }
    catch (Exception e)
    {
    }
  }
}

