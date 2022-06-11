import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Node<T> {
    T element;
    Node<T> left, right;
    
    public Node(T element){
        this.element = element;
    }   
}

class BinaryTree<T>{
    public Node<T> raiz;
    private int qnt=0;
    private Node<T> a, b;
    
    private int compare(T t1, T t2) {
        int r = -1;
        if (t1 instanceof Comparable) {
            r = ((Comparable)t1).compareTo(t2);
        }
        return r;
    }
    
    public void add(T e) {
    	Node<T> newNode = new Node<T>(e);
        if (raiz == null) {
            raiz = newNode;
            qnt++;
        } else {
            Node<T> p = raiz;
            while (p != null) {
                int c = compare(e, p.element);
                if (c==0) {
                    break; // evita elementos repetidos
                } else if (c < 0) {
                    if (p.left != null) {
                        p = p.left;
                    } else {
                        p.left = newNode;
                        qnt++;
                        break;
                    }
                } else {
                    if (p.right != null) {
                        p = p.right;
                    } else {
                        p.right = newNode;
                        qnt++;
                        break;
                    }
                }
            }
        }
    }
    
    public boolean exist(T searchElement) {
        boolean r = false;
        Node<T> p = raiz;
        while (p != null) {
            int c = compare(searchElement, p.element);
            if (c==0) {
                r = true;
                break;
            } else if (c < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return r;
    }
    
    public boolean checkMirrored(Node<T> a, Node<T> b){
        
        if(a == null && b == null){ // basic case
            return true;
        }
        if(a == null || b == null){
            return false;
        }else{
            return a.element == b.element
                && checkMirrored(a.left, b.left)// left side with left side and right side with right side.
                && checkMirrored(a.right, b.right); // because the tree will be constructed at the same order.
        }
        
    }
       
}

class Answer{
	public static String readInfo(String treeA,String treeB){
	    
        BinaryTree<Integer> auxTreeA = new BinaryTree<Integer>();
        BinaryTree<Integer> auxTreeB = new BinaryTree<Integer>();
        
        for(String threeValuesOne : treeA.split(" ")){
            auxTreeA.add(Integer.parseInt(threeValuesOne));
        }
        for(String threeValuesTwo : treeB.split(" ")){
            auxTreeB.add(Integer.parseInt(threeValuesTwo));
        }
            
         
        if(auxTreeA.checkMirrored(auxTreeA.raiz, auxTreeB.raiz) == true){
            return "E espelhada";
        }else return "Nao e espelhada";        
    	
    }
}


public class Solution {
    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
          System.out.println( Answer.readInfo( scan.nextLine(), scan.nextLine() ) );
        }
    }
}