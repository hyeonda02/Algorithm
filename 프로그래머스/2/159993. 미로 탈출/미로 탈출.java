// 직사각형 격자 형태의 미로에서 탈출하려고 한다.
// 각 통은 통로 또는 벽으로 구성됨. 
// 통로 중에는 문이 있음. 레버를 당겨야만 열 수 있음.
// 출발지점 -> 레보가 있는 칸으로 이동 -> 레버 당김 -> 미로를 빠져나가는 문이 있는 칸으로 이동
// 아직 레버를 당기지 않았더라도 출구가 있는 칸을 지나갈 수 있다.
// 미로에서 한 칸을 이동하는데 1초가 걸린다. 최단 시간 구해라

// 1. 레버가 있는 곳까지 가야됨. 레버를 당겨야됨.
// 2. E 지점까지 가야됨.

// * 레버를 당길 수 없거나, 종료 지점까지 갈 수 없을 경우 -> 못감 -1 반환
// * 지도 가로 세로 사이즈 같은건가?
// 마찬가지로 어디서 시작하는지도 모름..
// 최단 거리 -> BFS
// 여러곳 방문 가능

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;


class Solution {

    public int solution(String[] maps) {
        // 지도의 크기
        int mapXSize = maps[0].length();
        int mapYSize = maps.length;
        int sX = -1, sY = -1;
        int lX = -1, lY = -1;
        int eX= -1, eY = -1;
        
        // 좌표 찾기
        for (int y = 0; y < mapYSize; y++) {        
            for (int x = 0; x < mapXSize; x++) {    
                char ch = maps[y].charAt(x);
                if (ch == 'S') { sX = x; sY = y; }
                else if (ch == 'L') { lX = x; lY = y; }
                else if (ch == 'E') { eX = x; eY = y; }
            }
        }
        
        // 1. 출발지에서 레버 위치까지 거리
        int ldistance = bfs(maps,sX,sY,lX,lY,mapXSize,mapYSize);
        // 2. 레버 위치에서 도착지까지 거리
        int edistance = bfs(maps,lX,lY,eX,eY,mapXSize,mapYSize);
        
        return (ldistance==-1||edistance==-1)? -1 : ldistance+edistance;
        
           
    }
    private int bfs(String[] maps, int sX, int sY, int eX, int eY, int mapXSize, int mapYSize){
        // BFS용 
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[mapXSize][mapYSize];
        for (int x = 0; x < mapXSize; x++) {
            Arrays.fill(visited[x], -1);
        }
        visited[sX][sY] = 0;
        q.add(new int[]{sX,sY});
        
        int nextX[] = {-1,1,0,0}; //왼오--
        int nextY[] = {0,0,1,-1}; //--상하
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            if(nowX==eX&&nowY==eY){
                return visited[nowX][nowY];

            }
            
            for(int i=0;i<4;i++){
                int nX = nowX+nextX[i];
                int nY = nowY+nextY[i];
                
                if (nX < 0 || nY < 0 || nX >= mapXSize || nY >= mapYSize) continue;
                if (maps[nY].charAt(nX) == 'X') continue;
                if (visited[nX][nY] != -1) continue;

                visited[nX][nY] = visited[nowX][nowY] + 1;
                q.add(new int[]{nX, nY});
                
            }
            
        }
        return -1;
        
        
    }
}