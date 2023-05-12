package application;

import java.awt.image.BufferedImage;
import java.io.File;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



import javax.imageio.ImageIO;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfilController {

    @FXML
    private Button ChangerPhoto;

    @FXML
    private Button EnregistrerModifs;

    @FXML
    private ImageView Photo;

    @FXML
    private Button btnRetour;

    private FileChooser fileChooser ;
    private File filePath;





    @FXML
    void ActionEnregistrerModifs(ActionEvent event) {

    }

    @FXML
    void ActionRetourVuePrecedente(ActionEvent event) {
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("/Vue/FenetreChoix.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Choix");
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * Cette methode permet de changer la photo de profile d'un utiliseur
     */

    public void chooseImageButtonPushed(ActionEvent event)
    {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();

        //Set the user's directory
        String userDirectoryString = System.getProperty("user.home") + "/Documents/Ceri/M1_S2/Prototype_interface/Prototypage_JavaFx/images";
        File userDirectory = new File(userDirectoryString);

        if(!userDirectory.canRead())
            userDirectory = new File("/home");
        fileChooser.setInitialDirectory(userDirectory);

        this.filePath = fileChooser.showOpenDialog(stage);

        try {
            BufferedImage bufferedImage = ImageIO.read(filePath);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);

            Photo.setImage(image);


        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

    }











}