// 문제 조건
// 지갑 30,15
// 지폐 26,17 -> 13, 17 -> 90도 
// 35, 18 처럼 둘다 클 수 있음
// 이 경우 17, 18 -> 17, 9 
// 

// 1. 길이가 긴 쪽을 반으로 접음 (소수접은 버림)
// 2. 그대로, 90도 돌려서 넣을 수 있으면 스탑

// 지폐 몇번 접어야 하는지 횟수를 리턴
// 지폐 중 작은 값이, 지갑의 작은 값보다 작으면 스탑, 큰 값은 큰 값보다 작아야됨
// 큰값은 큰 값끼리, 작은 값은 작은 값끼리 비교

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(bill[0],bill[1])>Math.min(wallet[0],wallet[1])||
             Math.max(bill[0],bill[1])>Math.max(wallet[0],wallet[1])){
            if(bill[0]>bill[1]) {
                bill[0] = bill[0]/2;
            }else {
                bill[1] = bill[1]/2;
            }
            answer++;
        }
        return answer;
    }
}