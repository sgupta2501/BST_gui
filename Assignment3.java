package assignment3;

import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.stage.Stage;

/**
 *
 * @author sam
 */

public class Assignment3 extends Application 
{
    public void start(Stage primaryStage) throws IOException 
    {        
        // Create a pane     
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));      
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setTitle("BST GUI (JAVAFX Assignment 3)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }   
}
