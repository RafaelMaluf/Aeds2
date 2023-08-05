#include<stdio.h>
#include<string.h>
#include<locale.h>
#include <ctype.h>
int main() {
    setlocale(LC_ALL, "");
    char palavra [100]; 
    scanf("%99[^\n]", palavra);
    

   while (strcmp(palavra,"FIM")!=0){
    int tamanho = strlen(palavra); 
    char palindromo [100];

 
    for (int i = 0; i < tamanho; i++) {
         if((palavra[i] >= 'a' && palavra[i] <= 'z')||(palavra[i] >= 'A' && palavra[i] <= 'Z')||(palavra[i] >= '0' && palavra[i] <= '9')){
       palindromo[i] = palavra[tamanho - i - 1];
  } else {
       palavra[tamanho - i - 1] = 'l';
       palindromo[i] = 'l';
    }
    }

    palindromo[tamanho] = '\0'; 
    
    if(strcmp(palindromo,palavra)==0){
        printf("SIM\n");
    }
    else{
        printf("NAO\n");
    }
 
    scanf("%99[^\n]", palavra);
   
   }
    return 0;
}
