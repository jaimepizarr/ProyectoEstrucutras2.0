package FXMLControllers;

import ComponentesSistema.Puesto;
import ComponentesSistema.Turno;
import ComponentesSistema.TurnoPuesto;
import FileReaders.PuestoFileReader;
import Resources.CloseAlert;
import TDA.CircularLinkedList;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import resources.MediaVideos;

/**
 *
 * @author PC
 */
public class SitemaPrincipalController implements Initializable {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private MediaView media;
    @FXML
    private TableView<TurnoPuesto> tbTurnoPuesto;
    @FXML
    private TableColumn<String, TurnoPuesto> colTurno;
    @FXML
    private TableColumn<Integer, TurnoPuesto> colPuesto;

    private ObservableList<TurnoPuesto> tableList;
    private Queue<Puesto> puestosLibres;
    private PriorityQueue<Turno> turnos;
    private RegistrosController rController;

    private static SitemaPrincipalController singleInstance;

    /**
     * Constructor: Initializes the lists
     */
    public SitemaPrincipalController() {
        singleInstance = this;
        tableList = FXCollections.observableArrayList();
        puestosLibres = new LinkedList<>();
        turnos = new PriorityQueue<>((Turno t1, Turno t2)
                -> t1.getPaciente().getSintoma().getPrioridad() - t2.getPaciente().getSintoma().getPrioridad());
        iniciarRegistroView();
        iniciarPuestosVacios();
    }

    /**
     * Iniciar la vista registro y pasar como parametro este controler.
     */
    public void iniciarRegistroView() {
        try {
            Stage anotherStage = new Stage();
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/FXMLFiles/Registros.fxml"));
            Parent root1 = loader1.load();
            rController = loader1.getController();

            Scene scene1 = new Scene(root1);
            System.out.println(rController);
            rController.setPrincipal(this);

            anotherStage.setScene(scene1);
            anotherStage.show();

        } catch (IOException ex) {
            Logger.getLogger(SitemaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Llenar los puestos vacíos al iniciar el programa
     */
    public void iniciarPuestosVacios() {
        PuestoFileReader reader = new PuestoFileReader();
        LinkedList<Puesto> puestosExistentes = reader.LeerArchivo("puesto.ser");
        puestosLibres.addAll(puestosExistentes);
    }

    /**
     * Method for Singleton Design Pattern.
     *
     * @return Single Instance of the class
     */
    public static SitemaPrincipalController getInstance() {
        if (singleInstance == null) {
            singleInstance = new SitemaPrincipalController();
        }
        return singleInstance;
    }

    /**
     * Method for assigning places to a turn.
     */
    public void asignarPuestoATurno() {
        if (puestosLibres.size() > 0 && !turnos.isEmpty()) {
            Turno t = turnos.poll();
            Puesto p = puestosLibres.poll();
            TurnoPuesto tp = new TurnoPuesto(t, p);
            tableList.add(tp);
            tbTurnoPuesto.setItems(tableList);
        }
    }

    public ObservableList<TurnoPuesto> getTableList() {
        return tableList;
    }

    public void setTableList(ObservableList<TurnoPuesto> tableList) {
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

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colTurno.setCellValueFactory(new PropertyValueFactory("turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("puesto"));

        //initMediaPlayer(media, urlsVideos);

    }

    CircularLinkedList<String> urls = MediaVideos.readFileOfVideo();
    Iterator<String> urlsVideos = urls.iterator();

    private void initMediaPlayer(final MediaView mediaView, final Iterator<String> urls) {

        if (urlsVideos.hasNext()) {
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(urlsVideos.next()).toExternalForm()));
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setOnEndOfMedia(new Runnable() {
                @Override
                public void run() {
                    initMediaPlayer(mediaView, (Iterator<String>) urls);
                }
            });
            mediaView.setMediaPlayer(mediaPlayer);
        }

    }

    public RegistrosController getrController() {
        return rController;
    }

    public void setrController(RegistrosController rController) {
        this.rController = rController;
    }

}
