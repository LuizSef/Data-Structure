import java.io.*;
import java.util.*;

class Node {
    
    public int elements;
    Node next;
    
    public Node(int elements){
        this.elements = elements;
        this.next = null;
    }
    
}

class CustomList {
    Node head = null;
    Node tail = null;
    Node temporary = null;
    int size = 0;

    public CustomList(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)!=' ') add(Integer.parseInt(str.valueOf(str.charAt(i))));
        }
    }
    
    public CustomList(CustomList x, CustomList y){
        for(int i=0; i<x.size; i++){
            this.add(x.remove());
        }
        for(int i=0; i<y.size; i++){
            this.add(y.remove());
        }
    }
    
    public void add(int n){
        Node novo = new Node(n);
        size = size + 1;
        
        if(head == null){
            head = novo;
        }else{
            temporary = head; 
            while(temporary.next != null){
                temporary = temporary.next;
            }
            temporary.next = new Node(n);
            sort(temporary.next);
        }     
    }
    
    public int remove() {
        
        int elem = temporary.next.elements;
        
        if (tail == temporary.next) tail = temporary; 
        
        temporary.next = temporary.next.next; 
        size--; 
        return elem;
    }
    
    public void ordered(){
        sort(head);
    }
    
    public Node sort(Node List){
        // bubble sort
        Node temporary = head;
        Node index = null;
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
    
    public  String toString() {
        Node temporary = head;
        String lista = "";
        while (temporary != null) {
            lista += temporary.elements + " ";
            temporary = temporary.next;
        }
        return '"'+lista+'"';
    }
    
}

class Result {
    public static String merge(CustomList x, CustomList y) {
        CustomList list = new CustomList(x, y);

        list.ordered();
        return list.toString();
}


public static class Solution {

    public static void main(String[] args) throws IOException {
        // scanner instance
        Scanner scan = new Scanner(System.in);

        // read input as string
        String x = scan.nextLine();
        String y = scan.nextLine();

        // create lists
        CustomList x2 = new CustomList(x);
        CustomList y2 = new CustomList(y);

        // resolution function
        String result = Result.merge(x2, y2);

        // print output
        System.out.println(result);
    }
}
}