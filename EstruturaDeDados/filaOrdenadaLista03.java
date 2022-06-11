import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    String info;
    Node next;
    
    public Node(String info){
        this.info = info;
    }
}

class CustomQueue {

    private Node initial;
    private Node end;
    
    public void enqueue(String newS) {
        
        Node newNode = new Node(newS);
        
        if(initial == null) {
            initial = newNode;
            end = newNode;
        }else{
            end.next = newNode;
            end = newNode;
        }
        
        sort();
    }
    
    public void sort(){
        
        // bubble sort
        
        Node temporary = initial;
        Node index = null;
        String temp;
        
        if(initial == null){
            
            return;
            
        }else{
            
            while(temporary != null){
                
                index = temporary.next;
                
                while(index != null){
                    
                    if(temporary.info.compareTo(index.info)>0){ // comparar strings
                        
                        temp = temporary.info;
                        temporary.info = index.info;
                        index.info = temp;
                        
                    }  
                    
                    index = index.next;
                    
                } 
                
                temporary = temporary.next;
                
            }        
        }       
    }

    public String toString() {
        
        Node temporary = initial;
        
        String str = "";
        
        while(temporary != null){
            str += temporary.info + " ";
            temporary = temporary.next;
        }      
        return str; 
    }
}


class Result {
    public static String compileString(String s) {
        
        CustomQueue queue = new CustomQueue();
          String[] string = s.split(" ");
        for(int i = 0; i < string.length; i++){
            queue.enqueue(string[i]);
        }
        return queue.toString();
    }
}

public class Solution {

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(System.in)){
            String result = Result.compileString(scan.nextLine());
            System.out.println(result);
          };
    }
}