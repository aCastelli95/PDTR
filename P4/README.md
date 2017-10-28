# Práctica 4
  Para ejecutar JADE-all-4.3.2, descomprimimos todas las carpetas y por una terminal, nos ubicamos en "jade". Desde ahí,
  comenzamos.

          java -cp lib/jade.jar jade.Boot –gui
          java -cp lib/jade.jar jade.Boot –gui -local-host 127.0.0.1

   Para compilar el agente:
          
          javac -classpath lib/jade.jar -d classes <Dirección_Completa>/AgenteMovil.java -> Ejemplo de compilacion por la catedra
          
   Para ejecutar un agente y abrir interfaz, colocamos:
            
          java -cp lib/jade.jar:classes jade.Boot -gui -agents nombre_del_agente:Clase_del_agente_
