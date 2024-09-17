/* CONTADOR--------------------------------------------------------------------------


#include <stdio.h>
int main(){
	int a=1;
	int acum= 0;
	for (;a<=10;a++)
	{
		printf("%d\n",a);
		acum= acum+a;
	}
	
	printf("la suma es: %d\n",acum);
	
	return 0;
	} */
	
	
/* CAMBIAR NOMBRE DE VALORES----------------------------------------------------------

#include <stdio.h>

	#define begin {
	#define end }
	
int main(){
	
	int a=3;
	if(a==3)
	
	begin
	printf ("es igual");
	end
	
	return 0;
}*/

/*#include <stdio.h>--------------------------------------------
int main(){
	int a;
	
	do{
		
		printf ("ingrese valor");
		scanf ("%d",&a);
	}
	
	while (a<10|| a>20);
	
	return 0;
	}*/
	
	
/* FUNCIONES 
	
#include <stdio.h>

int sumados(int a, int b)
{
	int c= a+b;
	return c;
	
	}	
	
	int main()
	
{
	int x= 5;
	int y= 8;
	
	int result= sumados (x,y);
	printf ("la suma es: %d\n", result);
	
	return 0;
}*/




	

	

