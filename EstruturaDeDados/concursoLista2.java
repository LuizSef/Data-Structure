import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    
    public String elem;
    public Node next;
    
    public Node(String e) {
        this.elem = e;
    }
    
    public String toString(){
        return "" + elem;
    }
}

class CustomList{
    
    Node head;
    Node aux;
    int size = 0;
    
    public CustomList(){
        
    }

    public CustomList(String lst){
        
        while(true){
            add(lst.substring(0, lst.indexOf(";")));
            lst = lst.substring(lst.indexOf(";")+1);

            if(lst.indexOf(";") == -1){
                add(lst);
                break;
            }
        }        
    }       

    public void add(String elem){
        
        Node nNode = new Node(elem);

        if (head == null) {
            head = nNode;
        }
        else{
            Node aux = head;
            while (aux.next != null){
                aux = aux.next;
            }
            aux.next = nNode;
        }
        size++;
    }

    public int getMaxValue(){
        
        int max = 0;
        
        Node aux = head;
        max = Integer.parseInt(head.elem);

        for(int i=0; i<size; i++){
            aux = aux.next;
            if(Integer.parseInt(aux.elem) > max) max = Integer.parseInt(aux.elem);
        }
        return max;
    }

    public void removeMax(String elemento){
        
        if (head != null){
            if (elemento.equals(head.elem)){
                
                head = head.next;
                size--;
            }else{
                Node aux = head;
                while (aux.next != null){
                    if (aux.next.elem.equals(elemento)){
                        
                        aux.next = aux.next.next;
                        size--;
                        break;
                    }else{
                        aux = aux.next;
                    }
                }
            }
        }
    }
    
    public String toString(){
        
        String str = "";
        Node aux = head;
        while (aux != null){
            str += aux.elem + ";";
            aux = aux.next;
        }
            str = str.substring(0,str.length()-1);
        return str;
    }
}

class Result {
    public static String aprovados(CustomList resultados, int numeroDeVagas, int notaMinima) {
        
        CustomList list = new CustomList();

        for(int i=0; i<numeroDeVagas; i++){
            int max = resultados.getMaxValue();
            if(max > notaMinima){
                list.add(Integer.toString(max));
                resultados.removeMax(Integer.toString(max));
            }
        }

        return list.toString();
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        CustomList resultados = new CustomList(bufferedReader.readLine());
        String result = Result.aprovados(
            resultados,
            Integer.parseInt(bufferedReader.readLine()),
            Integer.parseInt(bufferedReader.readLine())
        );
        bufferedWriter.write(result);
        bufferedReader.close();
        bufferedWriter.close();
    }
}