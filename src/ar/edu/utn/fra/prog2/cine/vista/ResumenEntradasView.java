
package ar.edu.utn.fra.prog2.cine.vista;

import ar.edu.utn.fra.prog2.cine.modelo.Cine;
import ar.edu.utn.fra.prog2.cine.modelo.Cliente;
import ar.edu.utn.fra.prog2.cine.modelo.Entrada;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResumenEntradasView extends VBox{

    public ResumenEntradasView(Stage stage, Cine cine, Cliente cliente) {
        setSpacing(10);
        setPadding(new Insets(20));
        
        Label titulo = new Label("- Entradas Compradas -");
        
        ListView<String> listaDeEntradas = new ListView<>();
        
        for (Entrada e : cine.getEntradas()) {
            //Mi identificador ID para clientes es el email.
            if (e.getCliente().getEmail().equals(cliente.getEmail())) {
                String descripcion = cliente.getNombre()+ ": Sala " + e.getSala().getNumero()
                                   + " - " + e.getSala().getPelicula()
                                   + " - Butaca/s: " + e.getButaca().getFila() + e.getButaca().getNumero();
                listaDeEntradas.getItems().add(descripcion);
            }
        }
        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> {
            SalaView salas = new SalaView(stage, cine, cliente);
        });
        
        getChildren().addAll(titulo, listaDeEntradas, btnVolver);
        
        Scene scene = new Scene(this, 450, 300);
        stage.setTitle("Mis Entradas");
        stage.setScene(scene);
        stage.show();
    } 
}
