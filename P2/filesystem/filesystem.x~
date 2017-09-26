#define VERSION_NUMBER 1

/* If I want to put something explicitly in the .h file produced by rpcgen
   I can start it with %:
*/

#define foo 127
/*
Contiene la estructura de lo que se envia en el momento
de conexion
*/
struct variablesCompartidas{

  string nombreA<255>;
  int posicionA;
  int cantLeerA;
  string bufferEscritura<255>;
};

program SERVIDORCF_PROG {
  version SIMP_VERSION {
    int LECTURA(variablesCompartidas) = 1;
    int ESCRITURA(variablesCompartidas) = 2;
  } = VERSION_NUMBER;

} = 0x20000001;
