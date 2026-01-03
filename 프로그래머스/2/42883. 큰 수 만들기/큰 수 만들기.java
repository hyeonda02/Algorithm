// 제거할 문자의 개수 : k
// number : 2~100 0000
// 큰 수를 number.length-k개 고르기
// 큰 수를 미리 저장해두기

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        
        // 제일 작은 수 k개를 빼야 함
        for(int i=0;i<number.length();i++){
            char num = number.charAt(i);
            while(!stack.isEmpty()&&k>0&&stack.peekLast()<num){
                stack.pollLast();
                k--;
            }
            stack.addLast(num);
        }
        while(k>0){
            stack.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char num:stack){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}