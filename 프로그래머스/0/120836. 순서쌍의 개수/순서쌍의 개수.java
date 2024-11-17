import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        long answer = (int) IntStream.rangeClosed(1, sqrt).filter( i -> n % i==0 ).count();
        return (int) (answer * 2 - (sqrt * sqrt == n ? 1 : 0));
    }
}