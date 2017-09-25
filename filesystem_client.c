
#include "filesystem.h"


void
servidorcf_prog_1(char *host, char *cadena, int val1, int val2,char *cadBuffer)
{
	CLIENT *clnt;
	int  *result_1;
	variablesCompartidas  lectura_1_arg;
	int  *result_2;
	variablesCompartidas  escritura_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, SERVIDORCF_PROG, SIMP_VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	//parametros de lectura dados por cliente en terminal.	
	lectura_1_arg.nombreA = cadena;
	lectura_1_arg.posicionA= val1;
	lectura_1_arg.cantLeerA=val2;
	lectura_1_arg.bufferEscritura = cadBuffer;

	result_1 = lectura_1(&lectura_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	
	escritura_1_arg.nombreA = cadena;
	escritura_1_arg.posicionA= val1;
	escritura_1_arg.cantLeerA=val2;
	escritura_1_arg.bufferEscritura = cadBuffer;

	result_2 = escritura_1(&escritura_1_arg, clnt);
	if (result_2 == (int *) NULL) {
		clnt_perror (clnt, "call failed del lado de la escritura");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 5) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	servidorcf_prog_1 (host,argv[2],atoi(argv[3]),atoi(argv[4]),argv[5]);
exit (0);
}
