// 집의 개수 -> 3~100 0000
// money 배열의 각 원소 -> 0~1000

// [1,2,3,1] 4
// 각 집에 있는 돈의 배열이 주어짐 -> 훔칠 수 있는 돈의 최댓값을 return

// 집이 원형으로 이루어져 있다. -> 첫집과 마지막 집은 이웃관계
// 단순 홀수번째 집의 돈 합.. 짝수번째 집의 돈 합.. 이런식으로 가는건 맞지 않을듯
// 그냥 단순하게 최댓값을 더하는식?
// 확실하게 알 수 있는거.. 첫집을 털면 마지막은 못감
// 마지막을 철면 첫 집을 못감

class Solution {
    public int solution(int[] money) {
        int[] dp = new int[money.length];
        
        // 첫집 턴다 - 0번을 털면, 마지막과 1번을 못턴다.
        dp[0] = money[0];
        dp[1] = money[0];
        // 2번 부터는 털어도 되고, 안털어도 됨.. (왜냐면 3번에 더 좋은 조건이 있을 수 있다)
        for(int i=2;i<money.length-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]); // i번째 집을 안터는 경우, i번째 집을 터는 경우(전전꺼를 더해야됨)
        }
        
        // 그리고 마지막 집은 무조건 턴다
        // 그럼 확실한건 첫집은 못털음. 2번째부터는 털어도 되고 안털어도 되고..
        int[] dp2 = new int[money.length];
        dp2[0] = 0; // 첫집은 안텀
        dp2[1] = 0;

        for (int i = 1; i<money.length; i++) {
            if (i == 1) {
                dp2[i] = Math.max(dp2[0], money[1]); // 털어도 되고 안털어도 되고
            } else {
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            }
        }

        
        return Math.max(dp[money.length-2],dp2[money.length-1]);
    }
}