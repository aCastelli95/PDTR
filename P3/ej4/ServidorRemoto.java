
public class ServidorRemoto
extends java.rmi.server.UnicastRemoteObject  
implements MiInterfazRemota
{
//variables cada vez que se ejecuta el servidor
private int cant_bytes;
private int bytes_leidos;

public int lectura(String nombreA, int pos, int cant) throws java.rmi.RemoteException
{

    //Ejecucion de la lectura de archivos en el servidor
    return 1;
}

public int escritura(String nombreAescritura, String buffer, int cant) throws java.rmi.RemoteException
{
    //Ejecucion de la escritura de archivos en el servidor
    return 1;
}

public static void main(String[] args)
{
    //Inicio del main
    try
    {
    
        MiInterfazRemota mir = new ServidorRemoto();
        java.rmi.Naming.rebind("//" + java.net.InetAddress.getLocalHost().getHostAddress() +
                          ":" + args[0] + "/PruebaRMI", mir);
    
    }
    catch (Exception e)
    {
     e.printStackTrace();  
    }
}

}