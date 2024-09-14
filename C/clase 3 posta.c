/* DIRECCION DE MEMORIA------------------------------------------------------------------------------

#include <stdio.h>

int main(){
	int a=5;
	printf("%ld",&a);
	
	return 0;
}
 
 para varias direcciones
 
 
#include <stdio.h>

int main()

{
int a=5,b;


	printf("%ld %ld",&a, &b);
	
	return 0;}*/
	
/* FUNCION SCANF -------------------------------------------------------------------------------------------

#include <stdio.h>

int main(){

int a;

printf("ingresar un numero\n");
scanf("%i", &a);

printf("%i",a);

return 0;*/

#include <stdio.h>

int main(){
	
	int a; 
	
	printf ("ingrese un valor: ");
	scanf("%d", &a);

	
	while (a<10||a>20){
		
	printf ("ingrese un valor: ");
	scanf("%d", &a);

	}
	
return 0;


	
}
