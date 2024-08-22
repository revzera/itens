#include <stdio.h>
#include <string.h>

int tamanhoMaximo = 3;
char caracteres[] = "abc";

void gerarPalavras(char* prefixo, int tamanho) {
    if (tamanho == 0) {
        printf("%s\n", prefixo);
        return;
    }
    
    int n = strlen(caracteres);
    for (int i = 0; i < n; i++) {
        char novoPrefixo[tamanhoMaximo + 1];
        snprintf(novoPrefixo, sizeof(novoPrefixo), "%s%c", prefixo, caracteres[i]);
        gerarPalavras(novoPrefixo, tamanho - 1);
    }
}

int main() {
    for (int tamanho = 1; tamanho <= tamanhoMaximo; tamanho++) {
        char prefixo[tamanhoMaximo + 1];
        prefixo[0] = '\0';
        gerarPalavras(prefixo, tamanho);
    }
    return 0;
}