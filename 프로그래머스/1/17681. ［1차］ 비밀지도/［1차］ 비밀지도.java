// 두개의 지도에서 모두 공백이여야, 해당 부분은 공백
// Stack을 사용하여 이진수 변환

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    
    private void solveMap(int password, Stack<Integer> stack, int n) {
        for (int i = 0; i < n; i++) {
            stack.push(password % 2);
            password /= 2;
        }
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Stack<Integer> map1;
        Stack<Integer> map2;
        StringBuilder sb;
        
        for(int i=0;i<n;i++){
            sb = new StringBuilder();
            map1 = new Stack<>();
            map2 = new Stack<>();
            
            solveMap(arr1[i],map1,n);
            solveMap(arr2[i],map2,n);
            
            while(!map1.isEmpty()){
                int map1Num = map1.pop();
                int map2Num = map2.pop();
                
                if(map1Num==0&&map2Num==0){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
                
            }
            answer[i] = sb.toString();
            
            
        }
        return answer;
    }
}