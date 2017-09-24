#define VERSION_NUMBER 1

/* If I want to put something explicitly in the .h file produced by rpcgen
   I can start it with %:
*/

#define foo 127
const MAX_STRUCT=255; 
/*
Contiene la estructura de lo que se envia en el momento
de conexion
*/
struct variablesCompartidas{
  string nombreA<MAX_STRUCT>;
  int posicionA;
  int cantLeerA;
  string bufferEcritura<MAX_STRUCT>;
};

program SERVIDORCF_PROG {
  version SIMP_VERSION {
    int LECTURA(variablesCompartidas) = 1;
    int ECRITURA(variablesCompartidas) = 2;

  } = VERSION_NUMBER;

} = 555555555;
