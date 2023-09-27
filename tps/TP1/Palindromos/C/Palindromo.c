#include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#include <wctype.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, ""); // Set the locale for wide character handling

    wchar_t *palavra = NULL;
    size_t max_length = 100;
    size_t length = 0;

    while (1) {
        if (palavra != NULL) {//garantindo que a palavra seja nula no inicia da repetição
            free(palavra);
            palavra = NULL;
        }

        palavra = (wchar_t *)malloc(max_length * sizeof(wchar_t));
        if (palavra == NULL) {
            return 1;
        }

        if (fgetws(palavra, max_length, stdin) == NULL) {
            break; 
        }

        length = wcslen(palavra);

        
        if (length > 0 && palavra[length - 1] == L'\n') {
            palavra[length - 1] = L'\0';
            length--;
        }

        if (wcscmp(palavra, L"FIM") == 0) {
            break; 
        }

        wchar_t *palindromo = (wchar_t *)malloc((length + 1) * sizeof(wchar_t));
        if (palindromo == NULL) {           
            free(palavra);
            return 1;
        }

        
        for (int i = length - 1; i >= 0; i--) {
            palindromo[length - 1 - i] = palavra[i];
        }
        palindromo[length] = L'\0';

        if (wcscmp(palavra, palindromo) == 0) {
            wprintf(L"SIM\n");
        } else {
            wprintf(L"NAO\n");
        }

        free(palindromo);
    }

    free(palavra);

    return 0;
}
