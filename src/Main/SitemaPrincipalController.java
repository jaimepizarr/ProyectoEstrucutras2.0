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

/**
 *
 * @author PC
 */
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
    
    private static SitemaPrincipalController singleInstance;
    
    /**
     *Constructor: Initializes the lists
     */
    public SitemaPrincipalController() {
        tableList = new LinkedList<>();
        puestosLibres = new LinkedList<>();
        turnos = new PriorityQueue<>((Turno t1,Turno t2)-> 
                t1.getPaciente().getSintoma().getPrioridad()-t2.getPaciente().getSintoma().getPrioridad());
    }
    
    /**
     * Method for Singleton Design Pattern.
     * @return Single Instance of the class
     */
    public static SitemaPrincipalController getInstance(){
        if(singleInstance == null){
            singleInstance = new SitemaPrincipalController();
        }
        return singleInstance;
    }

    @FXML
    void initialize() {
        assert mediaView != null : "fx:id=\"mediaView\" was not injected: check your FXML file 'FXML.fxml'.";
        colTurno.setCellValueFactory(new PropertyValueFactory("turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("puesto"));
    }

    /**
     *Method for assigning places to a turn.
     */
    private void asignarPuestoATurno() {
        if (puestosLibres.size() > 0) {
            Turno t = turnos.poll();
            Puesto p = puestosLibres.poll();
            TurnoPuesto tp = new TurnoPuesto(t,p);
            tableList.addFirst(tp);
            tbTurnoPuesto.refresh();
        }
    }

    public LinkedList<TurnoPuesto> getTableList() {
        return tableList;
    }

    public void setTableList(LinkedList<TurnoPuesto> tableList) {
        this.tableList = tableList;
    }

    public Queue<Puesto> getPuestosLibres() {
        return puestosLibres;
    }

    public void setPuestosLibres(Queue<Puesto> puestosLibres) {
        this.puestosLibres = puestosLibres;
    }

    public PriorityQueue<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(PriorityQueue<Turno> turnos) {
        this.turnos = turnos;
    }
    
    
    
}
