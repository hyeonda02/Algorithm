// 열은 컬럼, 행은 튜플
// 1번 컬럼 -> 기본티, 중복되지 않음

// col, row_begin, row_end 를 입력 받음
// col 번째 컬럼의 값을 기준으로 오름차순 정렬 -> 그 값이 동일하면 -> 첫번째 컬럼을 기준으로 내림차순
// S_i = i 번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합
// row_begin <= i <= row_end 인 모든 S_i를 누적해서 bitwise XOR한 값을 해시 값으로 반환

// 1. 먼저 정렬하기 (col 번째를 기준으로 오흠차순, 1번째 커럶 기준으로 내림차순)
// 2. S_i 값 계산하기
// 3. XOR 연산하기
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 1. 정렬하기 -> 정렬 조건 2개
        Arrays.sort(data, (a,b)-> {
            if(a[col-1]!=b[col-1]){ // col 번째 컬럼 기준 오름 차순 (만약 col번째 값이 다르면)
                return a[col-1]-b[col-1];
            }
            return b[0]-a[0]; // 1번째 컬럼 기준 내림차순
        });
        
        // 2. S_i값 계산하기
        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            int rowNum = i + 1; // 1-based 행 번호
            int sum = 0;

            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % rowNum;
            }
        // 3. XOR 연산하기
            answer ^= sum;
        }
        return answer;
    }
}