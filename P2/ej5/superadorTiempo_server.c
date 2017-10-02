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

double tiempoExtra = 0;

double *
tiempo_1_svc(variablesTiempo *argp, struct svc_req *rqstp)
{
	//inicio de variables
	double var;
	static double result;
	clock_t t_ini_servidor;
	t_ini_servidor = clock();
	
	//armado de tiempo extra para la siguiente vez que se use elñ servidor
	tiempoExtra = argp->tiempo + tiempoExtra;
	printf("El tiempo de espera en servidor: %f\n",tiempoExtra);
	sleep(tiempoExtra); // funcion que me permite tardar un poco mas en segundos.

	//transformacion del t_ini_servidor
	var =  ((double)t_ini_servidor)/1000000;
	printf("t_ini_servidor: %f \n", var);

	//preparando el resultado
	result = tiempoExtra - var;
	printf("El resultado del servidor en segundos: %f \n",result);
	printf("-----------------------------------\n");

	return &result;
}
