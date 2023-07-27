### My Approach

**Using HashSet**

-   I iterated through all the characters of the first string and stored them in a HashSet
-   Next, I iterated through the characters of the other string and for each of the character checked if the character is present in the HashSet using *`set.contains()`*
-   If the character is present in the set, return **YES"**
-   If none of the characters present in the set, update a boolean flag and return **"NO"**.   


### HackerRank Discussion Solution

-   In the discussion solution, the approach is to first use the string **"abcdefghijklmnopqrstuvwzyx"**.
-   Iterate over this string and for each character of the string, check if that character is present in both the strings using `**s1.getIndexOf(c)**`.
-   If the character is absent it will return -1.
-   If the match occurs, return **"YES"**.

>`  public static String discussionSolution(String s1, String s2) {`\
>    `String flag = "NO";`\
>    `for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()){`\
>        `if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1)`\
>        `flag = "YES";`\
>    `}`\
>    `return flag;}`\
>`}`
