// 조건
// 원하는 카드 뭉치에서 카드를 순서대로 한개씩 사용함. (재사용 안됨, 무조건 사용해야됨, 기존 순서 못바꿈)
// 문자열 배열 2개에서 원하는 문자열 만들 수 있으면 Yes, 아니면 No 
// 문자열 배열의 크기는 각각 최대 10 서로 다른 단어들만 존재
// 원하는 문자열의 크기는 두개의 문자열 안에 단어를 더한 것보다 작을 수 있음

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(int i=0;i<goal.length;i++){
            String word1 = queue1.peek();
            String word2 = queue2.peek();
            if(goal[i].equals(word1)){
                queue1.poll();
            }else if(goal[i].equals(word2)){
                queue2.poll();
            }else{
                return "No";   
            } 
        }
        return "Yes";
        
    }
}