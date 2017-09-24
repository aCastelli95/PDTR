/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "servidorCF.h"


void
servidorcf_prog_1(char *host, String cadenaChar)
{
	CLIENT *clnt;
	int  *result_1;
	variablesCompartidas  lectura_1_arg;
	int  *result_2;
	variablesCompartidas  ecritura_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, SERVIDORCF_PROG, SIMP_VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	
	result_1 = lectura_1(&lectura_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
	result_2 = ecritura_1(&ecritura_1_arg, clnt);
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
	servidorcf_prog_1 (host,argv[2]);
exit (0);
}
