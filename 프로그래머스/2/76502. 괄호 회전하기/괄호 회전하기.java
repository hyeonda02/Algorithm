// 조건
// s의 길이 = 1이상 1000이하 (길이가 1000이라면 0~999칸 만큼 회전)

// 의사코드
// 1. 괄호 정보를 저장, (괄호의 짝에 대한 정보를 저장한다.)
// 2. 문자열의 경우 합쳐서 사용 (2번 나오도록)
// 3. 확인할 문자열의 시작 인덱스를 0부터 n까지 이동
// 4. i(시작 위치) 부터 문자열의 길이개까지 올바른 괄호 문자열인지 확인
// 5. 올바른 괄호의 위치를 리턴

import java.util.Stack;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        // 1.
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','('); map.put('}','{'); map.put(']','[');
        
        int len = s.length();
        s+=s;
        int answer =0;
        
        A:for(int i=0;i<len;i++){
            Stack<Character> stack = new Stack<>();
            for(int j=i;j<i+len;j++){
                char c = s.charAt(j);
                // 열린 괄호
                if(!map.containsKey(c)){
                    stack.push(c);
                // 닫힌 괄호
                }else{
                    if(stack.isEmpty()||!stack.pop().equals(map.get(c))){
                        continue A;
                    } 
                }
            }
            if(stack.isEmpty())
                answer++;
        }
        
        return answer;
    }
}