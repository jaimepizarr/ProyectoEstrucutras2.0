package Main;

import ComponentesSistema.Puesto;
import ComponentesSistema.Turno;
import ComponentesSistema.TurnoPuesto;
import java.net.URL;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
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
    private TableColumn<String, TurnoPuesto> colTurno;
    @FXML
    private TableColumn<Integer, TurnoPuesto> colPuesto;

    private LinkedList<TurnoPuesto> tableList;
    private Queue<Puesto> puestosLibres;
    private PriorityQueue<Turno> turnos;

    public SitemaPrincipalController() {
        tableList = new LinkedList<>();
        puestosLibres = new LinkedList<>();
        turnos = new PriorityQueue<>();
    }

    @FXML
    void initialize() {
        assert mediaView != null : "fx:id=\"mediaView\" was not injected: check your FXML file 'FXML.fxml'.";
        colTurno.setCellValueFactory(new PropertyValueFactory("turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("puesto"));
    }

    private void asignarPuestoATurno() {
        if (puestosLibres.size() > 0) {
            Turno t = turnos.poll();
            Puesto p = puestosLibres.poll();
            TurnoPuesto tp = new TurnoPuesto(t,p);
            tableList.addFirst(tp);
            tbTurnoPuesto.refresh();
        }
    }
    
}
