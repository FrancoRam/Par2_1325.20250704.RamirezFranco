package ar.edu.utn.fra.prog2.cine.vista;

import ar.edu.utn.fra.prog2.cine.controlador.LoginController;
import ar.edu.utn.fra.prog2.cine.modelo.Cliente;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends VBox{

    private LoginController controller;
    public LoginView(Stage stage) {
        controller = new LoginController(this);
        
        setSpacing(10);
        setPadding(new Insets(20));
    
        TextField emailField = new TextField();
        emailField.setPromptText("Correo/Email");
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Contraseña");
        
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre (Solo para nuevos registros)");
        
        Button loginBtn = new Button("Iniciar Sesion");
        Button registerBtn = new Button("Registrarse");
        
        Label messageLabel = new Label();
        
        loginBtn.setOnAction(eh ->{
            controller.login(emailField.getText(), passwordField.getText());
        });
        registerBtn.setOnAction(eh ->{
            controller.register(nombreField.getText(), emailField.getText(), passwordField.getText());
        });
        getChildren().addAll(emailField,passwordField,nombreField,loginBtn,registerBtn,messageLabel);
        
        Scene scene = new Scene(this, 300, 300);
        stage.setTitle("Login / Registro");
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    public void mostrarMensaje(String mensaje) {
        Alert alertBienvenida = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK);
        
        alertBienvenida.setHeaderText(null);
        alertBienvenida.showAndWait();
        
         
    }
    
}
