// 경로의 부지는 NxN크기
// 각 격자극 1x1의 크기
// 설계 도면에는 각 격자의 칸은 0또는 1로 채워져 있음
// 0은 칸이 비어 있음 1은 칸이 벽으로 채워져 있음
// 직선 도로 100원 , 코너 도로 500원
// 4*100 + 500*1 = 900원
// 방향을 고려해서, BFS로 구현

// BFS에는 (x,y,dir, cost) 상태를 넣는다.
// cost[x][y][dir] 로 방향 저장 0은 위쪽, 1은 아래쪽, 2는 왼쪽, 3은 오른쪽
// x,y 좌표에서 dir 방향으로 도착했다.


import java.util.*;

class Solution {
    static class Node{
        int x;
        int y;
        int direction;
        int cost;
        public Node(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        // 그래프 초기화
        int[][][] graph = new int[board.length][board.length][4];
        int INF = Integer.MAX_VALUE;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                Arrays.fill(graph[i][j],INF);
            }
        }
        // BFS
        // 큐 정의 & 첫 시작 좌표, 방향 비용 넣기
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,-1,0));
        
        for(int i=0;i<4;i++) graph[0][0][i] = 0;
        
        while(!q.isEmpty()){
            Node current = q.poll();
            // 현재 노드 기준으로 방향 찾기
            for(int dir =0;dir<4;dir++){
                // 현재 좌표를 기준으로 갈 수 있는 좌표 찾기
                int nx = current.x +dx[dir];
                int ny = current.y +dy[dir];
                if(nx<0||ny<0||nx>=board.length||ny>=board.length) continue;
                if(board[nx][ny]==1) continue;
                
                int newCost = current.cost + (current.direction == -1 || current.direction == dir ? 100 : 600);
                if(graph[nx][ny][dir] > newCost){
                    graph[nx][ny][dir] = newCost;
                    q.offer(new Node(nx,ny,dir, newCost));
                }
                
                
            }
            
        }
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, graph[board.length - 1][board.length - 1][i]);
        }
        return answer;
        
    }
}