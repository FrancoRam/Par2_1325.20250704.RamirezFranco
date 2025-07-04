
package ar.edu.utn.fra.prog2.cine.modelo;

import java.io.Serializable;

public class Butaca implements Serializable {

    
    private int numero;
    private int fila;
    private boolean ocupada;

    
    
    public Butaca(int numero, int fila, boolean ocupada) {
        this.numero = numero;
        this.fila = fila;
        this.ocupada = ocupada;
    }
    
    //Getters && Setters
    
    public int getNumero() {
        return numero;
    }

    public int getFila() {
        return fila;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    
    //setter utilizado para inhabilitar los botones de la vista de ButacasView
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

}
