/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "ej4.h"


void
filesystem_prg_1(char *host, char * nombreArchivo)
{
	CLIENT *clnt;
	struct retornoValores  *result_1; //Lectura
	struct lecturaParametros  lectura_1_arg;
	int  *result_2; // Escritura
	struct escrituraParametros  escritura_1_arg;
	FILE *archivo_local;

	archivo_local=fopen("archivo_local","wb");

#ifndef	DEBUG
	clnt = clnt_create (host, filesystem_prg, filesystem_ver, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	lectura_1_arg.filename = nombreArchivo;
	lectura_1_arg.cant = 240;
	lectura_1_arg.pos = 0;
	result_1 = lectura_1(&lectura_1_arg, clnt);
	while((result_1->bytes_leidos) != 0){

			//int indice = 0;
			//while((result_1->bytes_leidos)!= indice){
			fwrite(result_1->ret_bytes,sizeof(unsigned char),result_1->bytes_leidos,archivo_local);
			lectura_1_arg.pos = lectura_1_arg.pos + 240 ;
			result_1 = lectura_1(&lectura_1_arg, clnt);
	}

	if (result_1 == (struct retornoValores *) NULL) {
		clnt_perror (clnt, "call failed");
	}

	escritura_1_arg.e =nombreArchivo;
	escritura_1_arg.buffer = "Este sager que se asoma";
	escritura_1_arg.cant = 20;

	result_2 = escritura_1(&escritura_1_arg, clnt);

	if (result_2 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	filesystem_prg_1 (host,argv[2]);
exit (0);
}
