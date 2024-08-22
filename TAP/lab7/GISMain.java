package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {
    public static void main(String[] args) {
        Localizavel[] vetorLocalizaveis = new Localizavel[2];

        vetorLocalizaveis[0] = new Celular(55, 92, 123456789);
        vetorLocalizaveis[1] = new CarroLuxuoso("ABC1234");

        for (Localizavel localizavel : vetorLocalizaveis) {
            System.out.println(localizavel.getPosicao());
        }
    }
}
