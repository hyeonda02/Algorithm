// 1~N 노드 존재, 노드는 양방향 가중치 간선
// 1번 노드로 도착해야 함. 가중치가 K시간 이하여야 이동 가능

// 1<=N<=50
// 가중치 1~2000
// road (a,b,c) 노드 a,b는 가중치 c로 연결되어 있다.


// 노드 사이에 가중치가 다른 간선이 여러개 일 수 있음. -> 간선 가중치는 최소값으로 갱신 해서 하나를 유지
// 다익스트라 활용

import java.util.Arrays;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        final int INF = 1_000_000_000;
        
        // * 노드의 개수가 1~50 사이의 자연수이기 때문에, 인접 행렬로 구현, 자기자신은 0, 나머지는 큰 값으로 지정
        int[][] graph = new int[N+1][N+1];
        for(int i=0;i<N+1;i++){
            Arrays.fill(graph[i],INF);
            graph[i][i] = 0;
        }
        // road에 있는 그래프 정보를 가지고, 행렬 채우기
        for(int i=0;i<road.length;i++){
            int startNode = road[i][0];
            int endNode = road[i][1];
            int weight = road[i][2];
            
            // 양방향이라 두개다 가중치값 채우기, 이때 가중치 값이 원래 있으면 더 작은걸로 채우기
            graph[startNode][endNode] = Math.min(graph[startNode][endNode], weight);
            graph[endNode][startNode] = Math.min(graph[endNode][startNode],weight);
        }
        
        // 최소 경로 찾기
        // 다익스트라 활용 (시작점 1에서 여러곳으로 가야하는 거리를 알아야됨)
        int[] dist= new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[1] = 0;
        
        for(int i=0;i<N;i++){
            // 아직 방문 안한 노드 && 거리가 짧은 노드 선택
            int nextNode = -1;
            int best = INF;
            for(int v=1;v<N+1;v++){
                if(!visited[v]&&dist[v]<best) {
                    best = dist[v];
                    nextNode = v;
                }
            }
            // 전부 방문했을 경우 멈추기, 아니면 방문 처리
            if(nextNode==-1) break; 
            visited[nextNode] = true;
            
            // 해당 노드에서 갈 수 있는 곳 찾아보기 & 노드 거리가 짧을 경우 갱신
            for(int v=1;v<N+1;v++){
                if(graph[nextNode][v]==INF) continue;
                if(dist[v]>dist[nextNode]+graph[nextNode][v]){
                    dist[v] = dist[nextNode]+graph[nextNode][v];
                }
                
            }
            
        }
        
        // 가중치 값이 K 이하면 도착 가능이라 보고 answer값 증가, 1에서 배달하는 경우는 무조건 통과니까 answer는 1로 시작함
        int answer =1;
        for(int i=2;i<N+1;i++){
            if(dist[i]<=K) answer++;
        }
        return answer;
    }
}