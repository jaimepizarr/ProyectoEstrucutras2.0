package Main;

import ComponentesSistema.Puesto;
import ComponentesSistema.Turno;
import ComponentesSistema.TurnoPuesto;
import java.net.URL;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaView;

public class SitemaPrincipalController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private MediaView mediaView;
    @FXML
    private TableView<TurnoPuesto> tbTurnoPuesto;
    @FXML
    private TableColumn<String,TurnoPuesto> colTurno;
    @FXML
    private TableColumn<Integer,TurnoPuesto> colPuesto;
    
    private LinkedList<TurnoPuesto> tableList;
    private LinkedList<Puesto> puestosLibres;
    private PriorityQueue<Turno> turnos;
    
    
    
    @FXML
    void initialize() {
        assert mediaView != null : "fx:id=\"mediaView\" was not injected: check your FXML file 'FXML.fxml'.";
        colTurno.setCellValueFactory(new PropertyValueFactory("turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("puesto"));
    }}
    
   /* private void asignarPuestoATurno(){
        while(tableList.size()!=puestos.size()){
            Turno t = turnos.poll();
            
        }
    }
}
*/