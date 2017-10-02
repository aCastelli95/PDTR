#include <stdio.h>
#include <stdlib.h>

int add(int x, int y) {
  int result;

  result = x+y;
  return result;
}

int sub(int x, int y) {
  int result;


  result = x-y;
  return result;
}


int main( int argc, char *argv[]) {
  int x,y;
  if (argc!=3) {
    fprintf(stderr,"Usage: %s num1 num\n",argv[0]);
    exit(0);
  }

  /* get the 2 numbers that should be added */
  x = atoi(argv[1]);
  y = atoi(argv[2]);

  printf("%d + %d = %d\n",x,y, add(x,y));
  printf("%d - %d = %d\n",x,y, sub(x,y));
  return(0);
}


