class Solution {
    public boolean divisor(int num){
        int divisor=0;
        for(int i=1;i<=num;i++){
            if(num%i==0)
                divisor++;
        }
        if(divisor%2==0) return true;
        else return false;
    }
    public int solution(int left, int right) {
        int answer=0;
        for(int i=left;i<=right;i++){
            if(divisor(i)) answer+=i;
            else answer-=i;
                
        }
        return answer;
    }
}