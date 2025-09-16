// 조건
// 문자열의 길이는 100 0000이하의 자연수
// 문자열은 모두 소문자로 이루어져 있음.
import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek().equals(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty()?1:0;
    }
}