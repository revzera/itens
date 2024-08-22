/*
LPA - 2024/01   -   20/06/2024

Para compilar:

gcc <nome arquivo.c> -o programa -lws2_32
./programa <arquivo de teste.png>

*/
 

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <winsock2.h>

#pragma pack(push, 1)
struct png_chunk_hdr {
    uint32_t length;
    char type[4];
};
#pragma pack(pop)

#pragma pack(push, 1)
struct png_chunk_IHDR {
    uint32_t width;
    uint32_t height;
    uint8_t bit_depth;
    uint8_t colour_type;
    uint8_t compression_method;
    uint8_t filter_method;
    uint8_t interlace_method;
};
#pragma pack(pop)

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <arquivo.png>\n", argv[0]);
        return 1;
    }

    FILE *png_file = fopen(argv[1], "rb");
    if (!png_file) {
        perror("Erro ao abrir o arquivo");
        return 1;
    }

    fseek(png_file, 8, SEEK_SET);

    int chunk_count = 1;
    while (!feof(png_file)) {
        struct png_chunk_hdr chunk_hdr;
        
        if (fread(&chunk_hdr, sizeof(struct png_chunk_hdr), 1, png_file) != 1) {
            break;
        }

        uint32_t chunk_length = ntohl(chunk_hdr.length);
        
        printf("Lendo chunk %d:\n", chunk_count);
        printf(" --> Tamanho: %u\n", chunk_length);
        printf(" --> Tipo: %.4s\n", chunk_hdr.type);

        if (strncmp(chunk_hdr.type, "IHDR", 4) == 0) {
            struct png_chunk_IHDR ihdr;
            if (fread(&ihdr, sizeof(struct png_chunk_IHDR), 1, png_file) != 1) {
                break;
            }

            printf(" --> Largura: %u\n", ntohl(ihdr.width));
            printf(" --> Altura: %u\n", ntohl(ihdr.height));

            fseek(png_file, 4, SEEK_CUR);
        } else if (strncmp(chunk_hdr.type, "IEND", 4) == 0) {
            break;
        } else {
            fseek(png_file, chunk_length + 4, SEEK_CUR);
        }

        chunk_count++;
    }

    fclose(png_file);
    return 0;
}
