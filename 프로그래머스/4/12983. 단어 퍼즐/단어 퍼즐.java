// 배열의 길이는 1~100
// 문자열의 길이는 1~20000
// 만들 수 없는 경우 -1 리턴

// 일단. banana의 경우 최대 조각 수는 최대 길이 6

import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        // 1. dp 정의, 초기화
        int answer = t.length();
        int[] dp = new int[answer + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 2. 빠르게 찾기 위한 HashSet 세팅
        HashSet<String> set = new HashSet<>();
        int maxLen = 0;
        for (String s : strs) {
            set.add(s);
            maxLen = Math.max(maxLen, s.length());
        }

        // i -> 지금 만들고 싶은 위치
        // len -> 잘라볼 위치
        //  예: i=8이면 7~8, 6~8, 5~8 ... 범위를 확인
        for (int i = 1; i <= answer; i++) {

            for (int len = 1; len <= maxLen; len++) {
                if (i - len < 0) break;

                String sub = t.substring(i - len, i);

                //dp[i] = 지금까지 알고 있었던 최솟값
                //dp[i-len]+1 = 이번에 발견한 최솟값
                if (set.contains(sub) && dp[i - len] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }

        return dp[answer] == Integer.MAX_VALUE ? -1 : dp[answer];
    }
}
