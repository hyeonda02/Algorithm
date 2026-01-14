// n, m 격자 미로가 주어짐
// xy에서 출발해 rc로 이동해서 탈출해야됨
// 같은 격자 여러번 방문 허용, 이동하는 거리가 총 k여야 함
// 미로에서 탈출한 경로로 문자열 나타냈을때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 함
// 좌우상하 -> l,r,u,d

// 1. 일단 아예 목적지에 갈 수 없는 경우 사전 차단
// 2. 사전순 경로 만들기

import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // 시작점 - 도착점 사이의 최소 거리 구하기 (최소 거리가 k보다 크다면 그대로 answer return)
        int distance = Math.abs(x-r)+Math.abs(y-c);
        if(distance>k) return "impossible";
        
        // 그리고 만약 distance<k여도 왔다갔다 할 수 있는 거리가 짝수여야 목적지에 도달할 수 있다.
        if((k-distance)%2!=0) return "impossible";
        
        // 사전 순 거리 계산하기 while..안에서 k의 값을 감소 시켜 가면서 각 선택에서 최대한 사전순에 맞는 숫자를 선택한다
        int[] dx = {1,0,0,-1};
        int[] dy = {0,-1,1,0};
        char[] location = {'d','l','r','u'};
        StringBuilder sb = new StringBuilder();
        
        while(k>0){
            for(int i=0;i<4;i++){
                int nextX = x+dx[i];
                int nextY = y+dy[i];
                
                // 범위를 벗어나지 않는지 체크한다
                if(nextX<1||nextX>n||nextY<1||nextY>m) continue;
                
                // 남은 거리 계산 (불가능이면 스킵한다)
                int remainStep = k - 1;
                int remainDist = Math.abs(nextX-r)+Math.abs(nextY-c);
                if(remainDist>remainStep) continue;
                if((remainStep-remainDist)%2!=0) continue;
                
                // 이동 순서가 사전순이라.. 위 조건들에서 걸리지 않으면 사전순으로 거리 만족
                sb.append(location[i]);
                x = nextX; y = nextY;
                k--;
                break;
                
            }
        }
        return sb.toString();
        
    }
}