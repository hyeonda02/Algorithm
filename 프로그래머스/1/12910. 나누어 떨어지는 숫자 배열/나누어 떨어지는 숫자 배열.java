// 조건
// 각 요소의 값들이 모두 다름
// divisor는 자연수
// 배열의 크기는 얼마인지 모르겠다
// 만약 나누어 떨어지는 수가 없으면 -1을 반환해야 됨 <- 이 부분 때문에 통과 못할 수도 있을듯

// 의사코드
// 1. 나누고 나머지가 0이면 넣기
// 2. 정렬하기
// 3. 반환하기

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]%divisor == 0){
                result.add(arr[i]);
            }
        }
        if(result.size()==0) result.add(-1);
        Collections.sort(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}