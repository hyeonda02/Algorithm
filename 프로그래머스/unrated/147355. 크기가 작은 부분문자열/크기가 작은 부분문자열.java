import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int count = t.length()-p.length();
        Long stand = Long.parseLong(p);
        int answer=0;
        
        for(int i=0;i<=count;i++){
            Long num = Long.parseLong(t.substring(i,i+p.length()));
            if(num<=stand) answer++;
        }
        return answer;
    }
}