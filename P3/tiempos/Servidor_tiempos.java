import java.io.*;

public class Servidor_tiempos
extends java.rmi.server.UnicastRemoteObject 
implements Interfaz_tiempos
{
  int cantidad_entradas = 0;
  public Servidor_tiempos() throws java.rmi.RemoteException
  {
      // nada
  }

  public int prueba_tiempos() throws java.rmi.RemoteException
  {
	  
    int tiempo = 31000; boolean seguir = true;
    try{
       //if(tiempo > 10000){
        //   Thread.sleep(tiempo);
       //}else{
         //  Thread.sleep(tiempo);
       //}
       
       //Thread.sleep(tiempo);
       
       if(cantidad_entradas == 1){
         return 1;
       }else{
        cantidad_entradas++;
        Thread.sleep(tiempo);
        
       }
       
  }
 catch(InterruptedException e){
       System.out.println("No Transcurrieron = 310 seg.");
 }
 System.out.println("Transcurrieron = 310 seg.");
   return 2;

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
