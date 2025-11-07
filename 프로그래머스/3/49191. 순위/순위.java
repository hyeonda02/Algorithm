// [4,3] -> 4번은 3번을 이김
// 4> 3> 2        1>2>5
// 2번은 1,4,3 번에게 짐. 5번은 2번에게 짐.
// 정확하게 순위를 매길 수 있는 선수 -> 2명

/**
      1?    4
       3       
    2
5
*/

// 플로이드 워셜 -> 모든 지점에서 모든 지점까지의 최단 거리를 구하는 알고리즘
// 정점이 n개라면 n(n-1)개의 거리를 구함

// i가 k를 이기고, k가 j를 이기면 ->  i가 j를 이긴다.
// i가 k에게 지고, k가 j에게 지면 → i가 j에게 짐

// 1. 그래프 초기화
// 2. 매개변수로 주어진 results를 그래프에 반영(이기면1, 지면 -1, 모르면0)
// 3. 플로이드 워셜 이용해서 나머지 관계도 추론
// 4. 셀 수 있는 관계 세기

import java.util.*;


class Solution {
    public int solution(int n, int[][] results) {
        // 1. 그래프 초기화
        int[][] graph = new int[n+1][n+1];
        // 2. result 관계 반영
        for(int [] result: results){
            int winner = result[0];
            int loser = result[1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
            
        }
        // 3. 플로이드 워셜 알고리즘 적용
         for (int k = 1; k <= n; k++) {        // 중간 노드
            for (int i = 1; i <= n; i++) {    // 출발 노드
                for (int j = 1; j <= n; j++) { // 도착 노드
                    // i가 k를 이기고, k가 j를 이기면 -> i>j
                    if(graph[i][k]==1&&graph[k][j]==1){
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    // i가 k에게 지고, k가 j에게 지면 -> i<j
                    if(graph[i][k]==-1&&graph[k][j]==-1){
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
         }
        // 4. 순위를 정확히알 수 있는 선수 수 세기
        int answer =0;
        for(int i=1;i<=n;i++){
            int known = 0;
            for(int j=1;j<=n;j++){
                if(i==j) continue;
                if(graph[i][j]!=0) known++;
            }
            if(known == n-1)answer++;
        }
        return answer;
    }
}