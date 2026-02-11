// numLog의 길이는 최대 10 0000
// numLog의 값은 -10 0000 최대 10 0000
import java.util.*;

class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "w");
        map.put(-1,"s");
        map.put(10,"d");
        map.put(-10,"a");
        
        int preNum = numLog[0];
        
        for(int i=1;i<numLog.length;i++){
            sb.append(map.get(numLog[i]-preNum));
            preNum = numLog[i];
        }
        
        return sb.toString();
        
    }
}