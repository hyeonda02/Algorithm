class Solution {
    public int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b, a%b);
    }
    public int[] solution(int n, int m) {
        int gcd = gcd(Math.max(n,m),Math.min(n,m));
        int lcm = n*m/gcd;
        int[] answer = new int[2];
        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }
}