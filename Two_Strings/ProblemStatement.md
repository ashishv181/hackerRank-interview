### _Two Strings_

**Given two strings, determine if they share a common substring. A substring may be as small as one character.**

Example

- s1 = "and"
- s2 = "art"

These share a common substring "a".

**Function Description**\
Two Strings has the following paramenters:

- String s1 = a string;
- String s2 = another String;

  **Returns**\
   string either "YES" or "NO"

**Input format**\
The first line contains a single integer _p_, the number of test cases.

The following _p_ pairs of lines are as follows:

The first line contains string **s1**.\
The second line contains string **s2**.

**Constraints**

- **s1** and **s2** consists characters in the range asci[a-z]
- **1 <= p <= 10**
- **1<= |s1|, |s2| <= 10^5**

**Output Format**\
For each pair of string return "YES" or "NO"

> **Sample Input**\
> `2`\
> `hello`\
> `world`\
> `hi`\
> `world`

> **Sample Output**\
> `YES` > `NO`

**Explanation**\
We have **_p = 2_** pairs to check:

- **s1 = "hello", s2 = "world"**.The substrings **"o" and "l"** are common to both strings.\
- **s1 = "hi", s2 = "world"** share no common substrings.
