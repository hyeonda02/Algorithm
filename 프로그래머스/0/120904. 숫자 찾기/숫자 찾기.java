class Solution {
    public int solution(int num, int k) {
        String numStr = ""+num;
        String kStr = ""+k;
        
        if(numStr.contains(kStr)) return numStr.indexOf(kStr)+1;
        return -1;
    }
}