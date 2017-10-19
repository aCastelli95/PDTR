import java.rmi.*;
import java.rmi.registry.*;

public class Server {
  public static void main(String[] args){
    try
    {
      Servidor mir = new Servidor();
      String rname = "//localhost:" + Registry.REGISTRY_PORT + "/remote";
			Naming.rebind(rname, mir);
    }
    catch (Exception e)
    {
      System.out.println("Error!");
      e.printStackTrace();
    }
  }
}
