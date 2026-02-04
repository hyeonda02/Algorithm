import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        char[] charArr = answer.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }
}