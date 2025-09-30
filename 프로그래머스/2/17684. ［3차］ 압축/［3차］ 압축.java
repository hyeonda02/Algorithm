// 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
// 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
// w에 해당하는 번호 출력. 입력에서 w를 제거한다.
// 입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c 에 해당하는 단어를 사전에 등록한다.

// 예시 )
// KAKAO
// K -> 11, KA -> 27
// A -> 1, AK -> 28
// KA -> 27,  KAO -> 29
// O -> 15
// 1<=msg<=1000

// 1. 알파벳 저장(길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.)
// 2. 문자열을 돌면서, 현 위치에서 사전에 있는 가장 긴 문자열을 찾음
//    그 문자열의 번호를 정답에 넣기
//    만약 없으면 W+C를 다음 인덱스로 등록하기

import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<String,Integer>();
        // 1. 알파벳 저장(길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.)
        for(int i=1;i<=26;i++){
            char a = (char)('A'+(i-1));
            dictionary.put(String.valueOf(a),i);
        }
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int len = msg.length();
        int start = 0;
        int nextIdx = 27;
        
        while(start<len){
            int end = start+1;
            // 사전에 있는 가장 긴 w 찾기
            while(end<=len&&dictionary.containsKey(msg.substring(start,end))){
                end++;
            }
            // 정답 번호 넣기
            String w = msg.substring(start,end-1);
            answer.add(dictionary.get(w));
            
            // 다음 글자 등록
            if(end-1<len){
                char c = msg.charAt(end - 1);
                String newc = w+c;
                if (!dictionary.containsKey(newc)) {
                    dictionary.put(newc, nextIdx++);
                }
            }
            start += w.length();
        }
        
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}