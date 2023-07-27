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
   * Complete the 'flippingBits' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts LONG_INTEGER n as parameter.
   */

  public static long flippingBits(long n) {
    String binaryValue = Long.toBinaryString(n);
    int addZeroes = 32 - binaryValue.length();
    StringBuilder inputBuilder = new StringBuilder();

    for (int i = 0; i < addZeroes; i++) {
      inputBuilder.append("0");
    }
    inputBuilder.append(binaryValue);
    StringBuilder outputBuilder = new StringBuilder();

    for (int i = 0; i < inputBuilder.length(); i++) {
      char ch = inputBuilder.charAt(i);
      if (ch == '0') {
        ch = '1';
      } else {
        ch = '0';
      }
      outputBuilder.append(ch);
    }

    Long convertedNumber = Long.parseLong(outputBuilder.toString(), 2);
    return convertedNumber;

  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.flippingBits(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();
  }
}
