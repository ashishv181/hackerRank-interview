import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String timeConversion(String s) {
        // Write your code here
        String[] splitString = s.split("[^0-9]+");
        Integer hour = Integer.parseInt(splitString[0]);

        if (s.contains("PM")) {
            if ((hour + 12) < 24) hour += 12;
        } else {
            if ((hour + 12) == 24) hour = -1;
        }
        System.out.println(Arrays.toString(splitString));
        splitString[0] = hour == -1 ? "00" : String.valueOf(hour);

        LocalTime time = LocalTime.of(Integer.parseInt(splitString[0]),Integer.parseInt(splitString[1]));
        String theResult = time + ":" + splitString[2];
        return String.valueOf(theResult);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        while(true){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = bufferedReader.readLine();

            String result = Result.timeConversion(s);
            System.out.println(result);
        }


//        bufferedWriter.write(result);
//        bufferedWriter.newLine();


//        bufferedWriter.close();
    }
}
