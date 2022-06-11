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


class BinaryNode<T>{
    T element;
    BinaryNode<T> left, right;
    
    public BinaryNode(T e){
        this.element = e;
    }
}

class BinaryThree<T>{
    private BinaryNode<T> raiz;
    private int qnt=0;
    
    private int compare(T t1, T t2) {
        int r = -1;
        if (t1 instanceof Comparable) {
            r = ((Comparable)t1).compareTo(t2);
        }
        return r;
    }
    
    public void add(T newN) {
        BinaryNode<T> newNode = new BinaryNode<T>(newN);
        if (raiz == null) {
            raiz = newNode;
            qnt++;
        } else {
            BinaryNode<T> p = raiz;
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
        BinaryNode<T> p = raiz;
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
    
    public int countLeaf(BinaryNode<T> leaf){
        if(leaf == null){ // basic case
            return 0;
        }else{
            if(leaf.left == null && leaf.right == null){
                return 1;
            }else{
                return countLeaf(leaf.left) + countLeaf(leaf.right); // recurssion
            }
        }
    }
    
    public int getLeaf(){
        return countLeaf(raiz);
    }

}

class Result {
    public static int numberOfLeafs(String inputValues) {
        
        BinaryThree<Integer> three = new BinaryThree();
        
        for(String threeValues : inputValues.split(" ")){
            three.add(Integer.parseInt(threeValues));
        }
        
		return three.getLeaf();
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));


        String a = bufferedReader.readLine();
        int result = Result.numberOfLeafs(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}