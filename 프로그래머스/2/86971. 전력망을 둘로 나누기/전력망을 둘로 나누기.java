// 송전탐의 개수 N, 전선 정보 wires
// 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망을 나눔. 
// 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)을 리턴 하도록 solution 함수를 완성..
// 전력망은 하나의 트리 형태 아님 (사이클 없음)

// 모든 전선을 하나씩 끊어보기 (끊어서 절대값 계산 -> 최소값이면 값 갱신)
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 1. 그래프 구성 (인접 리스트)
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]wire : wires){
            int a = wire[0];
            int b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 2. 전선 자르기
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            // 3. 한쪽 탑 개수 세기 & 최솟값이면 갱신
            int count = bfs(graph, a, n);
            int diff = Math.abs(count-(n-count));
            answer = Math.min(answer, diff);
            
            // 4. 전선 복원
            graph.get(a).add(b);
            graph.get(b).add(a);
            
            
        }
        
        return answer;
    }
    public int bfs(List<List<Integer>> graph , int start, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : graph.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
        
    }
}

/**
* List<Integer>에는 remove가 두가지 기능을 수행
* 1. remove(int index) -> 인덱스로 지운다
* 2. remove(Object o) -> 값을 찾아서 지운다.
*/