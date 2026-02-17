import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int n, String control) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('w',1);
        map.put('s',-1);
        map.put('d',10);
        map.put('a',-10);
        
        int move = 0;
        for(int i =0;i<control.length();i++){
            char c = control.charAt(i);
            move += map.get(c);
        }
        
        return n + move;
        
        
    }
}