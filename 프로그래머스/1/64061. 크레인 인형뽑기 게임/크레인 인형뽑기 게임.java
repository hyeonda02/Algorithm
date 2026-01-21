// NxN 크기의 칸들이 있음, 그 안에는 다양한 인형이 있음
// 모든 인형은 1x1 크기만 차지함, 격자의 가장 아래부터 쌓여있음

// 크레인은 좌우 이동 가능, 가장 위에 있는 인형 뽑기 가능
// 뽑은 인행은 바구니에 쌓음 -> 아래부터 쌓임, 바구니는 무제한
// 같은 종휴의 인형이 쌓이면 사라짐

// 인형이 없으면 크레인은 집지 않음

// board : 게임 화면의 격자의 상태가 담김 칸의 크기는 5~30, 0은 빈칸, 1~100 은 종류
// moves : 크레인 위치 1~1000


// 1. 각 칸 마다 제일 위에 있는 인형의 위치를 기록
// 2. 인형은 스택에 저장 (넣을떄 peek 후 확인, 만약 같다면 pop, 다르면 유지)
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int boardSize = board[0].length;
        
        // 1. 각 칸 마다 제일 위에 있는 인형의 위치를 기록, 맨 위 인덱스 기록, board 돌면서 인형의 위치 기록
        int[] idx = new int[boardSize];
        Arrays.fill(idx,-1);
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                int isExist = board[i][j];
                if(idx[j]==-1&&isExist!=0) idx[j] = i;
            }
            
        }

        // 2. 스택 정의
        int answer =0;
        Stack<Integer> stack = new Stack<>();
        
        for(int crain : moves){
            int x = crain-1;

            if(idx[x] >= boardSize) continue;

            int y = idx[x];
            int doll = board[y][x];

            if(doll==0) continue;
            board[y][x] = 0;

            idx[x]++;

            if(!stack.isEmpty() && stack.peek()==doll){
                stack.pop();
                answer+=2;
            }else{
                stack.push(doll);
            }
        }

        
        return answer;
    }
}