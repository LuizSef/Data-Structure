import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Result {
  	public static Integer factorial(Integer value) {
        if(value < 2){
            return 1;
        }else{
            return value * factorial(value - 1);
        }
    }
    public static String toString(Integer inputValue, Integer result) {
        return inputValue + "! = " + result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        Integer s = Integer.parseInt(bufferedReader.readLine().trim());

        String resultado = Result.toString(s, Result.factorial(s));

        bufferedWriter.write(resultado);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}