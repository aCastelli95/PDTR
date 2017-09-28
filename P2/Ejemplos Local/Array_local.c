#include <stdio.h>
#include <stdlib.h>

int vadd(int *x, int n) {
  
  int i, result=0;

  printf("Got request: adding %d numbers\n", n);  
  for (i=0;i<n;i++)
	  result += x[i];
  return(result);
}


int main( int argc, char *argv[]) {
  int *ints,n;
  int i;
  int res;
  if (argc<3) {
    fprintf(stderr,"Usage: %s num1 num2 ...\n",argv[0]);
    exit(0);
  }


  /* get the 2 numbers that should be added */
  n = argc-1;
  ints = (int *) malloc(n * sizeof( int ));
  if (ints==NULL) {
    fprintf(stderr,"Error allocating memory\n");
    exit(0);
  }
  for (i=1;i<argc;i++) {
    ints[i-1] = atoi(argv[i]);
  }
  res = vadd(ints,n);
  printf("%d",ints[0]);
  for (i=1;i<n;i++) 
    printf(" + %d",ints[i]);
  printf(" = %d\n",res);
  return(0);
}





