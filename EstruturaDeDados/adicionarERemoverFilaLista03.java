import java.io.*;
import java.util.*;

class Node {
    Integer info;
    Node next;
    
    public Node(Integer info){
        this.info = info;
    }
}

class CustomQueue {

	Node initial, end;
    
    public void enqueue(Integer value){
        
        Node newNode = new Node(value);
        
        if (initial == null) {
            
            initial = newNode;
            end = newNode;
            
            
        } else {
            
            end.next = newNode;
            end = newNode;
            
        }
    }

    public Integer dequeue(){
        
        Integer r = null;
        
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

    public String toString(){
        
        if (initial == null){
            return "Empty";
        }else{
            String s = "";
            Node aux = initial;
            while (aux != null) {
                s += aux.info + " ";
                aux = aux.next;
            }
        return s;
        }
        
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {

        try(Scanner scan = new Scanner(System.in)){
          CustomQueue queue = new CustomQueue();

          while(scan.hasNextLine()) {
              String nextLine = scan.nextLine();

              if(nextLine.isEmpty()) {
                  break;
              }

              Integer n = Integer.parseInt(nextLine);

              if (n < 0) {
                  queue.dequeue();
                  System.out.println("Remove: " + queue);

              } else {
                  queue.enqueue(n);
                  System.out.println("Insert: " + queue);
              }
          }
        }
    }
}