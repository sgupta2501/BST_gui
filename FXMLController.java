/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author sam
 */

import javafx.scene.canvas.*; 

/**
 *
 * @author sam
 */
class GTree extends Canvas{
    public Tree tree;
    
    GTree()
    {
        tree=new Tree();
    }
}
public class FXMLController implements Initializable{
    
    @FXML private Text actiontarget;
    // Panels and other GUI components
    @FXML private BorderPane rootPane;
    @FXML private TextArea valueList;
    @FXML private TextArea counters;
    @FXML private TextField value;

    private GTree gtree;

	/**
	 * Constructs the GUI components and performs events for displaying and
	 * changing the data in the binary tree.
	 */
	
    /*Initializable and the method it adds are used when you want to interact with stuff injected with @FXML. 
    During construction those variables aren't filled so you cannot interact with them so JavaFX will call 
    the Initializable interface after everything is set up. At that point those variables are available and 
    can be manipulated.*/
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

            // The center panel is for drawing the tree
            gtree = new GTree();
            rootPane.setCenter(gtree);

            // Bind canvas size to stack pane size.
            gtree.widthProperty().bind(rootPane.widthProperty());
            gtree.heightProperty().bind(rootPane.heightProperty().subtract(50));
	}
    
    @FXML protected void insertButton(ActionEvent event) {
       String strV=value.getText();
       //Circle newC = new Circle(parseInt(strV));
       gtree.tree.insert(parseInt(strV));
       valueList.setText(valueList.getText()+" "+strV + "i");
    }
    @FXML protected void searchButton(ActionEvent event) {
       String strV=value.getText();
       //Circle newC = new Circle(parseInt(strV));
       gtree.tree.search(parseInt(strV));
       valueList.setText(valueList.getText()+" "+strV + "s");
    }
    @FXML protected void deleteButton(ActionEvent event) {
       String strV=value.getText();
       //Circle newC = new Circle(parseInt(strV));
       gtree.tree.delete(parseInt(strV));
       valueList.setText(valueList.getText()+" "+strV + "d");
    }
    @FXML protected void clearButton(ActionEvent event) {
       gtree.tree.clear();
       valueList.setText("");
    }
    @FXML protected void inorderButton(ActionEvent event) {
        gtree.tree.inorder();
    }
    @FXML protected void preorderButton(ActionEvent event) {
        gtree.tree.preorder();
    }
    @FXML protected void postorderButton(ActionEvent event) {
        gtree.tree.postorder();
    }
    
    
}
  