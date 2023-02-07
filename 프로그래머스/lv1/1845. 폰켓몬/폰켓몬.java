import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;
        HashSet<Integer> numsSet = new HashSet<Integer>();
        //중복 제거
        for(int num:nums){
            numsSet.add(num);
        }
        if(n<numsSet.size()) answer = n;
        else answer = numsSet.size();
        return answer;
    }
}