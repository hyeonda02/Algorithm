// 5g는 4g보다 전달 범위가 좁다
// 겹치지 않으면 최대한 많이 설치 가능, 겹쳐도 됨
// 하나의 기지국당 범위 2w+1
// n의 크기는 2 00 000 000 -> stations을 기준으로 확인
// 걍 채우는것만 신경쓰면 안됨
// -> 이미 설치된거 반영해서 남은 부분들을 신경써야 함 (남은 토막들..) 중간중간 설치된게 적어질 수록 루프의 적어짐 따라서 시간 초과 문제는 걱정 안해도됨
// 각 기지국들의 겹치는 부분도 확인해야됨 1번 케이스의 경우, 4,5에 설치되었을 경우 -> 3~6임
import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start =1;
        int idx = 0;
        int num = 0;
        
        
        while(start<=n){
            // 마지막 칸 (중간에 설치된 기지국 없음)
            if(stations.length<=idx){
                num = n;
                answer += ((n-start+1)+(2*w))/(2*w+1);
                break;
                
            // idx-1~idx번째의 아파트& 기지국끼리 겹치는 경우도 고려해야됨
            }else{
                num = stations[idx]-w;
                if(start<num){
                    answer += ((num-start)+(2*w))/(2*w+1);
                }
                start = stations[idx]+w+1;
                idx++;
            }
        }

        return answer;
    }
}