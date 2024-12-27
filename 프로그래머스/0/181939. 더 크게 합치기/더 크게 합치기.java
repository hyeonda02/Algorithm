class Solution {
    public int solution(int a, int b) {
        String num1 = String.valueOf(a)+b;
        String num2 = String.valueOf(b)+a;
        return Math.max(Integer.parseInt(num1), Integer.parseInt(num2));
    }
}