/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;
import java.util.ArrayList;
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
    Node(int key){
        this.key=key;
        this.left=null;
        this.right=null;
    }
    Node(){
        this.left=null;
        this.right=null;
    }
}

public class Tree {
    
    public static Node root; 
    public int height;
    public int noOfNodes;
    //functions to be implemented

    //default constructor
    Tree()
    {   root=null;
        
    }
    //constructor with arraylist of nodes
    //insert an element in BST
    Node insertTree(Node root, int key){
        if(root==null){
            Node leaf=new Node(key);
            root=leaf;
            return root;
        }
        else{
            if (key < root.key) 
            root.left = insertTree(root.left, key); 
                else if (key > root.key) 
            root.right = insertTree(root.right, key); 

        /* return the (unchanged) node pointer */
        return root; 
        }
    }
    int height(){
        return (treeHeight(root));
    }
    int treeHeight(Node root){
        if(root == null){
            return 0;
        }
        int left=treeHeight(root.left)
;       int right=treeHeight(root.right);
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
        height=height();
        // code here
    }
    Node searchTree(Node root,int key){
        if (root==null || root.key==key) 
        {   return root; 
            }
        if (root.key < key) 
            {
            return searchTree(root.right, key); 
            }
        return searchTree(root.left, key); 
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
 void delete(int elem){
        root=deleteTree(root,elem);
        height=height();
    }
    Node insertDel(Node root,Node leaf){
        if(root==null){
            root=leaf;
            return root;
        }
        else{
            if (leaf.key < root.key) 
            root.left = insertDel(root.left, leaf); 
                else if (leaf.key > root.key) 
            root.right = insertDel(root.right, leaf); 

        return root; 
        }
    }
    Node deleteTree(Node root,int elem){
        if(elem< root.key){
            root.left=deleteTree(root.left,elem);
        }
        else if(elem>root.key){
            root.right=deleteTree(root.right,elem);
        }
        else if(elem==root.key &&(root.left==null && root.right==null)){
 
            if(root.left==null && root.right==null){
                root=null;
            }
        }
        else if(elem==root.key &&(root.right!=null && root.left!=null)){
            root.right=insertDel(root.right,root.left);
            root=root.right;

        }
        else if(elem==root.key &&(root.right!=null && root.left==null)){
            root=root.right;
        }
        else if(elem==root.key &&(root.right==null && root.left!=null)){
            root=root.left;
        }
        return root;
    }
    ArrayList<Integer> inorder(ArrayList<Integer> p,Node root)
    {
        if (root != null) { 
            inorder(p,root.left); 
            p.add(root.key); 
            inorder(p,root.right); 
        } 
        return p;
    }
    //postorder traversal
    ArrayList<Integer> postorder(ArrayList<Integer> p,Node root)
    {
        if (root != null) { 
            postorder(p,root.left); 
            postorder(p,root.right); 
            p.add(root.key); 
            
        } 
        return p;
    }
    ArrayList<Integer> preorder(ArrayList<Integer> p,Node root)
    {
        if (root != null) { 
            p.add(root.key); 
            preorder(p,root.left); 
            preorder(p,root.right); 
        } 
        return p;
    }
    
    //clear the tree 
    void clear()
    {
         root=null;
    }
    //is empty
    boolean isEmpty()
    {   if(root == null) return true;
        return false;
    }
    
}
