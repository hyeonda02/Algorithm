class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        for (int target : section) {
            if (target >= index) {
                answer++;
                index = target + m;
            }
        }

        return answer;
    }
}