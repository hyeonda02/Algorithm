import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] alphabetArr = my_string.toCharArray();
        for(int i=0;i<alphabetArr.length;i++){
            char target = alphabetArr[i];
            if(Character.isDigit(target)) answer+=target-'0';
            
        }
        return answer;
    }
}