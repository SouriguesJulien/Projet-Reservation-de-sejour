package com.example.projetreservationsejours.controlleur;

import com.example.projetreservationsejours.Application;
import com.example.projetreservationsejours.modele.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;

public class ShoppingCardTemplateControlleur {

    Application application;

    @FXML
    private ImageView image;

    @FXML
    private ImageView delete;


    @FXML
    private Text dateFin;





    @FXML
    private Text prix;


    @FXML
    private Pane pane;

    public void setUserChoice() throws IOException {


        AllUser users = new AllUser();
        users.loadData("utilisateurs.csv");


        image.setFitWidth(400);
        image.setFitHeight(400);
        image.setPreserveRatio(false);
        BorderPane borderPane = new BorderPane(image);
        borderPane.setStyle("-fx-border-color: #FECEA8; -fx-border-radius: 10; -fx-border-width: 2;");
        Rectangle clipRect = new Rectangle(400,400);
        clipRect.setArcWidth(12);
        clipRect.setArcHeight(12);
        image.setClip(clipRect);
        borderPane.setCenter(image);
        borderPane.setPrefSize(400, 400);
        pane.getChildren().add(borderPane);

        image.setOnMouseClicked((MouseEvent event) -> {
            // Load the card details FXML file
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CardDetails.fxml"));
                Parent root = fxmlLoader.load();

                CardDetailsControlleur cardDetailsController = fxmlLoader.getController();
                Scene scene = new Scene(root);
                application.fenetreControlleur.getStagePrincipale().centerOnScreen();
                application.fenetreControlleur.getStagePrincipale().setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    void eraseChoice(MouseEvent event) {
        application.fenetreControlleur.showNotification("Supprimer","Suppression en cours..",2000,"success");
    }

}
