// 학교 -> 집 방향으로 접근 (근데 dp를 채우는 방향은 왼->오 방향)
// 1000000007로 나눈 나머지 리턴 (미리 나누기)
// 각 칸마다 갈 수 있는 수 저장?

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        
        // 웅덩이 체크
        boolean[][] isPuddle = new boolean[n][m];
        for (int[] p : puddles) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            isPuddle[y][x] = true;
        }
        
        if (isPuddle[0][0]) return 0;
        dp[0][0] = 1;
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {

                // 시작점
                if (y == 0 && x == 0) continue;

                // 웅덩이
                if (isPuddle[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }

                int up = (y > 0) ? dp[y - 1][x] : 0;
                int left = (x > 0) ? dp[y][x - 1] : 0;

                dp[y][x] = (up + left) % 1000000007;
            }
        }
        return dp[n - 1][m - 1];
    }
}