// n개의 음이 아닌 정수.
// 이 정수들을 순서 바꾸지 않음. 적절하게 더하거나 빼서 타겟넘버를 만듬
// 예를 들어, [1,1,1,1,1]로 숫자 3을 만들려면 다음 방법을 사용할 수 있다.

// 1. 1+1+1+1   -1    * 하나의 1이 +1이거나, -1이거나,, 그래서 통 5가지.
// 예제 2번을 보니, 숫자들의 위치는 고정이고 각 숫자가 +냐 -냐의 차이인 것 같다.

// numbers의 개수는 2이상 20개 이하
// 각 숫자는 1이상 50이하
// 타겟 넘버는 1이상 1000 이하



//                        0
//                 4              -4
//            1        -1
//          2  -2     -2  2
//        1 -1  1 -1 1 -1  1-1
//  결과  8  6  4   2 2  0  6  4                      
//  따라서, 결과 부분을 세면 2개 정답은 2개이다.
//  모든 경우의 수를 DFS로 구해보자.. (깊이우선)
import java.util.Stack;

class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        // dfs 호출
        return dfs(numbers,target);
        
    }
    
    public int dfs(int[] numbers,int target){
        // 1. 스택을 생성, 초기값으로 [0,0]
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 초기 합 : 0
        stack.push(0); // 초기 인덱스 : 0
        
        int cnt = 0;
        
        // 2. 스택이 채워져있을때 반복 수행한다.
        while(!stack.isEmpty()){
            int currentIdx = stack.pop();
            int currentSum = stack.pop();
            
            // 3. 배열과 인덱스 같으면 종료 후 값 검증
            if(currentIdx == numbers.length) {
                if(currentSum==target) cnt++;
            } else { // 3-1. 만약 다르다면 다음 단계로 이동한다
                stack.push(currentSum+numbers[currentIdx]);
                stack.push(currentIdx+1);
                stack.push(currentSum-numbers[currentIdx]);
                stack.push(currentIdx+1);
            }
        }
        return cnt;
        
    }
}