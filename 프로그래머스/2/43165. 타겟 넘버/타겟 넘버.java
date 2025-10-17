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


class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        // dfs 호출
        answer =0;
        dfs(numbers,0,target,0);
        return answer;
        
    }
    
    public void dfs(int[] numbers,int depth, int target, int sum){
        // 현재의 길이랑 제공되는 숫자의 길이가 같을 경우, 스탑
        if(depth==numbers.length){
            if(target==sum) answer++;
            return;
        }else{
            dfs(numbers,depth+1,target,sum-numbers[depth]);
            dfs(numbers,depth+1,target,sum+numbers[depth]);
        }
        
        
    }
}