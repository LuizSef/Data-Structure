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
    
    public T elem;
    public Node<T> next;
    
    public Node(T e) {
        this.elem = e;
    }
    
    public String toString(){
        return "" + elem;
    }
}

class Lista<T>{
    
    Node<T> head;
    Node<T> aux;
    int size = 0;

    public void add(T elem){
        
        Node<T> nNode = new Node<T>(elem);

        if (head == null) {
            head = nNode;
        }
        else{
            
            Node<T> aux = head;
            while (aux.next != null){
                aux = aux.next;
                
            }
            aux.next = nNode;
        }
        size++;
    }
    
    public T getValue(int ix){
        if (ix<this.size){
            Node<T> aux = head;
            for(int i=0; i<ix; i++) aux = aux.next;
            
            return aux.elem;
        }
        return null;
    }
    
    public Lista<T> inverse(Lista<T> lst, int n){
        
        Lista<T> inverselst = new Lista<T>();
        
        if (n > lst.size){
            return lst;
        } 
        
        if (n < 0) {
            for (int ix = lst.size-1; ix>-1; ix--){
                inverselst.add(lst.getValue(ix));
            }
            return inverselst;
        }
        
        for(int ix=0; ix<n; ix++){
            inverselst.add(lst.getValue(ix));
        }
        for(int ix=lst.size-1; ix>n-1; ix--){
            inverselst.add(lst.getValue(ix));
        }
        return inverselst;
        
    }
    
    public String toString(){
        
        String str = "Lista:[";
        Node<T> aux = head;
        while (aux != null){
            str += aux.elem + ", ";
            aux = aux.next;
        }
            str = str.substring(0,str.length()-2);
            str += "]";
        return str;
    }
}

class Result{
    public static String reverseList(String componentes, int n){
        
        Lista<String> lst = new Lista<String>();
        
        while(true){
            
            lst.add(componentes.substring(0, componentes.indexOf(" ")));
            componentes = componentes.substring(componentes.indexOf(" ")+1);

            if (componentes.indexOf(" ") == -1){
                lst.add(componentes);
                break;
            }
        }
        
        lst = lst.inverse(lst, n);
        return lst.toString();
    }  
}
    
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String componentes = bufferedReader.readLine();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.reverseList(componentes, n);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}