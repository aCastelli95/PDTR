/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "servidorCF.h"

bool_t
xdr_variablesCompartidas (XDR *xdrs, variablesCompartidas *objp)
{
	register int32_t *buf;

	 if (!xdr_string (xdrs, &objp->nombreA, MAX_STRUCT))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->posicionA))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->cantLeerA))
		 return FALSE;
	 if (!xdr_string (xdrs, &objp->bufferEcritura, MAX_STRUCT))
		 return FALSE;
	return TRUE;
}
