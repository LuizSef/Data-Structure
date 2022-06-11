import java.io.*;
import java.util.*;

class Node {
    
    String info;
    Node next;
    
    public Node(String info){
        this.info = info;
    }
    
}
class CustomStack {
    
    private Node top;
    private int qnt;
    
    public void push(String e) {
        Node newS = new Node(e);
        if (top == null) {
            top = newS;
        } else {
            newS.next = top;
            top = newS;
        }
        qnt++;
    }
        
    public Node pop() {
        Node r = null;
        if (top != null) {
            r.info = top.info;
            top = top.next;
            qnt--;
        }
        return r;
    }
    
    public String peek() {
        String r = null;
        if(top != null){
            r = top.info;
        }
        return r;
    }
    
        
    public Node top() {
        Node r = null;
        if (top != null) {
            r = top;
        }
        return r;
    }
    
    public int size() {
        return qnt;
    }
    
}
class Result{
      
    private CustomStack auxStack1 = new CustomStack();
    private CustomStack auxStack2 = new CustomStack();
    private CustomStack auxStack3 = new CustomStack();
    private String aux1 = "";
    private String aux2 = "";
    Node top;
    
      public void empilhar(String tipoDoMaterial){
        
        if(auxStack1.top()==null){
                auxStack1.push(tipoDoMaterial);
                aux1 = tipoDoMaterial;
          }else if(tipoDoMaterial.equalsIgnoreCase("Tijolo") || auxStack1.peek().equalsIgnoreCase("Tijolo")){
                               
            if(aux1.equalsIgnoreCase("Tijolo")){
                auxStack1.push(tipoDoMaterial);
                aux1 = tipoDoMaterial;
            }else if(aux2.equalsIgnoreCase("Tijolo")){
                auxStack2.push(tipoDoMaterial);
                aux2 = tipoDoMaterial;
            }else{
                auxStack3.push(tipoDoMaterial);
            }
                
        }else if(tipoDoMaterial.equalsIgnoreCase("Areia") || auxStack1.peek().equalsIgnoreCase("Areia") || tipoDoMaterial.equalsIgnoreCase("Cimento") || auxStack1.peek().equalsIgnoreCase("Cimento")){ 
           
            if(aux1.equalsIgnoreCase("Cano") || aux1.equalsIgnoreCase("Valvula")){
                auxStack2.push(tipoDoMaterial);
                aux2 = tipoDoMaterial;                   
            }else{
                auxStack1.push(tipoDoMaterial); 
                aux1 = tipoDoMaterial;
            }
            
        }else if(tipoDoMaterial.equalsIgnoreCase("Cano") || auxStack1.peek().equalsIgnoreCase("Cano") || tipoDoMaterial.equalsIgnoreCase("Cano")){
            
            auxStack1.push(tipoDoMaterial);
            aux1 = tipoDoMaterial;
                
        }
        
    }
      public String toString(){
        
        Node aux1 =  auxStack1.top();
        Node aux2 =  auxStack2.top();
        Node aux3 =  auxStack3.top();  
        String s1 = "";
        String s2 = "";
        String s3 = "";
          
        if(aux1 != null){
            while (aux1 != null) {
                s1 += aux1.info + " ";
                aux1 = aux1.next;  
            } 
        }else{
            s1 = "";
        }
        if(aux2 != null){
            while (aux2 != null) {
                s2 += aux2.info + " ";
                aux2 = aux2.next;          
            } 
        }else{
            s2 = "";
        }
        if(aux3 != null){
            while (aux3 != null) {
                s3 += aux3.info + " ";
                aux3 = aux3.next;               
            }            
        }else{
            s3 = "";
        }
          
          return s1 +"\n"+ s2 +"\n"+ s3;       
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
      
        Scanner scan = new Scanner(System.in);
        Result result = new Result();
          String nextLine = "";
        while(scan.hasNextLine()) {
              nextLine = scan.nextLine();
            if(nextLine.isEmpty()) {
                break;
            }else{
                result.empilhar(nextLine);
            }
        }
        System.out.println(result);
    }
}