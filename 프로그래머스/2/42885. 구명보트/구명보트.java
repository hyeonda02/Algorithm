import java.util.*;
// 구명보트 제한 -> 최대 2명, 무게 limit 제한
// 보트를 최대한 적게 사용해 사람 구출
// 무게 많이 나가는 사람+적게 나가는 사람 쌍
// 50 50 70 80


class Solution {
    static int answer =0;
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int start =0;
        int end = people.length-1;
        
        
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;
            answer++;
            
        }
        return answer;
        
    }
}