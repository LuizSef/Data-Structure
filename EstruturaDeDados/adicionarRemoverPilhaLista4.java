import java.io.*;
import java.util.*;

class Node {
    
    int info;
    Node next;
    
    public Node(int info){
        this.info = info;
    }
    
}

class CustomStack {

	private Node top;
    private int qnt;
    
    public void add(int e) {
        Node newS = new Node(e);
        if (top == null) {
            top = newS;
        } else {
            newS.next = top;
            top = newS;
        }
        qnt++;
    }
        
    public Integer remove() {
        Integer r = null;
        if (top != null) {
            r = top.info;
            top = top.next;
            qnt--;
        }
        return r;
    }
    
        
    public Integer top() {
        Integer r = null;
        if (top != null) {
            r = top.info;
        }
        return r;
    }
        

    public String display() {
	    String s = "";
        Node aux = top;
        CustomStack newStack = new CustomStack();
        if(aux == null){
            return "Empty";
        }else{
            
            while (aux != null) {
            
            newStack.add(aux.info);
            aux = aux.next;
             
            }
        
            aux = top;
        
            while(aux != null){
               
               if(aux.next != null){
                  s += "";
               }          
               s += newStack.remove() + " ";
               aux = aux.next;         
            }  
        }           
        return s;
    }
    
    public boolean isEmpty(){
        if(top == null){
           return true;  
        }else{
            return false;
        }        
    }
    
    
}

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        CustomStack stack = new CustomStack();

        while(scan.hasNextLine()) {
            String nextLine = scan.nextLine();

            if(nextLine.isEmpty()) {
                break;
            }
         
            Integer n = Integer.parseInt(nextLine);
            
            if (n < 0) {
                stack.remove();
                System.out.println("Remove: " + stack.display());

            } else {
                stack.add(n);
                System.out.println("Insert: " + stack.display());
            }
        }
    }
}