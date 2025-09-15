import java.util.Stack;

class Solution {
    public int solution(String s) {
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        for(String charNum:arr){
            if(charNum.equals("Z")){
                stack.pop();
            }else{
                stack.push(charNum);
            }
        }
        int answer =0;
        while(!stack.isEmpty()){
            answer += Integer.valueOf(stack.pop());
        }
        return answer;
    }
}