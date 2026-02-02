import java.util.*;

class Solution {
    public String solution(String s) {
        // String의 길이가 1000밖에 안되서 TreeMap 사용 -> 정렬 보장
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
