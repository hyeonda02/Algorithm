class Solution {
        public int gcd ( int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[]{numer1*denom2 + numer2*denom1, denom1*denom2};
        int gcd = gcd(Math.max(answer[0],answer[1]),Math.min(answer[0],answer[1]));
        answer[0] /= gcd;
        answer[1] /= gcd;
        return answer;

    }
}