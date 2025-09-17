// 조건
// 1<=bridge_length<=10000
// 1<=weight<=10000
// 1<=truck_weights<=10000
// 2	10	[7,4,5,6] 조건에서, 배열에 들어온 순서대로 나가야됨
// 0초 00
// 1초 07
// 2초 70
// 3초 04
// 4호 45
// 5초 50
// 6초 06
// 7초 60
// 8초 00
// 따라서 총 8초
// 1. 다리의 길이만큼 0과, 대기 트럭의 첫 요소를 큐에 담음
// 2. 처음에 넣은 요소를 빼면서, 큐 안의 합과 다음 대기 트럭의 요소를 더한 값이 weight를 넘진 않는지 확인 
//    만약 안넘으면 다음 트럭 넣고, 만약 넘으면 0을 넣음
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            q.add(0);
        }
        
        int answer=0;
        int current_weight= 0;
        int index= 0;
        
        while(!q.isEmpty()){
            answer++;
            int current = q.poll();
            current_weight-=current;
            if(index>=truck_weights.length){ //대기에 트럭 없으면 스킵
                continue;
            }
            if(current_weight+truck_weights[index]<=weight){ //무게가 넘지 않으면
                q.add(truck_weights[index]);  
                current_weight+=truck_weights[index];
                index++;       
            }else{
                q.add(0);
            }
            
        }
        return answer;
    }
}