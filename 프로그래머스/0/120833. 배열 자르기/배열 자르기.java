// 조건
// 배열의 길이 = 최대 30
// 원소의 크기 = 1000
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }
}