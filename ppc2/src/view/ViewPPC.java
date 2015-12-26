/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.net.URL;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Abdel Aziz NGOUH
 */
public class ViewPPC {
    
    /**
     * le stage qui permettra l'affichage de notre fenêtre javaFx
     */
    private static Stage primaryStage;
    /**
     * cet anchorpane va contenir le pane principal renvoyer par notre fichier FXML
     */
    private AnchorPane anchor;
    /**
     * le controleur de nos fenêtres JavaFx
     */
    public static GameController controlleur ;

    
    /**
     * le getteur de notre PrimaryStage
     * @return primaryStage
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    /**
     * cette méthode permet de lancer notre interface graphique
     * @param primaryStage 
     */
    public void start(Stage primaryStage) {
        
        ViewPPC.primaryStage = primaryStage;
        ViewPPC.primaryStage.setTitle("MORPION GAME");
        File f1 = new File("./photos/IconCSP.png");
        System.out.println("file "+f1.getAbsolutePath());
        ViewPPC.primaryStage.getIcons().add(new Image("file:/"+f1.getAbsolutePath()));
     
        
        launchApp();
        //getJeu();
    }

     /**
     * cette méthode permet d'associer au stage de notre interface la scène graphique principale
     */
    private void launchApp()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/view/game.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
            
            //loader.setController(controlleur);
            anchor = (AnchorPane)loader.load();
            //GameController.grille_anchor = anchor;
            controlleur = loader.getController();
            
            
            
            Scene scene = new Scene(anchor);
            
            primaryStage.setScene(scene);
            primaryStage.show();
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
