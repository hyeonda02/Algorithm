import java.util.ArrayList;
class Solution {
    static ArrayList<Integer> combList;
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length]; //조합에 뽑혔는지를 확인하기를 위한 배열
        combList = new ArrayList<>();
        int answer = 0;
        comb(nums, visited, 0, nums.length, 3 );
        for (int target: combList) {
            if (isPrime(target)) {
                answer++;
            }
        }
        return answer;
    }
    void comb(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            combList.add(print(arr, visited, n));
            return;
        }
        for (int i = start; i < n; i++ ) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    int print(int[] arr, boolean[] visited, int n) {
        int answer =0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                answer += arr[i];
            }

        }
        return answer;
    }
    private boolean isPrime(int target) {
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) {
                return false;
            }
        }
        return true;
    }
}