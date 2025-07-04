
package ar.edu.utn.fra.prog2.cine.vista;

import ar.edu.utn.fra.prog2.cine.modelo.Cine;
import ar.edu.utn.fra.prog2.cine.modelo.Cliente;
import ar.edu.utn.fra.prog2.cine.modelo.Sala;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SalaView extends VBox{

    public SalaView(Stage stage, Cine cine, Cliente cliente) {
        setSpacing(10);
        setPadding(new Insets(20));
        
        Label titulo = new Label("Seleccione una sala");
        ListView<Sala> listaSalas = new ListView<>();
        listaSalas.getItems().addAll(cine.getSalas());
        
        Label lblMensaje = new Label();
        
        Button btnContinuar = new Button("Ver butacas");
        btnContinuar.setOnAction(eh ->{
            Sala seleccionada = listaSalas.getSelectionModel().getSelectedItem();
            if(seleccionada != null)
            {
                lblMensaje.setText("La Sala seleccionada es: "+ seleccionada.getNumero());
                //luego si sucede esto se debera abrir la view de butacas
                ButacasView vistaButacas = new ButacasView(stage, cine, seleccionada, cliente);
            }else{
                lblMensaje.setText("Por favor, seleccioná una sala");
            }
        });
        
        Button btnResumen = new Button("Ver resumen de compras");
        btnResumen.setOnAction(eh ->{
            ResumenEntradasView resumen = new ResumenEntradasView(stage,cine, cliente);
        });
        
        getChildren().addAll(titulo,listaSalas,lblMensaje,btnContinuar, btnResumen);
        
        Scene scene = new Scene(this, 400, 300);
        stage.setTitle("Salas disponibles");
        stage.setScene(scene);
        stage.show();
    }
    
}
