// 회원을 대상으로 매일 한가지를 할인
// 하루에 할인제품 한개만 구매 가능
// 원하는 제품과 수량이 할인하는 날짜와 10일 연속 일치하는 경우 맞춰서 회원가입

// want, number의 길이는 10이하
// discount의 길이 10 0000 

// 엉엉 어렵다
// 1. want - number 해시맵 만들기
// 2. discount를 돌면서.. 10 크기 만큼 해시맵 만들기
//    해시맵이 같은지 확인하기

import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 1. want - number 해시맵 만들기
        HashMap<String,Integer> wantMap = new HashMap<>();
        for(int i=0;i<want.length;i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i=0;i<discount.length-9;i++){
            HashMap<String,Integer> discountMap = new HashMap<>();
            for(int j=i;j<i+10;j++){
                if(wantMap.containsKey(discount[j])){
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j],0)+1);
                }
            }
            if(discountMap.equals(wantMap)) answer++;
            
        }
        
        return answer;
    }
}