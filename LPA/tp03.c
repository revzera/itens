/*
LPA - 2024/01   -   17/05/2024

Para compilar:

gcc <nome arquivo.c> -o programa
./programa <arquivo de entrada.txt>

*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

typedef struct vizinho{
    int id_vizinho;
    struct vizinho *prox;
}listaVizinhos_t;

typedef struct{
    int id;
    double pos_x;
    double pos_y;
    listaVizinhos_t* lista_vizinho;
}no_t;

typedef no_t* grafo_t;

bool adicionarListaVizinhos(int vizinho, listaVizinhos_t **lista){
    listaVizinhos_t *novo = (listaVizinhos_t*)malloc(sizeof(listaVizinhos_t));
    if(!novo) return false;
    novo->id_vizinho = vizinho;
    novo->prox = *lista;
    *lista = novo;

    return true;
}

void imprimirListaVizinhos(listaVizinhos_t *lista){
    while(lista){
        printf("%d ", lista->id_vizinho);
        lista = lista->prox;
    }
    printf("\n");
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

void imprimirGrafo(int tam, grafo_t grafo){
    for(int i = 0; i < tam; i++){
        printf("NÓ %d: ", grafo[i].id);
        imprimirListaVizinhos(grafo[i].lista_vizinho);
    }
}

int main(int argc, char** argv){
    if (argc != 2) {
        printf("Para usar: %s <arquivo de entrada>\n", argv[0]);
        return 1;
    }

    FILE* arquivo = fopen(argv[1], "r");
    if(arquivo == NULL){
        printf("Erro ao abrir o arquivo");
        return 1;
    }

    int num_nos;
    double raio_comunicacao;
    fscanf(arquivo, "%d\t%lf\n", &num_nos, &raio_comunicacao);
        
    grafo_t grafo = criarGrafo(num_nos);

    for(int i = 0; i < num_nos; i++){
        int id;
        double pos_x, pos_y;
        fscanf(arquivo, "%d\t%lf\t%lf\n", &id, &pos_x, &pos_y);
        grafo[i].id = id;
        grafo[i].pos_x = pos_x;
        grafo[i].pos_y = pos_y;
        grafo[i].lista_vizinho = NULL;
    }

    fclose(arquivo);

    atualizarGrafoVizinhos(num_nos, raio_comunicacao, grafo);
    imprimirGrafo(num_nos, grafo);

    for (int i = 0; i < num_nos; i++) {
        listaVizinhos_t* vizinho = grafo[i].lista_vizinho;
        while (vizinho != NULL) {
            listaVizinhos_t* temp = vizinho;
            vizinho = vizinho->prox;
            free(temp);
        }
    }
    free(grafo);

    return 0;
}