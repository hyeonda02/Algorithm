// 모든 판매원은 자신이 칫솔 판매에서 발생한 이익에서 10%를 계산하여 자신을 조직에 참여시킨 추천인에게 배분하고, 나머지를 가짐.
// 예시
// young = 1200*0.9=1080 추천인 120원,
// edward = 120*0.9 = 108원
// mary = 12*0.9 = 11원, 추천인 1원
// center = 1원

//enroll -> 판매원의 이름을 담은 배열
//referral -> 각 판매원을 다단계 조직에 참여시킨 이름을 담은 배열, enroll의 길이 == referral의 길이
//판매량 집계 데이터의 판매원 이름을 나열한 배열 seller,
//판매량 집계 데이터의 판매 수량을 나열한 배열 amount
import java.util.HashMap;
import java.util.Arrays;


class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String,Integer> tree = new HashMap<String,Integer>();
        
        for(int i=0;i<enroll.length;i++){
            tree.put(enroll[i],i);
        }
        // 시간 초과 해결하려고, 부모 인덱스의 정보를 담은 배열 정의
        int parent[] = new int[enroll.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < enroll.length; i++) {
            if (!referral[i].equals("-")) parent[i] = tree.get(referral[i]);
        }
        
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            int cur = tree.get(seller[i]);
            int cash = amount[i] * 100;

            while (cur != -1 && cash > 0) {
                int up = cash / 10;
                answer[cur] += cash - up;
                cur = parent[cur];
                cash = up;
            }
        }
        return answer;
    }
}