// K칸 앞으로 (배터리 소모)
// 현재까지 온 거리*2
// N으로 도착해야됨. 최대한 배터리 소모 최소로 해서 이동
// 최소 소모량 리턴

// 6 -> 3*2 
// (3-1) -> 1*2  = 소모량1
// 1 = 소모량 1
// 절반까지 가기..


import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n!=0){
            if(n%2==0) {
                n/=2;
            }
            else {
                n-=1;
                answer++;
            }
        }    

        return answer;
    }
}