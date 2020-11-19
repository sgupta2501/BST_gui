/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;


import java.awt.Button;
import java.awt.Insets;
import java.io.IOException;
import javafx.scene.Group; 
import javafx.scene.text.Font; 
import javafx.scene.text.Text; 
import javafx.scene.paint.Color; 
//import java.awt.Color;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.VLineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;   


/**
 *
 * @author sam
 */

//public class Assignment3 
//{
    /**
     * @param args the command line arguments
     */
    /*public void start(Stage stage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLGraphicsPanel.fxml"));

		//Scene scene = new Scene(root);

		//stage.setScene(scene);
		stage.show();
    	}*/
//}
    
public class Assignment3 extends Application 
{
    public void start(Stage primaryStage) throws IOException 
    {        // Create a pane to hold the circle     
       
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));      
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setTitle("BST GUI (JAVAFX Assignment 3)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        launch(args);
    }   
}
