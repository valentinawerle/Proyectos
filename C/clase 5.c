/*#include <stdio.h>


int sumados(int a, int b){

	int c= a+b;
	return c;
}
 
int main()
{
	int x=6;
	int y=7;
	


int z= sumados(x,y);

printf ("Suma: %d\n", z);

return 0;}*/

/*  NO FUNCIONA---------------------------------------------------------------------------

#include <stdio.h>

void sumados2 (int a, int b, int c)

{
	c=a+b;
	
}

int main ()

{ 
int x=6;
int y=7;
int z;

sumados2 (x,y,z)
printf("%d",z);

return 0;
}*/

/* VARIABLES DE TIPO PUNTERO--------------------------------------------------------------


#include <stdio.h>
int main()

{
	int a= 5;
	int*b= &a;
	
	printf("%d %d %d %d\n",a,*b,b,&a);
	
	return 0;
}*/

/*

#include <stdio.h>

void sumados (int a, int b, int *c)

{
	*c= a+b;
	
}



int main (){


int x= 5;
int y= 6;
int z;

sumados (x,y,&z);
printf("%d\n",z);

return 0;

}*/


//* CAMBIO DE VARIABLE----------------------------------------------------------------


#include <stdio.h>

void intercambio (int*a, int*b)

{
	int aux=*a;
	*a= *b;
	*b=aux;
	
}

int main()
{
	int x=5;
	int y=7;
	printf("%d %d\n", x, y);
	
intercambio (&x,&y);
printf("%d %d\n", x, y);

return 0;
}
  

