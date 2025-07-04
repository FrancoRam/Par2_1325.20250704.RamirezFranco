
package ar.edu.utn.fra.prog2.cine.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cine implements Serializable{
    
    public static final int CANT_FILAS = 4;
    public static final int CANT_BUTACAS = 6;
    private ArrayList<Sala> salas;
    private ArrayList<Entrada> entradas;
     //IMPORTANTE PONER ESTA VARIABLE EN 1L
    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> clientes;
    
    
    public Cine() {
        salas = new ArrayList<>();
        entradas = new ArrayList<>();
        clientes = new ArrayList<>();
    }
    
    //Getters && setters
    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    //SALAS DE PRUEBA ------
    public void cargarSalasEjemplo() {
        if (salas.isEmpty()) {
            salas.add(new Sala(1, "9 Reinas"));
            salas.add(new Sala(2, "Relatos Salvajes"));
            salas.add(new Sala(3, "Django sin cadenas"));
            salas.add(new Sala(4, "Cuando acecha la maldad"));
            salas.add(new Sala(5, "Terminator 2"));
        }
    }
}
