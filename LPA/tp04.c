/*
LPA - 2024/01   -   24/05/2024

Para compilar:

gcc <nome arquivo.c> -o programa -lm
./programa <arquivo de entrada.txt>

*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

typedef struct evento{
    double tempo;
    int alvo;
    int tipo;
    struct evento_t *prox;
}evento_t;

typedef struct vizinho{
    int id_vizinho;
    struct vizinho *prox;
}listaVizinhos_t;

typedef struct{
    int id;
    double pos_x;
    double pos_y;
    bool pacote_enviado;
    listaVizinhos_t* lista_vizinho;
}no_t;

typedef struct{
    evento_t *inicio;
}listaEventos_t;

typedef no_t* grafo_t;

evento_t *criarEvento(double tempo, int alvo, int tipo){
    evento_t *novo = malloc(sizeof(evento_t));

    if(novo != NULL){

        novo->tempo = tempo;
        novo->alvo = alvo;
        novo->tipo = tipo;
        return novo;
    }else{return NULL;}
}

bool adicionarEventoOrdenado(evento_t *evento, listaEventos_t **lista) {
    if (!evento || !lista) return false;

    if (*lista == NULL) {
        *lista = malloc(sizeof(listaEventos_t));
        if (!*lista) return false;
        (*lista)->inicio = NULL;
    }

    evento_t **atual = &(*lista)->inicio;

    while (*atual && (*atual)->tempo <= evento->tempo) {
        atual = &(*atual)->prox;
    }

    evento->prox = *atual;
    *atual = evento;

    return true;
}

bool adicionarListaVizinhos(int vizinho, listaVizinhos_t **lista){
    listaVizinhos_t *novo = (listaVizinhos_t*)malloc(sizeof(listaVizinhos_t));
    if(!novo) return false;
    novo->id_vizinho = vizinho;
    novo->prox = *lista;
    *lista = novo;

    return true;
}

grafo_t criarGrafo(int tam){
    return (grafo_t)malloc(tam * sizeof(no_t));
}

void atualizarGrafoVizinhos(int tam, double raio_comunicacao, grafo_t grafo){
    for(int i = 0; i < tam; i++){
        for(int j = 0; j < tam; j++){
            if(i != j){
                double distancia = sqrt(pow(grafo[i].pos_x - grafo[j].pos_x, 2) + pow(grafo[i].pos_y - grafo[j].pos_y, 2));
                if(distancia <= raio_comunicacao){
                    adicionarListaVizinhos(j, &grafo[i].lista_vizinho);
                }
            }
        }
    }
}

void iniciarSimulacao(listaEventos_t **lista, grafo_t grafo) {
    while (*lista && (*lista)->inicio) {
        evento_t *evento_atual = (*lista)->inicio;
        (*lista)->inicio = evento_atual->prox;

        printf("[%3.6f] Nó %d recebeu pacote\n", evento_atual->tempo, evento_atual->alvo);

        no_t *no_atual = &grafo[evento_atual->alvo];
        if (!no_atual->pacote_enviado) {
            no_atual->pacote_enviado = true;
            listaVizinhos_t *vizinho = no_atual->lista_vizinho;
            while (vizinho) {
                printf("\t--> Repassando pacote para o nó %d ...\n", vizinho->id_vizinho);
                double novo_tempo = evento_atual->tempo + 0.1 + (vizinho->id_vizinho * 0.01);
                evento_t *novo_evento = criarEvento(novo_tempo, vizinho->id_vizinho, 1);
                adicionarEventoOrdenado(novo_evento, lista);
                vizinho = vizinho->prox;
            }
        }

        free(evento_atual);
    }
}

int main(int argc, char **argv) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <arquivo_entrada>\n", argv[0]);
        return 1;
    }

    FILE *arquivo = fopen(argv[1], "r");
    if (!arquivo) {
        perror("Erro ao abrir arquivo");
        return 1;
    }

    int num_nos;
    double raio_comunicacao;
    fscanf(arquivo, "%d %lf", &num_nos, &raio_comunicacao);

    grafo_t grafo = criarGrafo(num_nos);

    for (int i = 0; i < num_nos; i++) {
        fscanf(arquivo, "%d %lf %lf", &grafo[i].id, &grafo[i].pos_x, &grafo[i].pos_y);
    }

    fclose(arquivo);

    atualizarGrafoVizinhos(num_nos, raio_comunicacao, grafo);

    listaEventos_t lista_eventos = {NULL};
    listaEventos_t *ptr_lista_eventos = &lista_eventos;

    evento_t *evento_inicial = criarEvento(1.0, 0, 1);
    adicionarEventoOrdenado(evento_inicial, &ptr_lista_eventos);

    iniciarSimulacao(&ptr_lista_eventos, grafo);

    for (int i = 0; i < num_nos; i++) {
        while (grafo[i].lista_vizinho) {
            listaVizinhos_t *temp = grafo[i].lista_vizinho;
            grafo[i].lista_vizinho = grafo[i].lista_vizinho->prox;
            free(temp);
        }
    }
    free(grafo);

    return 0;
}