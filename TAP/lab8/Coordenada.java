package br.edu.ufam.icomp.lab_excecoes;

public class Coordenada{
    private int posX;
    private int posY;
    private int digito;

    public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException {
        if (posX < 0 || posY < 0) {
            throw new CoordenadaNegativaException();
        }

        if (posX < 0 || posX > 30000 || posY < 0 || posY > 30000) {
            throw new CoordenadaForaDosLimitesException();
        }

        int somaCoordenadas = posX + posY;
        if (digito < 0 || digito > 9 || somaCoordenadas % 10 != digito) {
            throw new DigitoInvalidoException();
        }

        this.posX = posX;
        this.posY = posY;
        this.digito = digito;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public double distancia(Coordenada coordenada) {
        double dx = this.posX - coordenada.posX;
        double dy = this.posY - coordenada.posY;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return posX + ", " + posY;
    }
    
}