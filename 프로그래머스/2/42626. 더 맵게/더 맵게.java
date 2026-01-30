// 완성된 지수 = 가장 낮은 지수 + (그 다음으로 낮은 지수 *2)
// 만들 수 없는 경우 -1 리턴

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.offer(s);
        }
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();   // 가장 작은 값
            int second = pq.poll();  // 두 번째로 작은 값

            int newScoville = first + (second * 2);
            pq.offer(newScoville);

            answer++;
        }
        
        // 모든 음식의 스코빌 지수가 K 이상인지 확인
        if (pq.peek() < K) return -1;

        return answer;
        
    }
}