// 최대한 개수가 작은 종류를 제거
// 종류과 개수를 알아야됨

import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        List<Integer> value =map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        
        int sum =0;
        int answer=0;
        
        for(int v:value){
            if(sum>=k) break;
            sum+=v;
            answer++;
        }
        return answer;
    }
}