class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int coke = n/10;
        if(k>coke){
            answer = n*12000+(k-coke)*2000;
        }else{
            answer = n*12000;
        }
        
        
        return answer;
    }
}