import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class No{
    
	int elements;
    No next; // Proximo no;
    public No(int elements){
        this.elements = elements;
        this.next = null;
    }
    
}	
class Lista{
    
    No head = null; // No cabeca da lista;
    No tail = null; // No cauda da lista;
      
    public void add(int n){
        
        No novo = new No(n);
           
        if(head == null){
            
            head = novo;
            tail = novo; // O No sera a cabeca e a cauda;
            
        }else{
            
            No temporary = head; // No temporario que percorre a lista;
            while(temporary.next != null){
                
                temporary = temporary.next;
                
            }
            
            temporary.next = new No(n);
            sort(temporary.next);
            
        }     
    }
    
    public No sort(No List){
        
        // bubble sort
        
        No temporary = head;
        No index = null;
        int temp;
        
        if(head == null){
            
            return head;
            
        }else{
            
            while(temporary != null){
                
                index = temporary.next;
                
                while(index != null){
                    
                    if(temporary.elements > index.elements){
                        
                        temp = temporary.elements;
                        temporary.elements = index.elements;
                        index.elements = temp;
                        
                    }  
                    
                    index = index.next;
                    
                } 
                
                temporary = temporary.next;
                
            }        
        }
        return List;       
    }
    
    public String toString(){
        
        No temporary = head;
        
        String str = "";
        
        while(temporary != null){
            str += temporary.elements + " ";
            temporary = temporary.next;
        }      
        return str;       
    }
      
}

public class Solution {
    public static void main(String[] args) throws IOException {
      	Lista lista = new Lista();
        Scanner scan = new Scanner(System.in);
      	while(scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            if(nextLine.isEmpty()) {
                break;
            }
            Integer n = Integer.parseInt(nextLine);
            lista.add(n);
        }
        String result = lista.toString();
        System.out.println(result);
    }
}