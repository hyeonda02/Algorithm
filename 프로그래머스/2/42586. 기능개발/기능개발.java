// 조건
// 진도가 100일때 서비스에 반영 가능
// 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발 될 수 있음
// 근데 배포는 앞에 있는거랑 같이 배포
// 배열의 크기는 100 이하
// 배포는 하루에 한번만 가능
// 각 배포마다 몇개의 기능이 배포되는지 return

// 의사코드 
// progresses = FIFO
// [93,30,55] 
// [7,70,45]
// [7,3,9]
// 2개 같이 나가고, 1개 나감
// [2,1]
// 여기까지만 보면 배열로 풀 수 있을 것 같기도 함.


// (아예 몇일 걸리는지 계산 후, 큐에 넣기, 아니면 계산하면서 확인?)
// 1. 각 태스크들을 수행하는데 몇일이 걸리는지 체크 후 큐에 넣기
// 2. 큐를 돌리면서, 큐가 비진 않았는지, 다음 요소가 첫번째 요소보다 작은지 체크하면서 작다면 같이 꺼내기


import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Arrays;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 작업이 100프로가 될때까지 몇일이 걸리는지 계산 후 큐에 넣기
        for(int i=0;i<progresses.length;i++){
            int task = (100 - progresses[i]);
            int day = (task + (speeds[i]-1)) / speeds[i];
            queue.addLast(day);
        }
        
        
        // 큐를 돌리면서 
        while(!queue.isEmpty()){
            int tasks = 1;
            int firstTask = queue.poll();
            // 만약 첫 요소보다 다음 요소들이 작으면 같이 꺼내기
            while(!queue.isEmpty() && firstTask>=queue.peekFirst()){
                queue.pollFirst();
                tasks++;
            }
            answer.add(tasks);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}