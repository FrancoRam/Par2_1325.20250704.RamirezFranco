
package ar.edu.utn.fra.prog2.cine.vista;

import ar.edu.utn.fra.prog2.cine.modelo.Butaca;
import ar.edu.utn.fra.prog2.cine.modelo.Cine;
import ar.edu.utn.fra.prog2.cine.modelo.Cliente;
import ar.edu.utn.fra.prog2.cine.modelo.Entrada;
import ar.edu.utn.fra.prog2.cine.modelo.Sala;
import ar.edu.utn.fra.prog2.cine.persistencia.PersistenciaDatos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
//IMPLEMENTACION DE GridPane
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButacasView extends VBox{

    public ButacasView(Stage stage, Cine cine, Sala sala, Cliente cliente) {
        setSpacing(10);
        setPadding(new Insets(20));
        
        Label titulo = new Label("Sala " + sala.getNumero() + " - Película: " + sala.getPelicula());
        
        GridPane grilla = new GridPane();
        // establecemos el espacio horizontal entre las columnas adyacentes
        grilla.setHgap(5);
        // establecemos el espacio vertical entre las filas adyacentes
        grilla.setVgap(5);
        
        Butaca[][] butacas = sala.getButacas();
        
        if(butacas == null)
        {
            getChildren().add(new Label("ERROR - La sala todavia no tiene butacas"));
        }else{
            //Recorremos con dos bucles anidados la matriz de butacas. i=fila / j=columna
            for (int i = 0; i < butacas.length; i++) {
                for (int j = 0; j < butacas[i].length; j++) {
                    Butaca b = butacas[i][j]; //b se 'setea' con la butaca actual
                    //String txtFila = String.valueOf((char)('A'+i)); //A,b,C,D,E...
                    Button btn = new Button("" + b.getFila()+""+ b.getNumero());
                    //Button btn = new Button(txtFila+(j+1)); //creo el botn, concatenando fila y columna

                    btn.setMinWidth(50); //tamaño min del btn
                    if (b.isOcupada()) { //evaluo la bandera de la butaca
                        btn.setDisable(true);//inhabilito el btn si ya se encuentra ocupada
                        btn.setStyle("-fx-background-color: #ff6b6b;"); // se PINTA de rojo
                    } else {
                        btn.setStyle("-fx-background-color: #81ecec;"); // si esta libre se PINTA de azul
                        btn.setOnAction(e -> { ///al hacer click ->
                            Alert confirmacionCompra = new Alert(Alert.AlertType.CONFIRMATION);
                            confirmacionCompra.setTitle("Confirmar compra");
                            confirmacionCompra.setHeaderText("Desea comprar esta butaca?");
                            
                            confirmacionCompra.showAndWait().ifPresent(respuesta ->{
                                if(respuesta == ButtonType.OK)
                                {
                                    b.setOcupada(true);//seteo en ocupada
                                    Entrada entrada = new Entrada(cliente, sala, b); //Nueva entrada (Sala y butaca) para cliente
                                    cine.getEntradas().add(entrada); //Agrega la entrada a la lista de entradas del Cine
                                    PersistenciaDatos.guardarCine(cine); //Guarda en disco 
                                    btn.setDisable(true); //desactivamos el btn
                                    btn.setStyle("-fx-background-color: #ff6b6b;"); //se pinta de rojo

                                    //Nuevo mensaje de confirmacion
                                    Alert alertaConfirmacion = new Alert(Alert.AlertType.INFORMATION);
                                    alertaConfirmacion.setTitle(cliente.getNombre()+" su compra de entrada fue exitosa!");
                                    alertaConfirmacion.setHeaderText(null);
                                    alertaConfirmacion.setContentText("Compró la Butaca: "+ b.getFila() + b.getNumero());
                                    alertaConfirmacion.showAndWait();  
                                }
                            });
                            
                        });
                    }

                    grilla.add(btn, j, i); //agrega el btn a la grilla ya creada
                }
            }
        }
        //boton para regresar a la seleccion de sala y pelicula
        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(eh ->{
            
            SalaView salas = new SalaView(stage, cine, cliente);
        });
        getChildren().addAll(titulo,grilla, btnVolver);
        
        Scene scene = new Scene(this, 500,400);
        stage.setTitle("Selecciona la butaca deseada");
        stage.setScene(scene);
        stage.show();
    }
    
}
