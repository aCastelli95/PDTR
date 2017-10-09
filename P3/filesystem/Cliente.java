
public class Cliente
{
  public static void main(String[] args)
  {
    try
    {
      Interfaz mir = (Interfaz)java.rmi.Naming.lookup("//" + 
                              args[0] + ":" + args[1] + "/PruebaRMI");
      for (int i=1;i<=mir.escritura("a","asdasd",1);i++) mir.lectura("<",1,1);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
}
