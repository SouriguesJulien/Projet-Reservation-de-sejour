package com.example.projetreservationsejours.controlleur;

import com.example.projetreservationsejours.Application;
import com.example.projetreservationsejours.modele.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ShoppingCardDetailsControlleur implements Initializable {

    Application application;

    @FXML
    private Button bountonInscription;

    @FXML
    private Button boutonConnexion;

    @FXML
    private Button changeViewVoyageurMode;

    @FXML
    private ImageView home;

    @FXML
    private ImageView logout;

    @FXML
    private Text nbLocation;

    @FXML
    private ImageView shopping_cart;

    @FXML
    private ImageView user;

    @FXML
    private Text userName;

    @FXML
    private FlowPane flowPane;

    @FXML
    private HBox hboxPane;

    @FXML
    private HBox hboxPane2;

    @FXML
    private Pane headerPane;


    @FXML
    private Pane mainPane;

    @FXML
    private Pane pane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox userChoice1;

    @FXML
    private VBox vboxPane;

    @FXML
    private Button boutonValiderPanier;

    @FXML
    private ChoiceBox viewVoyageurMode;

    ObservableList<String> options = FXCollections.observableArrayList("En cours","Validées");



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        setBackground();
        changeHeaderVisibility();

        userName.setText(application.userConnected.getUsername());



        shopping_cart.setOnMouseClicked(event -> {
            application.fenetreControlleur.showNotification("Alerte", "Vous êtes déjà dans la bonne fenêtre", 2000, "warning");
        });

        user.setOnMouseClicked(event -> {
            try {
                application.fenetreControlleur.changerDeFenetre("HostCardDetails.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /*public void setUserChoiceCard(Location location) {

    }*/





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
    void logout(MouseEvent event) {
        application.userConnected = null;
        userName.setText("");
        changeHeaderVisibility();
        application.fenetreControlleur.showNotification("Deconnexion","Vous êtes désormais déconnecté",2000,"success");
        try {
            application.fenetreControlleur.changerDeFenetre("Accueil.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void setBackground(){
        flowPane.setStyle("-fx-background-color: #FFFFFF;");
        hboxPane.setStyle("-fx-background-color: #FFFFFF;");
        hboxPane2.setStyle("-fx-background-color: #FFFFFF;");
        mainPane.setStyle("-fx-background-color: #FFFFFF;");
        pane.setStyle("-fx-background-color: #FFFFFF;");
        scrollPane.setStyle("-fx-background-color: #FFFFFF;");
        userChoice1.setStyle("-fx-background-color: #FFFFFF;");
        vboxPane.setStyle("-fx-background-color: #FFFFFF;");
        headerPane.setStyle("-fx-background-color:#534362FF");
        boutonConnexion.setStyle("-fx-background-color:#534362; -fx-text-fill: #534362FF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #534362FF; -fx-arc-width: 30");
        bountonInscription.setStyle("-fx-background-color:#0d5180; -fx-text-fill: #534362FF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #0d5180; -fx-arc-width: 30");
        boutonValiderPanier.setStyle("-fx-background-color: #534362FF; -fx-text-fill:#FFFFFF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #FFFFFF; -fx-arc-width: 30");
        viewVoyageurMode.setStyle("-fx-background-color: #FFFFFF;-fx-font-size: 18px; -fx-font-family: 'Perpetua';");
        changeViewVoyageurMode.setStyle("-fx-background-color:#0d5180; -fx-text-fill: #534362FF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #534362FF; -fx-arc-width: 30");
    }
}
