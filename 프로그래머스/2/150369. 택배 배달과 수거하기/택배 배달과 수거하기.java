// i번째 집은 물류 창고에서 i만큼 떨어져 있다.
// 트럭에는 상자를 cap 개 실을 수 있다.
// 트럭은 배달하면서, 빈 재활용 상자들을 수거하고 창고에 내린다. 
// 각 집마다 배달할 택배 상자 개수랑 수거할 상자 개수 알고 있다.
// 모든 배달과 수거를 마치고 돌아오는 최소 이동 거리를 구하려고 함.

// 각 집에 배달 및 수거할 때, 원하는 개수만큼 택배를 배달 및 수거할 수 있습니다.

// 트럭에 실을 수 있는 재활용 택배 상자의 최대 개수 : cap
// 배달할 집의 개수 : n (최대 100 000)
// deliveries : 배달할 집, 택배 개수, 길이는 n
// pickups : 수거할 빈상자 개수, 길이는 n

// return : 최소 이동 거리

// 초반에 먼 곳으로 배달을 먼저 가고, 먼쪽의 상자를 수거하는 방향으로 가야 할 것 같다.
// 그리디? 가장 먼쪽 집 먼저 처리하기
// 배송이 남거나, 픽업이 남으면 트럭은 무조건 출발을 해야함. (이동거리*2)

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int dRemain = 0;
        int pRemain = 0;
        
        // 끌에서부터 배달 및 수거 진행 (먼집 먼저 해결하기)
        for(int i=n-1;i>= 0;i--) {
            // 현 위치의 남은 배달 및 픽업량 
                dRemain += deliveries[i]; // 만약 3번째 집 물량이 2  | 2번째 집 물량은 3
                pRemain += pickups[i]; // 수거량이 1 | 2번째 집 수거량은 4
            
            // 처리하려면 얼마나 왔다갔다 해야 하는가?
            while(dRemain>0 || pRemain>0) {
                dRemain -= cap;  // cap이 5라면, -3
                pRemain -= cap;  // cap이 5라면, -4
                answer += (i+1)*2L; 
            }
            
        }
        
        return answer;
    }
}