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

class Node {
    
    String info;
    Node next;
    
    public Node(String info){
        this.info = info;
    }
    
}

class Queue {
    
    Node initial, end;
    
    public void enqueue(String value){
        
        Node newNode = new Node(value);
        
        if (initial == null) {
            initial = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        
        
    }
    public String dequeue(){
        
        String r = null;
        
        if (initial != null) {
            r = initial.info;
            initial = initial.next;
            
            // o garbage collector vai limpar a memoria do primeiro elemento
            if (initial == null) {
                // trata a remocao no caso de uma fila com apenas 1 elemento
                end = null;
            }
        }
        return r;
        
    }
    
    /*
    public Node consult() {
        Node r = null;
        if (initial != null) {
            r = initial.info;
        }
        return r;
    }*/
    
    public boolean isEmpty(){
        if(initial == null){
           return true;  
        }else{
            return false;
        }
        
    }
    
    public String toString(){
        
        String s = "";
        Node aux = initial;
        while (aux != null) {
            s += (" -> " + aux.info);
            aux = aux.next;
        }
        return s;
        
    }      
}

class Result {

    /*
     * Complete the 'invertQueue' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */
    
    

    public static Queue invertQueue(String input) {
        
        Queue usualQueue = new Queue();
        
        String[] string = input.split(" ");
        for(int i = string.length-1; i >= 0; i--){
            usualQueue.enqueue(string[i]);
            
        }
        
        return usualQueue;       
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
                String input = bufferedReader.readLine();
                Queue queue = Result.invertQueue(input.trim());
                String result = "";
                while(!queue.isEmpty())
                    result += queue.dequeue() + " ";
                bufferedWriter.write(result.trim());
                bufferedWriter.newLine();
            }
        }
    }
}