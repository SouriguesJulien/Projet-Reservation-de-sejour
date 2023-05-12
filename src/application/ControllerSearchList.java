package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class ControllerSearchList implements Initializable {

    @FXML private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Client> tableview;
    @FXML private TableColumn<Client, String> ID;
    @FXML private TableColumn<Client, String> Name;
    @FXML private TableColumn<Client, String> Email;
    @FXML private TableColumn<Client, String> service;
    @FXML private TableColumn<Client, String> other;


    private final ObservableList<Client> clients = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        service.setCellValueFactory(new PropertyValueFactory<>("service"));
        other.setCellValueFactory(new PropertyValueFactory<>("other"));

        Client client1 = new Client(1, "Bouchra", "abder@gmail.com", "Jardinage", 2);
        Client client2 = new Client( 2, "ed", "jbk@gmail.com", "Jardinage", 3);
        Client client3 = new Client( 3, "Julian", "ddf@gmail.com", "Cuisinier", 1);
        Client client4 = new Client(4, "dv", "rfgvq@gmail.com", "Jardinage", 2);
        Client client5 = new Client( 3, "sdv", "q@gmail.com", "Cuisinier", 4);
        Client client6 = new Client(4, "vs", "regv@gmail.com", "Cuisinier", 2);

        clients.addAll(client1,client2, client3, client4,client5,client6);

        FilteredList<Client> listFiltred = new FilteredList<>(clients, b -> true);

        filterField.textProperty().addListener((observable, oldInput, input) -> {
            listFiltred.setPredicate(client -> {
                if (input == null || input.isEmpty() || input.toString().length()==1) {
                    return true;
                }
                String toLowerCaseFilter = input.toLowerCase();

                if (client.getFirstName().toLowerCase().indexOf(toLowerCaseFilter) != -1 ) {
                    return true;
                } else if (client.getService().toLowerCase().indexOf(toLowerCaseFilter) != -1) {
                    return true;
                }
                else if (String.valueOf(client.getOther()).indexOf(toLowerCaseFilter)!=-1)
                    return true;
                else
                    return false;
            });

        });

        SortedList<Client> output = new SortedList<>(listFiltred);
        output.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(output);
    }

}