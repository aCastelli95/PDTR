const MAX_STRUCT=255;
const MAX_FILE=100;

struct retornoValores{
	unsigned char ret_bytes[MAX_STRUCT];			/* Los bytes leidos */
	int cant_bytes;										/* La cantidad que se pidio leer */  /***PREGUNTAR****/
	int bytes_leidos;									/* La cantidad que se pudo enviar */
};

struct lecturaParametros {
	string filename<MAX_FILE>;
	int pos;
	int cant;
};

struct escrituraParametros {
	string e<MAX_FILE>;
	string buffer<MAX_STRUCT>;
	int cant;

};

program filesystem_prg{
		version filesystem_ver{

		struct retornoValores LECTURA(struct lecturaParametros rp)=1;
		int ESCRITURA(struct escrituraParametros wp)=2;

	}=1;
}=0x30000001;
