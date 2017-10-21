import java.io.*;


public class Cliente_tiempos
{
  public static void main(String[] args)
  {
    // declarar variables
    int total = 0;
    double inicio_tiempo, fin_tiempo;
    //inicio del tiempo, antes que de realiza la comunicacion con la interfaz.
    inicio_tiempo = System.currentTimeMillis()/1000.0;
    System.out.println("Inicio = "+ (inicio_tiempo));
    try
    {
       Interfaz_tiempos mir = (Interfaz_tiempos)java.rmi.Naming.lookup("//" + 
                              args[0] + ":" + args[1] + "/PruebaRMI");
       
    //System.out.println(mir.get_mensaje());	
    mir.prueba_tiempos(); // realiza una llamada al servidor.
    fin_tiempo = System.currentTimeMillis()/1000.0;
    //resultado = fin_tiempo - inicio_tiempo;
    System.out.println("Finalizacion = " + fin_tiempo);
    System.out.println("Tiempo final de ejecucion =" +(fin_tiempo - inicio_tiempo) );
    
    }
	catch (Exception e)
      {
    e.printStackTrace();
       }
 
 }
}
