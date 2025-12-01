// 숫자의 종류의 개수가 같으면 공평하게 나눈 것으로 간주
// 공평하게 나누지 못할 수도 있음 이 경우엔 0을 리턴

import java.util.*;


class Solution {
    public int solution(int[] topping) {
        HashMap<Integer,Integer> rightCount = new HashMap<>();
        
        // 오른쪽 개수 세기
        for(int i=0;i<topping.length;i++){
            int target = topping[i];
            rightCount.put(target,rightCount.getOrDefault(target,0)+1);
        }
        
        HashSet<Integer> left = new HashSet<>();
        int answer =0;
        for(int i=0;i<topping.length-1;i++){
            int target = topping[i];
            left.add(target);
            
            rightCount.put(target,rightCount.get(target)-1);
            if(rightCount.get(target)==0) rightCount.remove(target);
            
            if(left.size()==rightCount.size()) answer++;
        }
        return answer;
        
    }
}