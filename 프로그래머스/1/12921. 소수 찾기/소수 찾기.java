class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for (int i = 2; i <= arr.length-1; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= arr.length - 1; i++) {
            if(arr[i] == 0) continue;
            for (int j = i + i; j <= arr.length - 1; j = j + i) {
                arr[j] = 0;
            }
        }
        for (int i = 2; i <= arr.length - 1; i++) {
            if(arr[i]!=0) answer++;
        }
        return answer;
    }
}