export let name: string = "Valentina"; 
export const age: number = 35;
export const isValid: boolean = true;

name = "Melisa";
//name = 123; ERROR

export const templateString = `esto es un string 
multilinea
que puede tener """
inyectar valores ${name}
expresiones ${1+1}
numeros ${age}
booleanos ${isValid}
`

console.log(templateString);