#include <stdio.h>
#include <string.h>

char *intercalar(char *s, const char *a, const char *b) {
    int i = 0;
    int j = 0;
    
    while (*a && *b) {
        s[i++] = *a++;
        s[i++] = *b++;
    }
    
    
    while (*a) {
        s[i++] = *a++;
    }
    
    
    while (*b) {
        s[i++] = *b++;
    }
    
    s[i] = '\0';

    return s;
}

int main() {
    char input[101]; 
    
    
    
    fgets(input, sizeof(input), stdin);
    while(input){
    size_t len = strlen(input);
    if (len > 0 && input[len - 1] == '\n') {
        input[len - 1] = '\0';
    }

    char str1[50]; 
    char str2[50]; 

    int i;
    int meio = -1; 
    for (i = 0; input[i] != '\0'; i++) {
        if (input[i] == ' ') {
            meio = i;
            input[i] = '\0';
        }
    }

    if (meio != -1) {
        strncpy(str1, input, meio);
        str1[meio] = '\0';
        
        strcpy(str2, &input[meio + 1]);
    } else {
        printf(" ");
        return 1; // Saída de erro
    }

    char output[101]; 
    intercalar(output, str1, str2);


    printf("%s\n", output);
        fgets(input, sizeof(input), stdin);
    }
    return 0;
}
