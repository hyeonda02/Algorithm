import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        int answer = (int) IntStream.rangeClosed(1, (int) Math.sqrt(n)).filter(i->n%i==0).count()*2;
        return sqrt == (int) sqrt ? answer-1 : answer;
    }
}