/*
LPA - 2024/01   -   03/05/2024*/

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

typedef struct evento{
    double tempo;
    int alvo;
    int tipo;
}evento_t;

typedef struct lista_eventos_t{
    evento_t* evento;
    struct lista_eventos_t* prox;
    int* lista;
}lista_eventos_t;

bool lista_eventos_adicionar_inicio(evento_t *evento, lista_eventos_t** lista){
    lista_eventos_t *novo_evento = malloc(sizeof(lista_eventos_t));
    if(novo_evento == NULL){
        return false;
    }

    novo_evento->evento = evento;
    novo_evento->prox = *lista;

    *lista = novo_evento;

    return true;
}

bool lista_eventos_adicionar_fim(evento_t *evento, lista_eventos_t **lista) {
    lista_eventos_t *novo_item = malloc(sizeof(lista_eventos_t));
    if (novo_item == NULL) return false;
    novo_item->evento = evento;
    novo_item->prox = NULL;

    if (*lista == NULL) {
        *lista = novo_item;
    } else {
        lista_eventos_t *atual = *lista;
        while (atual->prox != NULL) {
            atual = atual->prox;
        }
        atual->prox = novo_item;
    }

    return true;
}

bool lista_eventos_adicionar_ordenado(evento_t *evento, lista_eventos_t **lista){
    lista_eventos_t *novo_item = malloc(sizeof(lista_eventos_t));
    if (novo_item == NULL) return false;
    novo_item->evento = evento;

    if (*lista == NULL || (*lista)->evento->tempo >= evento->tempo) {
        novo_item->prox = *lista;
        *lista = novo_item;
    } else {
        lista_eventos_t *atual = *lista;
        while (atual->prox != NULL && atual->prox->evento->tempo < evento->tempo) {
            atual = atual->prox;
        }
        novo_item->prox = atual->prox;
        atual->prox = novo_item;
    }

    return true;
}

void lista_eventos_listar(lista_eventos_t *lista){
    lista_eventos_t *atual = lista;
    while (atual != NULL) {
        printf("%3.6f \t %d \t %d  \n", atual->evento->tempo, atual->evento->alvo, atual->evento->tipo);
        atual = atual->prox;
    }
}    

int main(int argc, char *argv[]){
    FILE *arquivo = fopen(argv[1], "r");
    double tempo = 0;
    int alvo = 0; 
    int tipo = 0;
    lista_eventos_t* lista = NULL;

    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo %s\n", argv[1]);
        return 1;
    }
    
    while(!feof(arquivo)){
        evento_t* novo = malloc(sizeof(evento_t));
        if(novo == NULL){
            printf("Erro ao alocar memória para novo evento.\n");
            return 1;
        }
        fscanf(arquivo, "%lf\t%d\t%d\n", &tempo, &alvo, &tipo);
        
        novo->tempo = tempo;
        novo->alvo = alvo;
        novo->tipo = tipo;
        
        //lista_eventos_adicionar_inicio(novo, &lista);
        //lista_eventos_adicionar_fim(novo, &lista);
        lista_eventos_adicionar_ordenado(novo, &lista);
    }

    fclose(arquivo);

    lista_eventos_listar(lista);

    return 0;
}
