/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import java.awt.Paint;
import java.util.ArrayList;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
/**
 *
 * @author sam
 */
//implements BST functionality
class Node{
    public int key;  
    public Node left;
    public Node right;
    public Color color;
    
    Node(int key,Color clr){
        this.key=key;
        this.left=null;
        this.right=null;
        color=clr;
    }
    Node(int key){
        this.key=key;
        this.left=null;
        this.right=null;
        color=Color.LIGHTGREEN;
    }
    Node(){
        this.left=null;
        this.right=null;
    }
}

public class Tree {
    
    public Node root; 
    public int height;
    public int noOfNodes;
    //functions to be implemented

    //default constructor
    Tree()
    {   
        root=null;
        height=0;
        noOfNodes=0;
    }
    //constructor with arraylist of nodes
    //insert an element in BST
    Node insertTree(Node n, int key){
        if(n==null){
            Node leaf=new Node(key,Color.CORAL);
            n=leaf;
            return n;
        }
        else{
            if (key <= n.key) 
            n.left = insertTree(n.left, key); 
                else if (key > n.key) 
            n.right = insertTree(n.right, key); 

        /* return the (unchanged) node pointer */
        return n; 
        }
    }
    int height(){
        return (treeHeight(root));
    }
    int treeHeight(Node n){
        if(n == null){
            return 0;
        }
        int left=treeHeight(n.left);
        int right=treeHeight(n.right);
        if(left>right){
            return (left+1);
        }
        else{
            return (right+1);
        }
    }
    void insert(int element)
    {   
        root=insertTree(root,element);
        noOfNodes++;
        height=height();
    }
    Node searchTree(Node n,int key){
        if (n==null)
            return n;
        if(n.key==key){
            n.color=Color.CYAN;
            return n;    
        }
            
        if (n.key < key) 
            return searchTree(n.right, key); 
            
        return searchTree(n.left, key); 
    }
    //searching an element
    boolean search(int element)
    {
        if(searchTree(root,element)!=null)
            return true;
        else
            return false;
    }

    //deleting an element
    boolean delete(int elem){
        boolean found[]={false};
        root=deleteTree(root,elem,found);
        height=height();
        return found[0];
    }
    Node insertDel(Node n){
        Node parent=n;
        Node rt=n.right;
        Node child= rt.left;

        while (child!=null)
        {
            parent=rt;
            rt=rt.left;
            child=rt.left;
        }
        n.key=rt.key;
        parent.left=rt.right;
        return n; 
    }
    Node deleteTree(Node n,int elem, boolean [] found){
        if (n==null){
            found[0]=false;
            n= null;
        }
        else if(elem< n.key){
            n.left=deleteTree(n.left,elem, found);
        }
        else if(elem>n.key){
            n.right=deleteTree(n.right,elem, found);
        }
        else if(elem==n.key) {
            found[0]=true;
            noOfNodes--;
            if(n.left==null && n.right==null){
                n= null;
                }     
            else if(n.right!=null && n.left!=null){
                n=insertDel(n);

                }
            else if(n.right!=null && n.left==null){
                n=n.right;
                }
            else if(n.right==null && n.left!=null){
                n=n.left;
                }
            }
        return n;
    }
    ArrayList<Integer> inorder(ArrayList<Integer> p,Node n)
    {
        if (n != null) { 
            inorder(p,n.left); 
            p.add(n.key); 
            inorder(p,n.right); 
        } 
        return p;
    }
    //postorder traversal
    ArrayList<Integer> postorder(ArrayList<Integer> p,Node n)
    {
        if (n != null) { 
            postorder(p,n.left); 
            postorder(p,n.right); 
            p.add(n.key); 
            
        } 
        return p;
    }
    ArrayList<Integer> preorder(ArrayList<Integer> p,Node n)
    {
        if (n != null) { 
            p.add(n.key); 
            preorder(p,n.left); 
            preorder(p,n.right); 
        } 
        return p;
    }
    
    //clear the tree 
    void clear()
    {
        root=null;
        height = 0;
        noOfNodes = 0;
    }
    //is empty
    boolean isEmpty()
    {   if(root == null) return true;
        return false;
    }
    
}