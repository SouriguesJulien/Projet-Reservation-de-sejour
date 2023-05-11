package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1000,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Profil");
			primaryStage.show();
			*/
            //AnchorPane root = (AnchorPane) FXMLLoader.load(Main.class.getResource("/application/Profil.fxml"));
            Parent root  = FXMLLoader.load(getClass().getResource("/application/FenetreChoix.fxml"));
            Scene scene = new Scene(root,517,269);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Choix");
            primaryStage.setResizable(true);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}