// 위에서 4번째 밟으면 -> 바로밑에서 4번쨰 못감
// 같은 위치의 땅을 못밟음 (붙어있는 행끼리.. 연속된 위치 못감)
// 일단 가장 큰 숫자들만 밟아야됨

// 1, 2, 3, 4
// 3, 5, 6, 7
//이면,, 더해서 2행이 7,9,10, 10이 됨.. 이런식으로 밑으로 갈수록 더해감

import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        // 특정한 행에서 최댓값.. (전 행의 최대값을 더해가지고 저장)
        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[land.length - 1][j]);
        }

        return answer;
    }
}
