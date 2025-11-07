// 최단 경로로 이동했을때 간선의 개수가 가장 많은 노드
// 1번 노드로부터 가장 멀리 떨어진 노드가 몇개인지 return
// 사이클 허용
// 깊이가 동일한 노드가 몇개인지..

// 1. 그래프 인접 리스트로 구현
// 2. 다익스트라로 각 노드마다 걸리는 최단 경로 구함 (아니면 BFS도 가능할듯)
// 3. 가장 경로가 큰 값의 노드의 개수를 셈

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] e:edge){
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 2. 거리배열(최단 경로 계산후 저장할 배열) 초기화
        int [] distance = new int[n+1];
        Arrays.fill(distance,-1);
        // 3. BFS? 다익스트라?로 거리 구하기 
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        distance[1] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next: graph.get(now)){
                if(distance[next] == -1){
                    distance[next] = distance[now]+1;
                    q.offer(next);
                }
            }
        }
        
        // 4. 가장 멀리 있는 노드와 그 개수 구하기
        int maxDistance = 0;
        for(int d :distance){
            if(d>maxDistance) maxDistance = d;
        }
        int answer =0;
        for(int d :distance){
            if(d==maxDistance) answer++;
        }
        return answer;
        
        
    }
}