import java.util.Arrays;

class Solution {
     public int[] solution(int[] num_list) {
        int even = (int) Arrays.stream(num_list).filter(n -> n % 2 == 0).count();
        int odd = num_list.length - even;
        return new int[]{even,odd};
     }
}