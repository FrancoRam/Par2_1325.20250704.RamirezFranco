
package ar.edu.utn.fra.prog2.cine.modelo;

import java.io.Serializable;


public class Sala implements Serializable{
    
    private int numero;
    private String pelicula;
    private Butaca butacas[][];

    public Sala(int numero, String pelicula, Butaca[][] butacas) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }
    
    //ctor para pruebas
    public Sala(int numero, String pelicula) {
    this.numero = numero;
    this.pelicula = pelicula;
    this.butacas = generarButacasPorDefecto();
    }
   
    
    //getters
    public int getNumero() {
        return numero;
    }

    public String getPelicula() {
        return pelicula;
    }
    
    //logica para la sala
    @Override
    public String toString()
    {
        String resultado = "Sala "+ numero+" - "+ pelicula;
        return resultado;
    }
    
    //Matriz de butacas
    public Butaca[][] getButacas() {
        return butacas;
    }
    
    //Butacas hardcodeadas
    private Butaca[][] generarButacasPorDefecto() {
        int filas = Cine.CANT_FILAS;
        int columnas = Cine.CANT_BUTACAS;
        Butaca[][] matriz = new Butaca[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char fila = (char) (i);
                int num = j + 1;
                matriz[i][j] = new Butaca(num, fila, false);
                System.out.println("Butaca generada");
            }
        }

        return matriz;
    }

}
