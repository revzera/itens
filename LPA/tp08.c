/*
LPA - 2024/01   -   21/06/2024

Para compilar:

gcc <nome arquivo.c> -o programa
./programa <arquivo de teste.mpg>

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define START_CODE_PREFIX "\x00\x00\x01"

void imprimeInfoSequencia(unsigned char byte1, unsigned char byte2, unsigned char byte3, unsigned char byte4) {
    unsigned int largura = byte1 * 16 + (byte2 >> 4);
    unsigned int altura = (byte2 & 0x0F) * 256 + byte3;
    unsigned int frame_rate_code = byte4 & 0x0F;
    const char *frameRateStr;

    switch (frame_rate_code) {
        case 1: frameRateStr = "23.976fps"; break;
        case 2: frameRateStr = "24.000fps"; break;
        case 3: frameRateStr = "25.000fps"; break;
        case 4: frameRateStr = "29.970fps"; break;
        case 5: frameRateStr = "30.000fps"; break;
        case 6: frameRateStr = "50.000fps"; break;
        case 7: frameRateStr = "59.940fps"; break;
        case 8: frameRateStr = "60.000fps"; break;
        default: frameRateStr = "Desconhecido"; break;
    }

    printf("--> Código: b3 -- Sequence Header -- Width = %u, Height = %u -- Frame rate = %s\n", largura, altura, frameRateStr);
}

void imprimeInfoPicture(unsigned char byte2) {
    unsigned char tipo = (byte2 >> 3) & 0x07;
    const char *t_string;

    switch (tipo) {
        case 1: t_string = "I"; break;
        case 2: t_string = "P"; break;
        case 3: t_string = "B"; break;
        default: t_string = "Desconhecido"; break;
    }

    printf("--> Código: 00 -- Picture -- Tipo = %s\n", t_string);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <arquivo_mpeg>\n", argv[0]);
        return EXIT_FAILURE;
    }

    FILE *mpg_file = fopen(argv[1], "rb");
    if (!mpg_file) {
        perror("Erro ao abrir o arquivo");
        return EXIT_FAILURE;
    }

    unsigned char buffer[4];
    size_t bytes_read;
    int prefixEncontrado = 0;

    while ((bytes_read = fread(buffer, 1, 3, mpg_file)) == 3) {
        if (memcmp(buffer, START_CODE_PREFIX, 3) == 0) {
            prefixEncontrado = 1;
            fread(&buffer[3], 1, 1, mpg_file); // Ler o próximo byte após o prefixo
            unsigned char stream_id = buffer[3];

            switch (stream_id) {
                case 0xB3: // Sequence
                    fread(buffer, 1, 4, mpg_file);
                    imprimeInfoSequencia(buffer[0], buffer[1], buffer[2], buffer[3]);
                    break;
                case 0x00: // Picture
                    fread(buffer, 1, 2, mpg_file);
                    imprimeInfoPicture(buffer[1]);
                    break;
                case 0xBA:
                    printf("--> Código: ba -- Pack\n");
                    break;
                case 0xBB:
                    printf("--> Código: bb -- System\n");
                    break;
                case 0xB8:
                    printf("--> Código: b8 -- Group of Pictures\n");
                    break;
                case 0x01 ... 0xAF:
                    printf("--> Código: %.2x -- Slice\n", stream_id);
                    break;
                case 0xC0 ... 0xDF:
                    printf("--> Código: %.2x -- Packet Video\n", stream_id);
                    break;
                case 0xE0 ... 0xEF:
                    printf("--> Código: %.2x -- Packet Audio\n", stream_id);
                    break;
                default:
                    printf("--> Código: %.2x -- Tipo de stream não implementado\n", stream_id);
                    break;
            }
        } else if (prefixEncontrado) {
            fseek(mpg_file, -2, SEEK_CUR); // Voltar dois bytes para continuar a busca pelo próximo prefixo
        }
    }

    fclose(mpg_file);
    return 0;
}
