//prices의 길이가 최대 100 000이라서 단순 for 문 x
// Stack -> 떨어지지 않은 시점들 저장
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            // 만약에 떨어지는 시점이라면
            while(!stack.isEmpty()&&prices[stack.peek()]>prices[i]){
                int preIdx = stack.pop();
                answer[preIdx] = i-preIdx;
                
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len-idx-1;
            
        }
        return answer;
    }
}