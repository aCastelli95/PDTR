import java.io.*;
public class Cliente
{
  public static void main(String[] args)
  {
    int byte_integer=0;
    char byte_char;
    int fin;

    //inicio de archivos en clientes.
    File ficheroDestinoCliente = new File("pruebaCliente.txt");
    BufferedOutputStream escritorFicheroCliente;
    
    try
    {
      Interfaz mir = (Interfaz)java.rmi.Naming.lookup("//" + 
                              args[0] + ":" + args[1] + "/PruebaRMI");
      //for (int i=1;i<=mir.escritura("a","asdasd",1);i++) mir.lectura("<",1,1);
      //Parte de estructura de archivos

      escritorFicheroCliente = new BufferedOutputStream(new FileOutputStream(ficheroDestinoCliente));
      int pos = 0;
      byte_integer = mir.lectura("asd",pos,1);
      byte_char = (char)byte_integer;
      while(byte_integer != -1){
          System.out.println(byte_char);
          escritorFicheroCliente.write(byte_integer);
          byte_integer = mir.lectura("asd",pos++,1);
          byte_char = (char)byte_integer;          
      }
      // EScritura
      fin = mir.escritura("a","asdasd",1);

    } catch (Exception e)
      {
        e.printStackTrace();
      }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
      }catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
  }
}
