/*
LPA - 2024/01   -   16/05/2024

Para compilar:

gcc <nome arquivo.c> -o programa
./programa <número do tamanho da tabela hash> <arquivo de entrada.txt>

*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Pessoa {
    char nome[51];
    long long int cpf;
    int idade;
    struct Pessoa *prox;
}Pessoa;

typedef struct ListaPessoas{
    Pessoa *inicio;
}ListaPessoas;

typedef ListaPessoas** TabelaHash;

Pessoa* criarPessoa(char nome[], long long int cpf, int idade){
    Pessoa *novaPessoa = (Pessoa*)malloc(sizeof(Pessoa));
    if(novaPessoa != NULL){
        strcpy(novaPessoa->nome, nome);
        novaPessoa->cpf = cpf;
        novaPessoa->idade = idade;
        novaPessoa->prox = NULL;
    }
    return novaPessoa;
}

bool inserirPessoaLista(Pessoa *pessoa, ListaPessoas **lista){
    if(pessoa == NULL){
        return false;
    }

    Pessoa *novoInicio = pessoa;
    novoInicio->prox = (*lista)->inicio;
    (*lista)->inicio = novoInicio;

    return true;
}

void listaPessoasListar(ListaPessoas *lista){
    Pessoa *p = lista->inicio;
    while(p != NULL){
        printf("- %s %lld %d\n", p->nome, p->cpf, p->idade);
        p = p->prox;
    }
}

TabelaHash TabelaHashPessoasCriar(int tamanho){
    TabelaHash tabela = (TabelaHash)malloc(tamanho * sizeof(ListaPessoas*));
    if(tabela != NULL){
        for(int i = 0; i < tamanho; i++){
            tabela[i] = (ListaPessoas*)malloc(sizeof(ListaPessoas));
            tabela[i]->inicio = NULL;
        }
    }

    return tabela;
}

int tabelaHashPessoas(Pessoa *pessoa, int tamanho){
    return pessoa->cpf % tamanho;
}

bool tabelaHashPessoasAdicionar(Pessoa *pessoa, TabelaHash tabela, int tamanho){
    if(pessoa == NULL || tabela == NULL) return false;

    int indice = tabelaHashPessoas(pessoa, tamanho);
    return inserirPessoaLista(pessoa, &(tabela[indice]));
}

void tabelaHashPessoasListar(TabelaHash tabela, int tamanho){
    for(int i = 0; i < tamanho; i++){
        printf("POSIÇÃO %d DA TABELA HASH:\n", i);
        listaPessoasListar(tabela[i]);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Uso: %s <tamanho da tabela> <arquivo de entrada>\n", argv[0]);
        return 1;
    }

    int tamanhoTabela;
    if (sscanf(argv[1], "%d", &tamanhoTabela) != 1 || tamanhoTabela <= 0) {
        printf("O tamanho da tabela deve ser um número positivo.\n");
        return 1;
    }

    TabelaHash tabela = TabelaHashPessoasCriar(tamanhoTabela);
    if (tabela == NULL) {
        printf("Erro ao criar a tabela hash.\n");
        return 1;
    }

    FILE *arquivo = fopen(argv[2], "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo de entrada.\n");
        return 1;
    }

    char nome[51];
    long long int cpf;
    int idade;
    while (fscanf(arquivo, "%50[^\t]\t%lld\t%d\n", nome, &cpf, &idade) == 3) {
        Pessoa *novaPessoa = criarPessoa(nome, cpf, idade);
        if (novaPessoa == NULL) {
            printf("Erro ao criar a pessoa.\n");
            return 1;
        }
        tabelaHashPessoasAdicionar(novaPessoa, tabela, tamanhoTabela);
    }

    fclose(arquivo);

    tabelaHashPessoasListar(tabela, tamanhoTabela);

    for (int i = 0; i < tamanhoTabela; i++) {
        free(tabela[i]);
    }
    free(tabela);

    return 0;
}












