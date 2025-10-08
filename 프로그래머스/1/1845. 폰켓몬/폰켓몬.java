import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums){
            set.add(a);
        }
        int N = nums.length/2;
        int spec = set.size();
        return spec>N? N : spec;
        
    }
}