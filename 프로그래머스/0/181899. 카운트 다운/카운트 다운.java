import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int start_num, int end_num) {
        List<Integer> list = new ArrayList<>();
        for (int start = start_num; start >= end_num; start--) {
            list.add(start);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}