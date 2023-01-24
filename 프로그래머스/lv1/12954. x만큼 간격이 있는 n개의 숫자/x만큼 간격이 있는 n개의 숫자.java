class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            long sum = (long)x*(long)i;
            answer[i] = x+sum;
        }
        return answer;
    }
}