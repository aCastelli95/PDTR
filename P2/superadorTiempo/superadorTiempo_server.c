/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "superadorTiempo.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

double *
tiempo_1_svc(variablesTiempo *argp, struct svc_req *rqstp)
{
	static double  result;
	printf("El tiempo de espera en servidor: %d\n",argp->tiempo);
	sleep(argp->tiempo);
	result=1;
	return &result;
}