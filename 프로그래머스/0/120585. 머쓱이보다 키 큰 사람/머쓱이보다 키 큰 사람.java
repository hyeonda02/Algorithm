
import java.util.Arrays;

class Solution {
    public static int solution(int[] array, int height) {
        return (int) Arrays.stream(array).filter(num->num>height).count();
    }
}