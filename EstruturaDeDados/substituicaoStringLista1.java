import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Result {
    public static String recursiveSwap(String s) {
        
        s = s.toLowerCase();
        
        if (s.length() == 0){
            
            return "";
            
        }
        if (s.charAt(0) == ' ' || s.charAt(0) == ',' || s.charAt(0) == '.'){
            
            return "" + recursiveSwap(s.substring(1));
            
        }
        if (s.length() >= 2 && s.charAt(0) == 'p' && s.charAt(1) == 'i'){
            
            return "3.14" + recursiveSwap(s.substring(2));
                        
        }
        
        return s.charAt(0) + recursiveSwap(s.substring(1));
            
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = bufferedReader.readLine();

        String resultado = Result.recursiveSwap(s);

        bufferedWriter.write(resultado);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}