#include <stdio.h>
#include <string.h>

int main() {
    int N;
    scanf("%d", &N);
    
    for (int i = 0; i < N; i++) {
        char input[101];
        char str1[51], str2[51], result[101];
        fgets(input, sizeof(input), stdin);
        sscanf(input, "%s %s", str1, str2);
        int len1 = strlen(str1);
        int len2 = strlen(str2);
        
        int len = len1 > len2 ? len1 : len2;
        
        for (int j = 0, k = 0; j < len; j++) {
            if (j < len1) {
                result[k++] = str1[j];
            }
            if (j < len2) {
                result[k++] = str2[j];
            }
        }
        
        result[len1 + len2] = '\0';
        
        printf("%s\n", result);
    }
    
    return 0;
}
