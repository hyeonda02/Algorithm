// 조건
// 1. 큐에서 프로세스 꺼냄. 우선순위가 더 큰게 있으면
// 2. 넣기
// 3. 우선순위가 큰거 부터 꺼냄
// 만약 1,1,1 이런식이라면 큐에 특성대로 FIFO가 되어야 됨

// properties : 프로세스의 중요도가 순서대로 담긴 배열, 길이는 1이상 100 이하
// location : 몇 번째로 실행되는지 알고 싶은 프로세스의 위치를 알려줌

// 1. 큐에 번호와, 중요도를 담은 Map을 넣는다.
// 2. 큐가 빌때까지 뺀다. (빼면서 우선순위 보다 작다면 다시 넣기)
// 2-1. 만약 뺀 값의 우선순위가 크다면 버리기 & location 확인, max 값 변경

// max 값 변경이 문제..
// 같은 우선순위를 가지고 있는 값들이 있어섯 이를 어케 갱신할 것인가.. 가 문제인데
// 우선순위는 배열에 담긴걸로 가져갈까..?
// 배열의 크기가 100이하라 괜찮을것 같다

import java.util.ArrayDeque;
import java.util.Arrays;



class Solution {
    
    static class Priority{
        int index;
        int num;
        
        Priority(int index, int num){
            this.index = index;
            this.num = num;
        }
        
    }
    
    public int solution(int[] priorities, int location) {
       ArrayDeque<Priority> queue = new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            Priority priority = new Priority(i,priorities[i]);
            queue.add(priority);
        }
        
        int answer =0;
        int index = priorities.length-1;
        int[] maxArr = Arrays.stream(priorities).sorted().toArray();
        
        
        while(!queue.isEmpty()){
            Priority priority = queue.pollFirst();
            // 만약 max랑 다르면 마지막에 넣기
            if(priority.num<maxArr[index]){
                queue.addLast(priority);
                // max 값 변경해야됨
            }else{
                answer++;
                index--;
                if(priority.index==location){
                    return answer;
                }
            }
                
        }
        return answer;
        
    }
}