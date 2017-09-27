#define VERSION_NUMBER 1

/* El superador de tiempo, cada vez que se llama , el tiempo se reduce seguro del lado del servidor para que se ejecute todo.
*/

#define foo 127
/*
Contiene la estructura de lo que se envia en el momento
de conexion
*/

program SERVIDORCF_PROG {
  version SIMP_VERSION {
    double TIEMPO() = 1;
  } = VERSION_NUMBER;

} = 0x30000001;
