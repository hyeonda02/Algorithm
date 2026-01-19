// 문제 요구사항
// 각 질문에는 7개의 선택지가 존재
// 각 질문은 1가지 지표로 성격 유형 점수를 판단
// survay : 문제 유형 (둘 중 하나)
// choices : 선택한 답
// 각 선택지가 동점일 경우, 사전순으로 높은 답을 리턴해야됨

// 1~3, 4, 5~7 구간을 나눠서 점수를 부여해야됨
// 1-> 3 (4-1) // 4-answer
// 2-> 2 (4-2) 
// 3-> 1 (4-3)
// 5-> 1 (5-4) // answer-4
// 6-> 2 (6-4)
// 7-> 3 (7-4)

import java.util.*;


class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char alpha1 = survey[i].charAt(0);
            char alpha2 = survey[i].charAt(1);
            int answer = choices[i];

            if (answer == 4) continue;

            if (answer >= 1 && answer <= 3) {
                map.put(alpha1, map.getOrDefault(alpha1, 0) + (4 - answer));
            } else { // 5~7
                map.put(alpha2, map.getOrDefault(alpha2, 0) + (answer - 4));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(pick(map,'R','T'));
        sb.append(pick(map,'C','F'));
        sb.append(pick(map,'J','M'));
        sb.append(pick(map,'A','N'));
        
        return sb.toString();
    }
    private char pick(Map<Character, Integer> map, char a, char b){
        int num1 = map.getOrDefault(a,0);
        int num2 = map.getOrDefault(b,0);
        
        if (num1 > num2) return a;
        if (num1 < num2) return b;
        return a;
        
    }
}