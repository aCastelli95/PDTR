import java.io.*;

public class Cliente_tiempos
{
  public static void main(String[] args)
  {
    // declarar variables
   
    try
    {
      Interfaz_tiempos mir = (Interfaz_tiempos)java.rmi.Naming.lookup("//" + 
                              args[0] + ":" + args[1] + "/PruebaRMI");
      
      // aca el codigo
    } catch (Exception e)
      {
        e.printStackTrace();
      }
 }
}