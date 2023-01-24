import java.util.*;
class Solution {
    public long solution(long n) {
        //Long 타입을 String 타입으로 변환
        String s = Long.toString(n);
        //문자열을 배열로 변환
        char[]array = s.toCharArray();
        //정렬
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1;i>=0;i--){
            sb.append(array[i]);
        }
        String answer = sb.toString();
        return Long.parseLong(answer);
    }
}