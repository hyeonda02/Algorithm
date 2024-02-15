import java.util.ArrayList;

class Solution {
      static ArrayList<Integer> list;
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        list = new ArrayList<>();
        comb(nums, visited, 0, nums.length, 3 );
        return list.size();
    }
    void comb(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        for (int i = start; i < n; i++ ) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    void print(int[] arr, boolean[] visited, int n) {
        int target =0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                target += arr[i];
            }

        }
        if (isPrime(target)) {
            list.add(target);
        }
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