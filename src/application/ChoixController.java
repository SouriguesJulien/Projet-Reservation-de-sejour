package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChoixController {
    @FXML
    void VoirProfil(ActionEvent event) {

        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/application/Profil.fxml"));
            Scene scene = new Scene(root,1220,740);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Profil");
            stage.setResizable(true);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void VoirSejours(ActionEvent event) {
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/application/Sejours.fxml"));
            Scene scene = new Scene(root,1220,740);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Profil");
            stage.setResizable(true);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }


}