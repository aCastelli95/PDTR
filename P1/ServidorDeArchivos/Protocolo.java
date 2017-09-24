import java.net.*;
import java.io.*;

public class Protocolo{

  // VARIABLES DE ESTADO PARA EL PROTOCOLO QUE EJECUTEN SERVIDOR Y UN CLIENTE.
  private static final int ESPERA = 0;
  private static final int ENVIO = 1;
  private static final int ENVIOFINAL = 2;
  private static final int OTRO = 3;

  //private static final int NUMJOKES = 5;

  private int estadoActual = ESPERA;
  //private int indice = 0; // no se q es estadoActual

  private String[] respuestas = {"Rompe Pepe, Rompe", "Pepee, venite un minuto que la vereda tiene una cosita"
                                  ,"Peeeepeeeee, veni rompe, muchas gracias"};
/*EL protocolo es una charla ya prefabricada en la cual se tiene a pepe que hace preguntas
y el cliente va a responder*/

public String procesoInput (String theInput){
String theOutput = null;
 switch(estadoActual){
  case ESPERA:
  // COMUNICAMOS QUE ESTO CONECTADO Y PASO DE ESTADO PARA PODER TRASMITIR
    theOutput = "Bienvenido al sistema de archivos implementado en JAVA Para utilizarlo considere solo dos instrucciones:
                      1) ls -> me permite ver todos los nombres de archivos disponibles";

    estadoActual = ENVIO;
  break;

  case ENVIO:
      if (theInput.equalsIgnoreCase("rompes?")){ // funcion q sirve para verificar si lo que manda es la cadena esa
          theOutput = respuestas[0];
          estadoActual = ENVIOFINAL;
        } else {
         theOutput = "Sali por ENVIO " +
                     "Vamos de nuevo, Toc! Toc! Toc!";
                   }
  break;

  case ENVIOFINAL:
  if (theInput.equalsIgnoreCase("la vereda no tiene nada")){ // funcion q sirve para verificar si lo que manda es la cadena esa
      theOutput = respuestas[1];
      estadoActual = OTRO;
    } else {
     theOutput = "SALI POR ENVIOFINAL" +
                 "Vamos de nuevo, Toc! Toc! Toc!";
               }
  break;
  case OTRO:
  if (theInput.equalsIgnoreCase("muchas gracias")){ // funcion q sirve para verificar si lo que manda es la cadena esa
      theOutput = respuestas[2];
      estadoActual = ENVIO;
    } else {
     theOutput = "sali por OTRO" +
                 "Vamos de nuevo, Toc! Toc! Toc!";
               }
  break;
  default:
  break;
}// llave del switch

return theOutput;
}

}
