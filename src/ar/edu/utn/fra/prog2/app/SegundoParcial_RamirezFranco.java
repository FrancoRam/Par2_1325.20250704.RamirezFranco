//6x4 seran las salas del cine. 
//6 butacas y 4 filas
// docentes: Daniel Benitez, Cristian Corsaro
//Nombre: Ramirez, Franco Nicolas - Div 325 T.N


package ar.edu.utn.fra.prog2.app;

import ar.edu.utn.fra.prog2.cine.vista.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;



public class SegundoParcial_RamirezFranco extends Application{

    public static void main(String[] args) {
        //Cine cineHoyts = new Cine(); probndo las clases del modelo
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LoginView loginView = new LoginView(stage);
    }
    
}
