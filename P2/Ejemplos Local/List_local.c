#include <stdio.h>
#include <stdlib.h>

typedef struct foo {
  int x;
  struct foo *next;
} foo_t;

void printnums( foo_t *f) {
  
  while (f) {
    printf("%d ",f->x);
    f=f->next;
  }
  printf("\n");
}

void print_sum( foo_t *head) {
  int result=0;
  while (head) {
    result += head->x;
    head = head->next;
  }
  printf("Sum is %d\n",result); 
}

int main( int argc, char *argv[]) {

  int n,i;
  foo_t *f;
  foo_t *head;
  foo_t *prev;

  if (argc<3) {
    fprintf(stderr,"Usage: %s num1 num2 ...\n",argv[0]);
    exit(0);
  }

  n = argc-1;
  f = head = (foo_t *) malloc(sizeof(foo_t));
  for (i=0;i<n;i++) {
    f->x = atoi(argv[i+1]);
    f->next = (foo_t *) malloc(sizeof(foo_t));
    prev=f;
    f = f->next;
  }

  free(prev->next);
  prev->next=NULL;

  printnums(head);
  print_sum(head);
  return(0);
}









