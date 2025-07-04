
package ar.edu.utn.fra.prog2.cine.modelo;

import java.io.Serializable;


public class Entrada implements Serializable{
    
    private Cliente cliente;
    private Sala sala;
    private Butaca butaca;

    public Entrada(Cliente cliente, Sala sala, Butaca butaca) {
        this.cliente = cliente;
        this.sala = sala;
        this.butaca = butaca;
    }
    
    //obs: evaluar la sobrecarga de toString()
    
    //Getters && settters
    
    public Cliente getCliente() {
    return cliente;
    }

    public Sala getSala() {
        return sala;
    }

    public Butaca getButaca() {
        return butaca;
    }

}
