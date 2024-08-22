package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {
    public static void main(String[] args) {
        Caminho caminho = null;

        try {
            caminho = new Caminho(6);

            Coordenada coord1 = new Coordenada(23, 55, 8);
            caminho.addCoordenada(coord1);

            Coordenada coord2 = new Coordenada(40, 80, 5);
            caminho.addCoordenada(coord2);

            Coordenada coord3 = new Coordenada(30, 70, 2);
            Coordenada coord4 = new Coordenada(25, 65, 4);
            caminho.addCoordenada(coord3);
            caminho.addCoordenada(coord4);

            Coordenada coord5 = new Coordenada(10, 20, 15);
            caminho.addCoordenada(coord5);

            System.out.println(caminho.toString());
        } catch (RoverException e) {
            System.out.println("Erro do Rover: " + e.getMessage());
        } finally {
            if (caminho != null) {
                caminho.reset();
            }
        }
    }
}

