// 조건
// 잘라낸 원소의 길이 -> 최대 8
// intStrs의 길이 -> 최대 10000
// intStrs의 원소의 길이 -> 최대 120
// 시간 복잡도는 O(N) N은 intStrs의 길이
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<intStrs.length;i++){
            String splitNum = intStrs[i].substring(s,s+l);
            Integer num = Integer.valueOf(splitNum);
            if(k<num){
                answer.add(num);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}