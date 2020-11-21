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
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.shape.Circle;
import javafx.scene.text.Text;  
import javafx.geometry.Point2D;

/**
 * FXML Controller class
 *
 * @author sam
 */

import javafx.scene.canvas.*; 
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author sam
 */
class GTree extends Canvas{
    public Tree tree;
    public String listTraversed;
    public int maxHeightAllowed;
    public Color defaultColor;

    GTree()
    {
        tree=new Tree();
        listTraversed="";
        maxHeightAllowed=6;
        defaultColor=Color.LIGHTGREEN;
    }
        //render elements of the tree on GUI
    void draw()
    {
	GraphicsContext gc = getGraphicsContext2D();
	gc.clearRect(0, 0, this.getWidth(), this.getHeight());

	// If the tree is not empty; draw the lines and circles
	if (tree.root != null) 
        {
            int ht = tree.height;
            double diameter, xMin=100, xMax, yMin=0, yMax;
            int divBy = maxHeightAllowed + 3;
            yMax= this.getHeight();
            xMax= this.getWidth()-100;
            diameter= yMax / divBy;
            Point2D center= new Point2D(((xMin + xMax) / 2), (yMin + diameter/2));//skipping first division 
            drawTree(gc, tree.root, xMin, xMax, center, diameter);
	}    
    }
    
    void drawTree(GraphicsContext gc, Node treeNode, double xMin, double xMax, Point2D center, double diameter) 
    {
        // Set the Color
        gc.setStroke(Color.BROWN);
        
        if(treeNode!=null)
        {
            // Set fill color
            gc.setFill(treeNode.color);
            gc.fillOval(center.getX()-diameter/4,center.getY()-diameter/4, diameter/2, diameter/2);    
            treeNode.color = defaultColor;
            gc.strokeText(""+treeNode.key, center.getX()-6,center.getY()+5);
            Point2D center2;
            if (treeNode.left != null) {
                    // Determine the start and end points of the line                 
                    center2 = new Point2D((xMin+center.getX())/2,(center.getY()+diameter));
                    gc.strokeLine(center.getX()-diameter/5,center.getY()+diameter/8,center2.getX(),center2.getY());

                    // Recurse left circle nodes
                    drawTree(gc, treeNode.left, xMin, center.getX(), center2, diameter);
            }

            // If right node is not null then draw a line to it
            if (treeNode.right != null) {
                    // Determine the start and end points of the line                 
                    center2 = new Point2D((center.getX()+xMax)/2,(center.getY()+diameter));
                    gc.strokeLine(center.getX()+diameter/5,center.getY()+diameter/8,center2.getX(),center2.getY());

                    // Recurse left circle nodes
                    drawTree(gc, treeNode.right, center.getX(), xMax, center2, diameter);
                    
            }
        }
    }

    void storeList(ArrayList<Integer> l, char rev)
    {
        //convert array list to string
        listTraversed = "";
        if (l.isEmpty())
            listTraversed=" Empty tree";
        else {
            if(rev == 'r')
            {
                for(int i = l.size()-1; i>=0; i--)
                {
                    listTraversed += l.get(i).toString() +"  ";
                }
            }
            else
            {
                for (Integer a:l)
                {
                    listTraversed += a.toString() +"  ";
                }   
            }
        }
    }
    
    void insert(int element)
    {
        tree.insert(element);
        draw();
    }
    //searching an element
    String search(int element)
    {
        String str;
        boolean b=tree.search(element);
        draw();
        str=element+"";
        if (b==false)
            str = str + "  Not found";
        else str=str+"  Found";
        return str;
    }
    //deleting an element
    String delete(int element)
    {
        String str;
        boolean b=tree.delete(element);
        // node not found case to be handled
        draw(); 
        str=element+"";
        if (b==false)
            str = str + "  Not found";
        else str = str + " Deleted";
        return str;
    }
    //preorder traversal
    void preorder()
    {
        ArrayList<Integer> l=new ArrayList<>();
        l= tree.preorder(l,tree.root);
        storeList(l,' ');
        draw();
    }
    //postorder traversal
    void postorder()
    {
        ArrayList<Integer> l=new ArrayList<>();
        l= tree.postorder(l,tree.root);
        storeList(l,' ');
        draw();
    }
    //inorder traversal
    void inorder(char rev)
    {
        ArrayList<Integer> l=new ArrayList<>();
        l= tree.inorder(l,tree.root);
        storeList(l,rev);
        draw();
    }
    
    //clear the tree 
    void clear()
    {
        tree.clear();//should empty the tree
        draw();
    }
  }
public class FXMLController implements Initializable{
    
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

            gtree.clear();
            valueList.setText("");
            counters.setText("Height: "+gtree.tree.height + " No. of Nodes: "+gtree.tree.noOfNodes);
            
	}
    
    @FXML protected void insertButton(ActionEvent event) {
       String strV=value.getText();
       if (strV.isBlank()){
            counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+
                    "                                  No key value given");
       }
       else {
        gtree.insert(parseInt(strV));
        valueList.setText(valueList.getText()+" "+strV + "i");
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes);

       }
    }
    @FXML protected void searchButton(ActionEvent event) {
        String strV=value.getText();
        if (strV.isBlank()){
            counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+
                    "                                  No key value given");
        }
        else {
            String str = gtree.search(parseInt(strV));
            valueList.setText(valueList.getText()+" "+strV + "s");
            counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+
                    "               "+str);
       }
    }
    @FXML protected void deleteButton(ActionEvent event) {
        String strV=value.getText();
        if (strV.isBlank()){
            counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+
                    "                                  No key value given");
        }
        else {
        String str=gtree.delete(parseInt(strV));
        valueList.setText(valueList.getText()+" "+strV + "d");
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+
                "               "+str);
        }
    }
    @FXML protected void clearButton(ActionEvent event) {
       gtree.clear();
       valueList.setText("");
       counters.setText("Height: "+gtree.tree.height + " No. of Nodes: "+gtree.tree.noOfNodes);
    }
    @FXML protected void inorderButton(ActionEvent event) {
        gtree.inorder(' ');
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+"          "+"Inorder Traversal:   "+
                gtree.listTraversed);
    }
    @FXML protected void preorderButton(ActionEvent event) {
        gtree.preorder();
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+"          "+"Preorder Traversal:   "+
                gtree.listTraversed);
    }
    @FXML protected void postorderButton(ActionEvent event) {
        gtree.postorder();
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+"          "+"Postorder Traversal:   "+
                gtree.listTraversed);
    }
    @FXML protected void sortASCButton(ActionEvent event) {
        gtree.inorder(' ');
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+"          "+"Sorted List Ascending:   "+
                gtree.listTraversed);
    }
    @FXML protected void sortDESCButton(ActionEvent event) {
        gtree.inorder('r');
        counters.setText("Height: "+gtree.tree.height + "  No. of Nodes: "+gtree.tree.noOfNodes+"          "+"Sorted List Descending:   "+
                gtree.listTraversed);
    }
}
  