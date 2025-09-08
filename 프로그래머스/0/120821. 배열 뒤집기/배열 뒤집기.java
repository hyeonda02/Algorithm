// 조건
// 배열의 길이 = 1000
// 배열의 원소 크기 = 최대 1000 (양수)

// 의사코드
// 1. 그냥 뒤집기


// 1. for문 사용
// 2. Stream 사용
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list) {
        // // 1. for 문 사용
        // int[] answer = new int[num_list.length];
        // int j=0;
        // for(int i = num_list.length-1; i>=0; i--){
        //     answer[j] = num_list[i];
        //     j++;
        // }
        // return answer;
        // 2. Stream 사용
        return IntStream.range(0,num_list.length).map(i->num_list[num_list.length-1-i]).toArray();
    }
}