class Solution {
    public int solution(int a, int b, int c) {

        if (a != b && b != c && a != c) {
            return a + b + c;
        }

        long sum = a + b + c;
        long squareSum = (long)a*a + (long)b*b + (long)c*c;

        if (a == b && b == c) {
            long cubeSum = (long)a*a*a + (long)b*b*b + (long)c*c*c;
            return (int)(sum * squareSum * cubeSum);
        }

        return (int)(sum * squareSum);
    }
}
