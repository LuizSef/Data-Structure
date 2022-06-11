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

class Result {

    /*
     * Complete the 'invertString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input as parameter.
     */

    public static String invertString(String input) {
        
        if(input.length()<=1){
            return input;
        }
        
        return invertString(input.substring(1)) + input.charAt(0); 
        
        /* A funcao pega o primeiro char da string e, logo apos, chama a si mesma, em recursao, com o restante da substring.
         * Repete o mesmo passo ate o length <= 1.
         * Entao a funcao retorna a string reversa formada.
         */
        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String input = bufferedReader.readLine();

        String result = Result.invertString(input);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}