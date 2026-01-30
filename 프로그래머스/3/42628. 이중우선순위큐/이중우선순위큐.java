// operations의 길이는 1~100 0000 
// operations의 원소는 큐가 수행할 연산
// TreeMap<Integer, Integer> -> 값과, 해당 값이 몇개인지 저장
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String op : operations){
            String[] arr = op.split(" ");
            int num = Integer.parseInt(arr[1]);
            
            if(arr[0].equals("I")){
                map.put(num,map.getOrDefault(num,0)+1);
            }else{
                if(map.isEmpty()) continue;
                int key = num==1 ? map.lastKey() : map.firstKey();
                map.put(key, map.get(key) - 1);
                if(map.get(key)==0){
                    map.remove(key);
                }
            }
            
        }
        if (map.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
        
    }
}