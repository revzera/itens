/*
LPA - 2024/01   -   05/07/2024

Para compilar:

gcc <nome arquivo.c> -o programa
./programa <arquivo de teste.http>

*/

#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <arpa/inet.h>

typedef struct {
    uint8_t daddr[6]; // Endereco MAC de destino
    uint8_t saddr[6]; // Endereco MAC de origem (source)
    uint16_t protocol; // Protocolo da próxima camada (IP!)
} ethernet_hdr_t;

typedef struct {
    uint8_t hdr_len:4, version:4;// Tamanho do Cabeçalho e Versão do IP
    uint8_t tos; // Tipo de serviço
    uint16_t tot_len; // Tamanho total do IP
    uint16_t id; // Id do pacote
    uint16_t frag_off; // Fragmentado?
    uint8_t ttl; // Tempo de vida
    uint8_t protocol; // Protocolo próxima camada (TCP!)
    uint16_t check; // Checksum
    uint8_t saddr[4]; // Endereço IP de origem
    uint8_t daddr[4]; // Endereço IP de destino
} ipHeader_t;

typedef struct {
    uint16_t sport; // Porta TCP de origem
    uint16_t dport; // Porta TCP de destino
    uint32_t seq; // Sequência
    uint32_t ack_seq; // Acknowledgement
    uint8_t reservado:4, // Não usado
    hdr_len:4; // Tamanho do cabecalho
    uint8_t flags; // Flags do TCP
    uint16_t window; // Tamanho da janela
    uint16_t check; // Checksum
    uint16_t urg_ptr; // Urgente
} tcpHeader_t;

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    FILE *fp = fopen(argv[1], "rb");
    if (fp == NULL) {
        perror("Error opening file");
        return 1;
    }

    //Ethernet header
    ethernet_hdr_t etherHeader;
    fread(&etherHeader, sizeof(ethernet_hdr_t), 1, fp);

    //Ethernet header
    printf("Lendo Ethernet ..\n");
    printf(" --> MAC de Origem: %.2x:%.2x:%.2x:%.2x:%.2x:%.2x\n",
           etherHeader.saddr[0], etherHeader.saddr[1], etherHeader.saddr[2],
           etherHeader.saddr[3], etherHeader.saddr[4], etherHeader.saddr[5]);
    printf(" --> MAC de Destino: %.2x:%.2x:%.2x:%.2x:%.2x:%.2x\n",
           etherHeader.daddr[0], etherHeader.daddr[1], etherHeader.daddr[2],
           etherHeader.daddr[3], etherHeader.daddr[4], etherHeader.daddr[5]);

    // IP header
    ipHeader_t ipHeader;
    fseek(fp, sizeof(etherHeader), SEEK_SET); // Seek past Ethernet header
    fread(&ipHeader, sizeof(ipHeader_t), 1, fp);

    printf("Lendo IP ..\n");
    printf(" --> Versão do IP: %d\n", ipHeader.version);
    printf(" --> Tamanho do cabeçalho: %d bytes\n", ipHeader.hdr_len * 4);
    printf(" --> Tamanho do pacote: %d bytes\n", ntohs(ipHeader.tot_len));
    printf(" --> Endereço IP de Origem: %d.%d.%d.%d\n",
           ipHeader.saddr[0], ipHeader.saddr[1], ipHeader.saddr[2], ipHeader.saddr[3]);
    printf(" --> Endereço IP de Destino: %d.%d.%d.%d\n",
           ipHeader.daddr[0], ipHeader.daddr[1], ipHeader.daddr[2], ipHeader.daddr[3]);

    fseek(fp, ipHeader.hdr_len * 4 - sizeof(ipHeader_t), SEEK_CUR);

    tcpHeader_t tcpHeader;
    fread(&tcpHeader, sizeof(tcpHeader_t), 1, fp);

    printf("Lendo TCP ..\n");
    printf(" --> Porta de Origem: %d\n", ntohs(tcpHeader.sport));
    printf(" --> Porta de Destino: %d\n", ntohs(tcpHeader.dport));
    printf(" --> Tamanho do cabeçalho: %d bytes\n", tcpHeader.hdr_len * 4);

    fseek(fp, tcpHeader.hdr_len * 4 - sizeof(tcpHeader_t), SEEK_CUR);

    int ip_header_size = ipHeader.hdr_len * 4;
    int tcp_header_size = tcpHeader.hdr_len * 4;
    int total_header_size = sizeof(ethernet_hdr_t) + ip_header_size + tcp_header_size;
    int packet_size = ntohs(ipHeader.tot_len) + sizeof(ethernet_hdr_t);
    int http_data_size = packet_size - total_header_size;

    printf("Lendo Dados (HTTP) ..\n");
    printf(" --> Tamanho dos dados: %d bytes\n", http_data_size);
    printf(" --> Dados:\n");

    fseek(fp, total_header_size, SEEK_SET);

    for (int i = 0; i < http_data_size; ++i) {
        char c = fgetc(fp);
        if (c == EOF) break;
        putchar(c);
    }
    putchar('\n');

    fclose(fp);

    return 0;
}
