import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i : delete_list) {
            set.add(i);
        }
        
        for(int i : arr) {
            if(set.contains(i)) {
                continue;
            }
            list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
        
    }
}