package br.edu.ufam.icomp.lab_excecoes;

import javax.swing.border.CompoundBorder;

public class Caminho {
    private Coordenada[] caminho;
    private int tamanho;
    private int maxTam;

    public Caminho(int maxTam){
        this.maxTam = maxTam;
        this.caminho = new Coordenada[maxTam];
        this.tamanho = 0;    
    }

    public int tamanho(){
        return tamanho;
    }

    public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {
        if (tamanho >= maxTam) {
            throw new TamanhoMaximoExcedidoException();
        }
    
        if (tamanho > 0) {
            Coordenada ultimaCoordenada = caminho[tamanho - 1];
            double distancia = ultimaCoordenada.distancia(coordenada);
            if (distancia > 15.0) {
                throw new DistanciaEntrePontosExcedidaException();
            }
        }
    
        caminho[tamanho] = coordenada;
        tamanho++;
    }

    public void reset(){
        caminho = new Coordenada[maxTam];
        tamanho = 0;
    }

    public String toString(){
        String rrr = "Dados do caminho:\n" +
                     " - Quantidade de pontos:\n" + tamanho +
                     " - Pontos:\n";
        for(int i = 0; i < tamanho; i++){
            rrr += "    -> " + caminho[i].toString() + "\n";
        }

        return rrr;
    }
}
