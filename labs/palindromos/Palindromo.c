#include <stdio.h>
#include <wchar.h>
#include <wctype.h>
#include <locale.h>

int main() {
    setlocale(LC_ALL, ""); 

    wchar_t palavra[100];//para tambem funcionar com caracteres especiais como acentos e cedilha usar wide char
    
    while (1) {
        fgetws(palavra, sizeof(palavra) / sizeof(wchar_t), stdin);
        palavra[wcscspn(palavra, L"\n")] = L'\0'; 
        
        if (wcscmp(palavra, L"FIM") == 0) {
            break; 
        }
        
        wchar_t palindromo[100] = L""; 
        int length = wcslen(palavra);
        
        for (int i = length - 1; i >= 0; i--) {
            palindromo[length - 1 - i] = palavra[i]; 
        }
        
        if (wcscmp(palavra, palindromo) == 0) {
            wprintf(L"SIM\n");
        } else {
            wprintf(L"NAO\n");
        }
    }
    
    return 0;
}


