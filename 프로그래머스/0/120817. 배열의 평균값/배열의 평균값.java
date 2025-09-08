// 조건
// 배열의 길이 = 최대 100
// 원소의 크기 = 최대 1000
// 결과는 무조건 .5, .0으로 끝남

// 의사코드
// 1. numbers 요소들 더하기
// 2. numbers의 길이로 나누기
import java.util.Arrays;

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        answer = Arrays.stream(numbers).sum();
        return answer/numbers.length;
    }
}