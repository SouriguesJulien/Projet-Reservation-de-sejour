package com.example.projetreservationsejours.controlleur;

import com.example.projetreservationsejours.Application;

import com.example.projetreservationsejours.modele.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MainController implements Initializable {

    Application application;

    @FXML
    private Pane researchPane;

    @FXML
    private Pane headerPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox cardContainer;

    @FXML
    private DatePicker dateDebut;

    @FXML
    private DatePicker dateFin;

    @FXML
    private Button boutonConnexion;

    @FXML
    private Button bountonInscription;

    @FXML
    private ImageView home;

    @FXML
    private ImageView logout;

    @FXML
    private ImageView shopping_cart;

    @FXML
    private TextField searchTextField;

    @FXML
    private ImageView user;

    @FXML
    private Text nbLocation;

    @FXML
    private Text userName;

    @FXML
    private HBox hboxPane;

    @FXML
    private VBox container;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Button boutonRecherche;

    @FXML
    private Pane mainPane;

    @FXML
    private VBox vboxPane;



    ObservableList<String> options = FXCollections.observableArrayList("Toutes les demandes","Mes locations");

    ImageCache imageCache = new ImageCache();

    private ScheduledFuture<?> dataLoadingTask;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        changeHeaderVisibility();
        scrollPane.setStyle("-fx-background-color: #FFFFFF;");
        cardContainer.setStyle("-fx-background-color: #FFFFFF;");
        researchPane.setStyle("-fx-background-color: #FFFFFF;");
        hboxPane.setStyle("-fx-background-color: #FFFFFF;");
        container.setStyle("-fx-background-color: #FFFFFF;");
        flowPane.setStyle("-fx-background-color: #FFFFFF;");
        vboxPane.setStyle("-fx-background-color: #FFFFFF;");

        headerPane.setStyle("-fx-background-color:#1f6580");
        boutonConnexion.setStyle("-fx-background-color:#ae93c9; -fx-text-fill: #1f6580; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #1f6580; -fx-arc-width: 30");
        bountonInscription.setStyle("-fx-background-color:#ae93c9; -fx-text-fill: #1f6580; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #1f6580; -fx-arc-width: 30");
        boutonRecherche.setStyle("-fx-background-color: #1f6580; -fx-text-fill:#FFFFFF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #FFFFFF; -fx-arc-width: 30");
        dateDebut.setStyle("-fx-background-color: #FFFFFF;");
        dateDebut.getEditor().setStyle("-fx-font-size: 18px; -fx-font-family: 'Perpetua';");
        dateFin.setStyle("-fx-background-color: #FFFFFF;");
        dateFin.getEditor().setStyle("-fx-font-size: 18px; -fx-font-family: 'Perpetua';");
        searchTextField.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        // Initialisation des locations


            shopping_cart.setOnMouseClicked(event -> {
                try {
                    application.fenetreControlleur.changerDeFenetre("ShoppingCardDetails.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            user.setOnMouseClicked(event -> {
                try {
                    application.fenetreControlleur.changerDeFenetre("HostCardDetails.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }









    /**
     * For all the locations available:
     *  - check if searchTextField, dateDebut and dateFin is in the resource file
     *      -> Not null: display elements
     *      -> Null: display error
     *  - possibilities to search on field or more
     * */
    @FXML
    void searchBar(ActionEvent event) throws IOException {
        if (searchTextField.getText() != null) {

            // Cancel previous data loading task if it exists
            if (dataLoadingTask != null && !dataLoadingTask.isDone()) {
                dataLoadingTask.cancel(true);
            }

            // Schedule a new data loading task with a delay
        }
    }


    /**
     * Go back to home windows
     * */
    @FXML
    void backHome(MouseEvent event) throws IOException {
        application.fenetreControlleur.changerDeFenetre("Accueil.fxml");
    }

    @FXML
    void showPageInscription(ActionEvent event) throws IOException {
        application.fenetreControlleur.popupFenetre("PageInscription.fxml","S'inscrire");
    }

    @FXML
    void showPageConnexion(ActionEvent event) throws IOException {
        application.fenetreControlleur.popupFenetre("PageConnexion.fxml","Se connecter");
    }

    /**
     * Reset the status of the user connected
     * */
    @FXML
    void logout(MouseEvent event) throws IOException {
        application.userConnected = null;
        userName.setText("");
        changeHeaderVisibility();
        application.fenetreControlleur.changerDeFenetre("Accueil.fxml");
    }

    /**
     * If user is connected, display his personal header
     * Else display sign-in and sign-up buttons
     * */
    public void changeHeaderVisibility() {
        /*
        * Only visible when the user is connected
        * */
        home.setVisible(isUserConnected());
        shopping_cart.setVisible(isUserConnected());
        user.setVisible(isUserConnected());
        userName.setVisible(isUserConnected());
        logout.setVisible(isUserConnected());
        nbLocation.setVisible(isUserConnected());

        /*
        * Only visible when the user is disconnected
         */
        boutonConnexion.setVisible(!isUserConnected());
        bountonInscription.setVisible(!isUserConnected());
    }

    /**
     * Check if the user is connected
     * @return boolean
     * */
    public boolean isUserConnected() { return application.userConnected != null; }




}
