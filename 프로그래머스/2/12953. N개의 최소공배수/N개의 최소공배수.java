class Solution {
    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a % b);
    }
    public int solution(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            arr[i+1]  = arr[i]*arr[i+1]/gcd(arr[i],arr[i+1]);
        }
        return arr[arr.length-1];
    }
}