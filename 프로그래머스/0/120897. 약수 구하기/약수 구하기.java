import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n/2; i++) {
            if(n%i==0){
                answer.add(i);
            }
        }
        answer.add(n);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}