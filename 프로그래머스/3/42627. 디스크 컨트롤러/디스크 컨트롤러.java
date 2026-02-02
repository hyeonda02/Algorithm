// 대기 큐 -> 작업 번호, 요청 시각, 소요 시간 저장 (처음엔 비어있다.)
// 디스크 controller -> 하드 디스크 작업x, 대기큐 o -> 대기큐에서 꺼내서 작업 실행

// 작업은 소요시간이 짧은 것, 요청 시각 빠른순, 작업 번호 작은 순으로 우선순위 높다.
// 디스크는 한번에 하나의 작업만 수행
// 디스크는 종료 시 바로 시작 가능

// 모든 요청 작업의 반환 시간의 평균의 정수부분을 리턴
import java.util.*;

class Solution {
    class Job{
        int num;
        int startTime;
        int workTime;
        public Job(int num, int startTime, int workTime){
            this.num = num;
            this.startTime = startTime;
            this.workTime = workTime;
            
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        // jobs[i] = i번 작업, s는 요청 시점, l은 소요 시간
        // 일단 요청 시간이 빠른게 대기 큐에 들어옴 -> 제일 먼저 들어오는 작업을 알아야됨
        // * 요청 시간을 기준으로 일단 정렬한다.. 
        // * 시간의 흐름을 표현(반복문)
        // * 정렬해둔 값들을 보고 PQ에 추가한다. PQ의 정렬 기준
        // * 반복문 내부에 반환 시간 계산 로직을 추가한다.
        
        PriorityQueue<Job> pq = new PriorityQueue<>(
            (a,b)-> {
                if (a.workTime != b.workTime) return a.workTime - b.workTime;
                if (a.startTime != b.startTime) return a.startTime - b.startTime;
                return a.num - b.num;
            }
        );
        
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        int idx = 0;
        int currentTime = 0;
        
        while(idx<jobs.length||!pq.isEmpty()) {
            // * 현재 시간까지.. 작업을 넣기
            while(idx<jobs.length&&jobs[idx][0]<=currentTime) {
                pq.offer(new Job(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            // 지금 처리 가능한 작업 있으면 꺼내서 처리하기
            if(!pq.isEmpty()){
                Job current = pq.poll();
                currentTime += current.workTime;
                // 반환 시간 계산
                answer += currentTime - current.startTime;
            
            } else { // 만약 없으면 시간 점프해야됨 (요청 시간은 위에서 정렬)
                currentTime = jobs[idx][0]; 
            }
            
        }     
        
        return answer / jobs.length;
    }
}