// 아래칸으로 이동할 때, 대각선으로 오른쪽, 왼쪽 이동 가능
// 3
//8  1     3은 8또는 1로 이동할 수 있다.
// 모든 경로를 다 저장?
// 1번 - 7
// 2번 - 10, 15
// 3번 - 18, 11, 16, 15
// 이동하면서.. 모든 경로를 합으로 갱신.. 이건 시간초과날 것 같다
// 높이는 1이상, 500이하 


// 6,7, 12, 9, 6, 10, 10, 9
// 7, 12, 10, 10
// 15, 20, 13, 11,10, 10
// 20, 13, 10
// 23, 16, 21, 18
// 30, 25
// 최종 30

// 뒤엣서부터 더하면서 올라가기
// dp배열에 더한 값 저장
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<triangle[n-1].length;i++){
            dp[n-1][i] = triangle[n-1][i];
        }
        
        for(int i=n-2;i>=0;i--){
           for(int j=0;j<triangle[i].length;j++){
               int leftNum = dp[i+1][j]+triangle[i][j];
               int rightNum = dp[i+1][j+1]+triangle[i][j];
               dp[i][j] = Math.max(leftNum,rightNum);
           }
        }
        
        return dp[0][0];
    }
}