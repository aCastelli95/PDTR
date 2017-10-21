import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote
{
  public retornoLectura lectura(String nombreA, int pos, int cant) throws java.rmi.RemoteException;
  public int escritura(String nombreEscritura, byte[] buffer, int cant) throws java.rmi.RemoteException;
}
