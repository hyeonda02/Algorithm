// 벨트에 있는 상자 -> 번호 오름차순
// 만약 순서 아니면 다른 곳 보관 (다른 벨트, 맨 앞의 상자만 뺄 수 있다. FILO)
// 그대로 실지 못한다면, stop


// 기사가 원하는 순서 : order (1000000)
//order[i] => 기본의 벨트에 order[i] 번째 상자를 i+1번째로 실어야 됨

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 1;

        for (int o : order) {
            // 필요한 상자 번호가 나올 때까지 보조 벨트로 이동
            while (idx <= o) {
                stack.push(idx);
                idx++;
            }

            // 보조 벨트 맨 위가 원하는 번호면 실음
            if (!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                break; 
            }
        }
        return answer;
    }
}
