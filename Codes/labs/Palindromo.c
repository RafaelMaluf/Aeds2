#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
int main() {
    setlocale(LC_ALL, "");
    char palavra[1000]; 
    scanf("%s",&palavra);
    

   while (strcmp(palavra,"FIM")!=0){
    int tamanho = strlen(palavra); 
    char *palindromo = (char *)malloc((tamanho + 1) * sizeof(char));

 
    for (int i = 0; i < tamanho; i++) {
        palindromo[i] = palavra[tamanho - i - 1];
    }

    palindromo[tamanho] = '\0'; 
    
    if(strcmp(palindromo,palavra)==0){
        printf("SIM\n");
    }
    else{
        printf("NAO\n");
    }
 
    free(palindromo);
    scanf("%s",&palavra);
   }
    return 0;
}