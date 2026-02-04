import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String rsp) {
        Map<Character,Character> victoryMap = new HashMap<>();
        victoryMap.put('0', '5');
        victoryMap.put('2', '0');
        victoryMap.put('5', '2');
        
        String answer = "";
        for(int i=0;i<rsp.length();i++){
            answer+=victoryMap.get(rsp.charAt(i));
        }
        return answer;
        
    }
}