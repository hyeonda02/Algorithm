import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> skt = new ArrayList<Integer>();
        int i=0;
        
        while(i<arr.length){
            if(skt.size()==0){
                skt.add(arr[i]);
                i++;
            }else if(skt.get(skt.size()-1)<arr[i]){
                skt.add(arr[i]);
                i++;
            }else if(skt.get(skt.size()-1)>=arr[i]){
                skt.remove(skt.size()-1);
            }
        }
        
        return skt.stream().mapToInt(Integer::intValue).toArray();
    }
}