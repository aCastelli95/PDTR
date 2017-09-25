/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _FILESYSTEM_H_RPCGEN
#define _FILESYSTEM_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct variablesCompartidas {
	char *nombreA;
	int posicionA;
	int cantLeerA;
	char *bufferEscritura;
};
typedef struct variablesCompartidas variablesCompartidas;

#define SERVIDORCF_PROG 0x20000001
#define SIMP_VERSION 1

#if defined(__STDC__) || defined(__cplusplus)
#define LECTURA 1
extern  int * lectura_1(variablesCompartidas *, CLIENT *);
extern  int * lectura_1_svc(variablesCompartidas *, struct svc_req *);
#define ESCRITURA 2
extern  int * escritura_1(variablesCompartidas *, CLIENT *);
extern  int * escritura_1_svc(variablesCompartidas *, struct svc_req *);
extern int servidorcf_prog_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define LECTURA 1
extern  int * lectura_1();
extern  int * lectura_1_svc();
#define ESCRITURA 2
extern  int * escritura_1();
extern  int * escritura_1_svc();
extern int servidorcf_prog_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_variablesCompartidas (XDR *, variablesCompartidas*);

#else /* K&R C */
extern bool_t xdr_variablesCompartidas ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_FILESYSTEM_H_RPCGEN */