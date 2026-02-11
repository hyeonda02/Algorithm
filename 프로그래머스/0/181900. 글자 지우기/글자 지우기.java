import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<indices.length;i++){
            set.add(indices[i]);
        }
        
        for(int i=0;i<my_string.length();i++){
            if(set.contains(i)) {
                continue;
            } else {
                sb.append(my_string.charAt(i));
            }
        }
        
        return sb.toString();
    }
}