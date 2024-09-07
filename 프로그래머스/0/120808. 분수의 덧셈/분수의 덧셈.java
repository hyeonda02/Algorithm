class Solution {
    static int answerNumer;
    static int[] answer;
    public int gcd ( int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int lcm = denom1*denom2/gcd(Math.max(denom1, denom2), Math.min(denom1, denom2));
        numer1 *= (double) lcm /denom1;
        numer2 *= (double) lcm /denom2;
        answerNumer = numer1 + numer2;
        int gcd = gcd(Math.max(answerNumer,lcm),Math.min(answerNumer,lcm));
        if(gcd!=0){
            answerNumer /= gcd;
            lcm /=gcd;
        }
        answer = new int[2];
        answer[0] = answerNumer;
        answer[1] = lcm;
        return answer;
    }
}