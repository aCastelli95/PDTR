# PDTR
Programación Distribuida y de Tiempo Real- UNLP

# Práctica 3 
  Comandos utiles con un ejemplo en la carpeta de P3 en la cual se tiene una interfaz vacía, al igual que el cliente y
  el servidor, con la comunicación RMI.
   
                   
                    javac *.java
                    jar cvf objRemotos.jar <nombreInterfaz>.class

Luego compilamos de forma total con:
                   
                   set CLASSPATH=%CLASSPATH%;.\objRemotos.jar;.
                   rmic -d . <NombreServidor>
                   Observamos en nuestro directorio de trabajo que se han generado automáticamente dos ficheros .class (MiClaseRemota_Skel.class y MiClaseRemota_Stub.class) correspondientes a la capa stub-skeleton de la arquitectura RMI
                   rmiregstry 1234 & // Considerar que se tiene al puerto 1234 programado, otro daria errores de ejecución.
                    
Finalmente ejecutamos cliente/servidor en terminales diferentes

                    java -Djava.rmi.server.hostname=127.0.0.1 <nombreServidor> 1234 // ejecución del servidor
                    java MiClienteRMI 127.0.0.1 1234 // ejecucion del cliente
   
                  
