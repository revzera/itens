/*
LPA - 2024/01   -   07/06/2024

Para compilar:

gcc <nome arquivo.c> -o programa
./programa <arquivo de teste.zip>

*/

#include <stdio.h>
#include <stdlib.h>

struct zip_file_hdr {
    int signature;
    short version;
    short flags;
    short compression;
    short mod_time;
    short mod_date;
    int crc;
    int compressed_size;
    int uncompressed_size;
    short name_length;
    short extra_field_length;
} __attribute__ ((packed));

int main(int argc, char *argv[]) {
    FILE *zip_file = fopen(argv[1], "rb");
    struct zip_file_hdr *file_hdr = malloc(sizeof(struct zip_file_hdr));

    while (!feof(zip_file)) {
        fread(file_hdr, sizeof(struct zip_file_hdr), 1, zip_file);

        if (file_hdr->signature == 0x04034b50) {
            char *file_name = malloc(file_hdr->name_length + 1);
            fread(file_name, file_hdr->name_length, 1, zip_file);
            file_name[file_hdr->name_length] = '\0';

            printf("Nome do Arquivo: %s\n", file_name);
            printf("Tamanho Compactado: %d\n", file_hdr->compressed_size);
            printf("Tamanho Descompactado: %d\n\n", file_hdr->uncompressed_size);

            free(file_name);
            fseek(zip_file, file_hdr->extra_field_length + file_hdr->compressed_size, SEEK_CUR);
        
        } else {
            return 0;
        }
    }

    free(file_hdr);
    fclose(zip_file);

    return 0;
}
