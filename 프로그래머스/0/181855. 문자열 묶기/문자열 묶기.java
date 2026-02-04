class Solution {
    public int solution(String[] strArr) {
        int[] lenArr = new int[31];
        int max = 0;
        for(String str : strArr){
            int len = str.length();
            lenArr[len] = lenArr[len]+1;
            if(max<lenArr[len]) max = lenArr[len];
        }
        return max;
        
    }
}