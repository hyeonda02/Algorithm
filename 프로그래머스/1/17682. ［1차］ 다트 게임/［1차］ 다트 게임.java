import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dartArr = dartResult.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for(char n : dartArr) {
            if(n=='*'){
                int num1 = stack.pop()*2;
                if(!stack.isEmpty()) {
                    int num2 = stack.pop()*2;  
                    stack.push(num2);
                }
                stack.push(num1);
                
            } else if (n=='#'){
                int num = stack.pop();
                stack.push(num*-1); 
                
            } else if (n=='S'){
                int num = stack.pop();
                stack.push((int)Math.pow(num,1));      
            } else if (n=='D'){
                int num = stack.pop();
                stack.push((int)Math.pow(num,2));
                
            } else if (n=='T'){
                int num = stack.pop();
                stack.push((int)Math.pow(num,3));
            } else {
                int num = Character.getNumericValue(n);
                if (num == 0 && !stack.isEmpty() && stack.peek() == 1) {
                    stack.pop();
                    stack.push(10);
                } else {
                    stack.push(num);
                }
                
            }
            
        }
        
        while(!stack.isEmpty()){
            answer +=stack.pop();
        }
        return answer;
        
        
    }
}