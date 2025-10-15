// 상대 팀 진영에 도착하기 위해 지나가야 하는 칸의 개수 최소값을 리턴
// 만약 도착할 수 없을 때는 -1 리턴
// 가까운 곳부터 방문 -> BFS
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        
        // 좌표 계산할떄 필요한 값들
        int nextX[] = {-1,1,0,0}; //왼오--
        int nextY[] = {0,0,1,-1}; //--상하
        
        // 1. 첫 시작점 초기화
        q.add(new int[]{0,0});
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            // 2. 도착점이면 종료
            if(x==n-1&& y==m-1){
                return dist[x][y];
            }
            // 3. 도착 아니면 갈 수 있는 거리 탐색
            for(int i=0;i<4;i++){
                int nX = x+nextX[i];
                int nY = y+nextY[i];
                // 범위가 안맞거나, 이미 방문한 곳이거나, 지도상 갈 수 없을 경우 생략
                if (nX < 0 || nY < 0 || nX >= n || nY >= m) continue;
                if (maps[nX][nY]==0||dist[nX][nY]!=0) continue;
                dist[nX][nY] = dist[x][y] +1; // 경로 갱신
                q.add(new int[]{nX,nY});
                
            }
        }
        
        return -1;
    }
}