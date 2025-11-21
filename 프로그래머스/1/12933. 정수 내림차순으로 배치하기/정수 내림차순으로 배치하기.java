import java.util.*;

class Solution {
    public long solution(long n) {
        String s = Long.toString(n);
        char[]array = s.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1;i>=0;i--){
            sb.append(array[i]);
        }
        String answer = sb.toString();
        return Long.parseLong(answer);
    }
}