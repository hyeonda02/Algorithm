// 참가자는 1번부터 N번까지 번호 받음. 1,2 | 3,4 짝으로 경기 진행
// 2번, 4번이 이겼다면, 각각 1,2번을 할당

// 예시
// 1 2    3 4    5 6    7 8   -> 1라운드
//         4(2)          8(4) -> 2라운드
//      4(1)          8(2)    -> 3라운드



class Solution{
    public int solution(int n, int a, int b){
        int answer = 0;

        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }

        return answer;
    }
}