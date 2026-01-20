// 1~n개의 택배 상자를
// 가로에 w개씩 놓을 수 있는 장소에 놓기
// 오->왼, 왼->오

// 예, 상자가 22개, w=6
// 6*3=18개
// 맨 위층 : 오->왼으로 4개

// 꺼내려는 상자 번호 num, (위에 어떠한 상자도 없어야 꺼내기 가능)
// 꺼내야 하는 상자의 개수 넣기

// 2~n~100
// 1~w~10
// 1~num~n

// 1. 스택을 총 w개 정의
// 2. for문을 돌면서 스택에 숫자 넣기
// 3. 꺼내야 하는 숫자가 포함된 스택을 선정
// 4. 꺼내야 하는 숫자가 나올때까지 pop

import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 1. 스택을 총 w개 정의
        Stack<Integer>[] stacks = new Stack[w];
        for (int i = 0; i < w; i++) {
            stacks[i] = new Stack<>();
        }
        
        // 2. for문을 돌면서 스택에 숫자 넣기
        int cycle = 1;
        int additional = n%w;
        
        for (int i=1;i<=n-additional;i+=w){
            if(cycle%2==1){
                for(int j=0;j<w;j++){
                    stacks[j].push(i+j);
                }       
            }else{
                for (int j = 0; j < w; j++) {
                    stacks[w - 1 - j].push(i + j);
                }
            }
            cycle++;
        }
        // 추가로 남은거 처리
        int start = n - additional + 1;
        if (additional > 0) {
            if (cycle % 2 == 1) { // 왼 -> 오
                for (int j = 0; j < additional; j++) {
                    stacks[j].push(start + j);
                }
            } else { // 오 -> 왼
                for (int j = 0; j < additional; j++) {
                    stacks[w - 1 - j].push(start + j);
                }
            }
        }

        // 3) num이 들어있는 스택 찾기
        int targetStack = -1;
        for (int i = 0; i < w; i++) {
            if (stacks[i].contains(num)) {
                targetStack = i;
                break;
            }
        }

        // 4) num이 나올 때까지 pop
        while (stacks[targetStack].peek() != num) {
            stacks[targetStack].pop();
            answer++;
        }

        // num 박스도 꺼내야 하므로 +1
        answer++;

        return answer;
    }
}