class Solution {
    public int solution(int n) {
        //매개변수로 입력 받은 int 형 n 값을 long으로 바꿔주지 않으면, 예제 3번에서 488이라는 결과값이 나온다. 입력 받은 n의 값을 int 형으로 그대로 사용하면 100번째 근처에서 오버 플로우가 나와서 음수로 한번 바뀌기 때문에 결과 값이 꼬이는 것을 알게 되었다..
        long num = n;
        int answer =0;
        while(num!=1){
            if(num%2==0){
                num/=2;
            }
            else{
                num=num*3+1;
            }
            answer++;
            if(answer>500){
                return -1;
            }
        }
        return answer;
    }
}