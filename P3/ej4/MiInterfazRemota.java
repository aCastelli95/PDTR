
public interface MiInterfazRemota extends java.rmi.Remote
{
    //metodos
    public int lectura(String nombreA, int pos, int cant) throws java.rmi.RemoteException;
    public int escritura(String nombreAescritura, String buffer, int cant) throws java.rmi.RemoteException;
}

