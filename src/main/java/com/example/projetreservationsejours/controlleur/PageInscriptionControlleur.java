package com.example.projetreservationsejours.controlleur;

import com.example.projetreservationsejours.Application;
import com.example.projetreservationsejours.modele.User;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class PageInscriptionControlleur extends Preloader implements Initializable {
    Application application;

    @FXML
    private Pane pageInscriptionStage;

    @FXML
    private Button boutonInscrire;
    @FXML
    private CheckBox checkboxHote;

    @FXML
    private CheckBox checkboxVoyageur;

    @FXML
    private CheckBox chekboxTermesEtConditions;

    @FXML
    private TextField email;

    @FXML
    private PasswordField motDePasse;

    @FXML
    private TextField nom;

    @FXML
    private TextField nomUtilisateur;

    @FXML
    private TextField prenom;
    @FXML
    private Text erreurEmail;

    @FXML
    private Text erreurNom;

    @FXML
    private Text erreurNomUtilisateur;

    @FXML
    private Text erreurPassword;

    @FXML
    private Text erreurPrenom;

    @FXML
    private Text erreurCheckbox;

    @FXML
    private Text erreurCheckboxTermes;

    private User user = new User();

    @FXML
    void checkHote(ActionEvent event) {

    }

    @FXML
    void checkVoyageur(ActionEvent event) {

    }

    Boolean verifyTextFieldEmpty(TextField textfield,Text text, String error,Boolean isValid){
        if(textfield.getText().isEmpty()){
            text.setText(error +" est obligatoire");
            isValid = false;
        }
        if(textfield==email){
            String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            if(!patternMatches(textfield.getText(), regexPattern)){
                text.setText(error + " est invalide");
                isValid = false;
            }
        }
        if(textfield.getText().contains(";")){
            text.setText(error + " ne peut contenir ';'");
            isValid = false;
        }
        return  isValid;
    }
    void resetAllText(){
        erreurPrenom.setText("");
        erreurNomUtilisateur.setText("");
        erreurNom.setText("");
        erreurEmail.setText("");
        erreurPassword.setText("");
        erreurCheckbox.setText("");
        erreurCheckboxTermes.setText("");
    }

    public boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    @FXML
    void verifyInscriptionDetails(ActionEvent event) throws IOException {
        Boolean isValid = true;
        resetAllText();
        isValid = verifyTextFieldEmpty(prenom,erreurPrenom,"Le prénom",isValid);
        isValid = verifyTextFieldEmpty(nomUtilisateur,erreurNomUtilisateur,"Le nom d'utilisateur",isValid);
        isValid = verifyTextFieldEmpty(nom,erreurNom,"Le nom",isValid);
        isValid = verifyTextFieldEmpty(email,erreurEmail,"L'email",isValid);
        isValid = verifyTextFieldEmpty(motDePasse,erreurPassword,"Le mot de passe",isValid);

        if(!checkboxVoyageur.isSelected() && !checkboxHote.isSelected()){
            erreurCheckbox.setText("Veuillez choisir un mode");
            isValid = false;
        }
        if(!chekboxTermesEtConditions.isSelected()){
            erreurCheckboxTermes.setText("Veuillez accepter les termes et conditions");
            isValid = false;
        }
        if(isValid){
            for(int i=0; i<application.allUsers.getUsers().size() && isValid; i++){
               if(application.allUsers.getUsers().get(i).getUsername().equals(nomUtilisateur.getText()) || application.allUsers.getUsers().get(i).getEmail().equals(email.getText())){
                   erreurCheckboxTermes.setText("Cet utilisateur existe déjà ! ");
                   isValid= false;
               }
            }
        }
        if(isValid){

        }

    }


    @Override
    public void start(Stage stage) throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prenom.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        nom.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        nomUtilisateur.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        email.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        motDePasse.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #D3D3D3");
        pageInscriptionStage.setStyle("-fx-background-color: #FFFFFF;");
        boutonInscrire.setStyle("-fx-background-color: #0D5180; -fx-text-fill:#FFFFFF; -fx-border-radius: 30;-fx-background-radius: 30;-fx-border-color: #FFFFFF; -fx-arc-width: 30");
    }
}
