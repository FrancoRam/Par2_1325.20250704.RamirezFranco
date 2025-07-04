
package ar.edu.utn.fra.prog2.cine.controlador;

import ar.edu.utn.fra.prog2.cine.modelo.Cine;
import ar.edu.utn.fra.prog2.cine.modelo.Cliente;
import ar.edu.utn.fra.prog2.cine.persistencia.PersistenciaDatos;
import ar.edu.utn.fra.prog2.cine.vista.LoginView;
import ar.edu.utn.fra.prog2.cine.vista.SalaView;
import javafx.stage.Stage;


public class LoginController {
    private Cine cine;
    private Cliente clienteLogueado;
    //login VISTA
    private LoginView vista;

    public LoginController(LoginView vista) {
        this.vista = vista;
        this.cine = PersistenciaDatos.cargarCine();
        //falta el parametro de butacas en esta carga, se creo 2 ctores.
        this.cine.cargarSalasEjemplo();
    }
    
    public void login(String email, String contraseña) {
        for (Cliente c : cine.getClientes()) {
            if (c.getEmail().equals(email) && c.getContraseña().equals(contraseña)) {
                vista.mostrarMensaje("¡Bienvenido " + c.getNombre() + " a CINE HOYTS");
                this.clienteLogueado = c;
                // Si las credenciales son correctas damos la bienvenida al user y 
                // mostramos la vista de Salas disponibles
                Stage stage = (Stage) vista.getScene().getWindow();
                SalaView salaView = new SalaView(stage, cine, clienteLogueado);
                return;
            }
        }
        vista.mostrarMensaje("Credenciales incorrectas.");
    }
    
    public void register(String nombre, String email, String contraseña) {
        for (Cliente c : cine.getClientes()) 
        {
            if (c.getEmail().equals(email)) {
                vista.mostrarMensaje("Ya existe un usuario con ese email.");
                return;
            }
        }
        Cliente nuevo = new Cliente(nombre, email, contraseña);
        cine.getClientes().add(nuevo);
        PersistenciaDatos.guardarCine(cine);
        vista.mostrarMensaje("Registro exitoso. Ahora podés iniciar sesión.");
    }
    
    
    
    
    
}
