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
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. 2D_INTEGER_ARRAY queries
   */
  public static long arrayManipulationBest(int n, List<List<Integer>> queries) {
    int from = 0;
    int to = 0;
    int eleToAdd = 0;
    int index = 0;
    long maxEle = 0;

    long[] arr = new long[n];

    for (List<Integer> singleList : queries) {
      ++index;
      from = singleList.get(0) - 1;
      to = singleList.get(1) - 1;
      eleToAdd = singleList.get(2);

      if(index == 1) {
        maxEle = eleToAdd;
        continue;
      }





    }
    return maxEle;
  }

  public static long arrayManipulation(int n, List<List<Integer>> queries) {
    int from = 0;
    int to = 0;
    int eleToAdd = 0;
    int ind = 0;
    long maxEle = Long.MIN_VALUE;
    long[][] arr = new long[queries.size() + 1][n];

    for (List<Integer> singleList : queries) {
      ++ind;
      from = singleList.get(0) - 1;
      to = singleList.get(1) - 1;
      eleToAdd = singleList.get(2);

      for (int j = 0; j < arr[ind].length; j++) {
        arr[ind][j] = arr[ind - 1][j];
        if (j >= from && j <= to) {
          arr[ind][j] += eleToAdd;
          if (arr[ind][j] > maxEle)
            maxEle = arr[ind][j];
        }
      }
      // for (int index = from ; index <= to ; index++) {
      // arr[ind][index] += eleToAdd;
      // if(arr[ind][index] > maxEle) maxEle = arr[ind][index];
      // }
    }

    return maxEle;
  }

  public static long arrayManipulationOptimized(int n, List<List<Integer>> queries) {
    int from = 0;
    int to = 0;
    int eleToAdd = 0;
    int index = 0;
    long maxEle = 0;
    long[] arr = new long[n];

    for (List<Integer> singleList : queries) {
      ++index;
      from = singleList.get(0) - 1;
      to = singleList.get(1) - 1;
      eleToAdd = singleList.get(2);

      for (int j = 0; j < arr.length; j++) {
        if (j >= from && j <= to) {
          arr[j] += eleToAdd;
          if (arr[j] > maxEle)
            maxEle = arr[j];
        }
      }
    }
    return maxEle;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(firstMultipleInput[0]);

    int m = Integer.parseInt(firstMultipleInput[1]);

    List<List<Integer>> queries = new ArrayList<>();

    IntStream.range(0, m).forEach(i -> {
      try {
        queries.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList()));
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    long result = Result.arrayManipulation(n, queries);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
