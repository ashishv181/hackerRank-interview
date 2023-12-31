// 22-01-2023
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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int posCount = 0;
        int negCount = 0;
        int zeroCount = 0;

        for(int i : arr){
            if(i > 0){
                posCount++;
            }else if(i < 0){
                negCount++;
            }else if(i == 0){
                zeroCount++;
            }
        }
        System.out.printf("%1.6f%n%1.6f%n%1.6f%n",((float)posCount/arr.size()),((float)negCount/arr.size()),((float)zeroCount/arr.size()));
    }

}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
