import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Node<T>{
    T element;
    Node<T> left, right;
    
    public Node(T e){
        this.element = e;
    }
}

class BinaryTree<T>{
    private Node<T> raiz;
    private int qnt=0;
    
    private int compare(T t1, T t2) {
        int r = -1;
        if (t1 instanceof Comparable) {
            r = ((Comparable)t1).compareTo(t2);
        }
        return r;
    }
    
    public void add(T newN) {
        Node<T> newNode = new Node<T>(newN);
        if (raiz == null) {
            raiz = newNode;
            qnt++;
        } else {
            Node<T> p = raiz;
            while (p != null) {
                int c = compare(newN, p.element);
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
    
    public int auxHeight(int auxLeft, int auxRight){
        if(auxLeft >= auxRight){
            return auxLeft;
        }else return auxRight;
    }
    
    public int calculateHeight(Node<T> height){
        
        int auxLeft = 0, auxRight = 0;
        
        if(height == null){
            return 0;
        }else{
            if(height.left == null && height.right == null){
                return 1;
            }else{
                return auxHeight(calculateHeight(height.left), calculateHeight(height.right)) + 1;                
            }      
        }
        
    }
    
    public int getHeight(){
        return calculateHeight(raiz)-1;
    }
    
}

class Result {
    public static int treeHeight(String inputValues) {
        
        BinaryTree<Integer> three = new BinaryTree();
        
        for(String threeValues : inputValues.split(" ")){
            three.add(Integer.parseInt(threeValues));
        }     
        return three.getHeight();
    }
        
}
    
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String inputValues = bufferedReader.readLine();
        int result = Result.treeHeight(inputValues);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}