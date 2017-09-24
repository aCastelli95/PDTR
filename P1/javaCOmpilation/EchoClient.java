/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.io.*;
import java.net.*;

public class EchoClient {
  
    public static void main(String[] args) throws IOException {
          boolean entro = true;
          int n=1000000; // variable que no se esta usando para el millon 
          // Variables de tiempo
          long tiempoTotal=0;
          long tiempoMsInicio = System.currentTimeMillis();      

        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            /*String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }*/

            // esto sirve para realizar la transferencia hasta 10 a la 5, tarda el ultimo pero lo hace.
            
            // TRASMITE TODO LOS BITS, OSEA EL 10 A LA 6 LO HACE RE CRACK AHORA.
            //Funciona de la siguiente manera, a los paquetes que se quieran mandar (cualquiera y de cualquier tamaño), lo que hacemos
            // es dividirlo en pequeñas porciones. pasados los 32000 aprox yya empieza andar mal
            //entonces, dejando el for del J en 1000, lo que se tiene que hacer para probar es variar el de I.

            // ACLARACION: Si se cambia el valor de J, va a tardar menos que si le variamos el I. hay q seguir jugando con esos valores.

            if (entro==true) {
                String userInput ="";
                // carga del string
               //for (int j = 0; j<1000 ;j++ ) {
                    
                    for (int i = 0; i<100000 ;i++ ) {
                        userInput = userInput + 'A';
                        }    
                        System.out.println(userInput.length());    
                        while (userInput != null) {             
                            out.println(userInput);
                            System.out.println("echo: " + in.readLine());
                            //System.out.println(userInput.length());
                            userInput = null;
                        }
                        userInput ="";
               //}

                System.out.println("Termino la unica transferencia");
                entro = false;
                
                // resultados de tiempos
                tiempoTotal = System.currentTimeMillis() - tiempoMsInicio;
                System.out.println("El tiempo en Ms es de:" + tiempoTotal);
            }

            


        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}
