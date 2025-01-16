class Solution {
    public int solution(int n) {
        int answer = 1;
        int i = 1;
        while (answer * i <= n) {
            answer *= i;
            i++;
        }
        return i-1;
    }
}