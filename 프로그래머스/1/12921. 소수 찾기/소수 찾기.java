class Solution {
        public int solution(int n) {
        int answer = isPrime(n);
        return answer;
    }
    private int isPrime(int n) {
        int[] arr = new int[n + 1];
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 0;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                answer++;
            }
        }
        return answer;

    }
    
}