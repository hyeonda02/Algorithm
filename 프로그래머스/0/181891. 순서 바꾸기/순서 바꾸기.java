import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] pre_list = Arrays.copyOfRange(num_list,0,n);
        int[] last_list = Arrays.copyOfRange(num_list,n,num_list.length);
        
        int[] answer = new int[pre_list.length + last_list.length];
        System.arraycopy(last_list, 0, answer, 0, last_list.length);
        System.arraycopy(pre_list, 0, answer, last_list.length, pre_list.length);
        
        return answer;
        
    }
}