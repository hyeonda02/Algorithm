class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int input = x;
        int result=0;
        while(input>0){
            result+=input%10;
            input/=10;
        }
        if(x%result==0)
            answer = true;
        return answer;
    }
}