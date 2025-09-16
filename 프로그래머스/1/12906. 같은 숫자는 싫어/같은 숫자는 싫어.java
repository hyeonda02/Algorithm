// 조건
// 배열의 크기는 100 0000 이하의 자연수, 0<= 원소의 크기 <=9
// 1,1,3,3,0,1,1, -> 1,3,0,1

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            if(!stack.isEmpty()&&stack.peek()==arr[i]){
                continue;
            }else{
                stack.push(arr[i]);
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}