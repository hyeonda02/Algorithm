import java.util.ArrayList;
// 조건
// 1. intervals의 값들은 음수가 아님. 1에서 arr의 길이보다 작음
// 2. a1<b1, a2<b2
// 3. 각 구간은 닫힌 구간 
// 4. arr의 길이는 최대 100,000

// 의사코드
// 1. 각 구간마다 값을 복사
// 1-1. 각 구간은 닫힌구간
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<2;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j=start;j<=end;j++){
                list.add(arr[j]);
            }
            
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}