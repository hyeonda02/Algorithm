import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //int[]->Integer[]
        Integer[] scoreArr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreArr,Collections.reverseOrder());
        
        for(int i=0;i<scoreArr.length;i++){
            if((i+1)%m==0) answer +=scoreArr[i]*m; //m의 배수일 때만 해당 사과로 계산한다
        }
        
        return answer;
    }
}