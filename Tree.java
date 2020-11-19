/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import java.util.ArrayList;
import javafx.scene.shape.Circle;
/**
 *
 * @author sam
 */
//implements BST functionality
class node{
    public int key;  
    public node left;
    public node right;
}
public class Tree {
    
    public node root; 
    public int height;
    public int noOfNodes;
    //functions to be implemented

    //default constructor
    Tree()
    {
        //initialize, root, height, no of nodes of tree
        //code here
    }
    //constructor with arraylist of nodes
    Tree (ArrayList<Integer> lst)
    {
        //code here
    }
    //insert an element in BST
    void insert(int element)
    {
        node n = root;
        // code here
        if(root == null)
            root.key = element;  
        else
        {
            if (element < n.key) 
                 n = n.left;
            else if (element > n.key) 
                n = n.right;
        }
        n.key = element;
    }
    //searching an element
    boolean search(int element)
    {
        // code here
        //return true or false
        return true;
    }
    //deleting an element
    void delete(int element)
    {
        // code here
    }
    //preorder traversal
    ArrayList<Integer> preorder()
    {
         // code here
        return null;
    }
    //postorder traversal
    ArrayList<Integer> postorder()
    {
         // code here
        return null;
    }
    //inorder traversal
    ArrayList<Integer> inorder()
    {
         // code here
        return null;
    }
    //clear the tree 
    void clear()
    {
         // code here
    }
    //is empty
    boolean isEmpty()
    {
         // code here
        return true;
    }
    
}
