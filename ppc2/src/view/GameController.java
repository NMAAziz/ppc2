/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControlerPPC;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.ModelPPC;

/**
 * FXML Controller class
 *
 * @author NDJAMA
 */
public class GameController implements Initializable {

    /**
     * le choixBox de depart
     */
    @FXML
    private ChoiceBox coups;
    /**
     * le textfield du joueur
     */
    @FXML
    private TextField humain;
    /**
     * le textfield de l'ordi
     */
    @FXML
    private TextField ordi;
    /**
     * Le label de la fin
     */
    @FXML
    private Label labelfinal;
    private Stage stage;
    private String playerName;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        playerName();
        
        ObservableList coup = FXCollections.observableArrayList();
        coup.add("Pierre");
        coup.add("Papier");
        coup.add("Ciseau");
        
        coups.setItems(coup);
        
    }    
    
    /*
     * cette méthode permet de recuperer le nom du joueur 
     */
    private void playerName()
    {
                TextInputDialog dialog = new TextInputDialog("Type Your name");
                dialog.initOwner(ViewPPC.getPrimaryStage());
                // Get the Stage.
                stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            
                File f = new File("./photos/IconCSP.png");
            
                // Add a custom icon.
                stage.getIcons().add(new Image("file:"+f.getAbsolutePath()));
                
                dialog.setTitle("Player name:");
                dialog.setHeaderText("Before beginning to play,");
                dialog.setContentText("Please enter your name:");

                // Traditional way to get the response value.
                Optional<String> result = dialog.showAndWait();
                
                // The Java 8 way to get the response value (with lambda expression).
                result.ifPresent(name -> playerName = name);
                System.out.println("Player Name "+playerName);
    }
    
    /**
     * le control final
     */
    @FXML
    private void change()
    {
        ModelPPC joueur1 = new ModelPPC(playerName,""+coups.getValue());
          Random rand = new Random();
        ModelPPC joueur2 = new ModelPPC("Ordinateur",ModelPPC.getLcouts().get(rand.nextInt(ModelPPC.getLcouts().size())));
        ControlerPPC control = new ControlerPPC();
        String result = control.control(joueur1,joueur2);
        
        if(result.equals("null"))
        {
            labelfinal.setText("Match Nul");
        }
        else
        {
            labelfinal.setText(result+" a gagné");
        }
        labelfinal.setVisible(true);
    }
}
