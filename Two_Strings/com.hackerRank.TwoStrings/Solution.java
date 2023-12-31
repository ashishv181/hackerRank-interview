import java.io.*;
import java.util.*;

import java.util.stream.*;

class Result {

  /*
   * Complete the 'twoStrings' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   * 1. STRING s1
   * 2. STRING s2
   */

  public static String twoStrings(String s1, String s2) {
    Set<Character> strSet = new HashSet<>();
    boolean contains = false;

    for (int i = 0; i < s1.length(); i++) {
      Character c = s1.charAt(i);
      strSet.add(c);
    }

    for (int i = 0; i < s2.length(); i++) {
      Character c = s2.charAt(i);
      if (strSet.contains(c)) {
        contains = true;
        break;
      }
    }

    if (contains) {
      return "YES";
    }
    return "NO";
  }

  public static String discussionSolution(String s1, String s2) {
    String flag = "NO";
    for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
        if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1)
        flag = "YES";
    }
    return flag;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int q = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, q).forEach(qItr -> {
      try {
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        String result = Result.twoStrings(s1, s2);
        // String result2 = Result.discussionSolution(s1, s2);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
    bufferedWriter.close();

  }
}
