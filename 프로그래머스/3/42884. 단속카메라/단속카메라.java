// 고속도로를 이동하는 차량의 경로 -> routes
// 모든 차량이 한 번은 단속용 카메라를 만드려면 최소 몇대 설치?
// 차량은 1~10000
//  routes -> 진입한 지점, 나간 지점 (진입, 나감 지점에 카메라가 설치되어 있어도 카메라 만난 것)
// 진입 지점, 진출 지점은 -30000 ~ 30000

// 1. 진출지점 을 기준으로 정렬
// 2. 진출 지점에 설치
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 1. 진출지점 을 기준으로 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        // (첫 지점에 먼서 설치)
        int answer = 1;
        int cameraPos = routes[0][1];
        
        // 2. 진출 지점에 설치
        for(int i=1;i<routes.length;i++){
            int start = routes[i][0];
            int end = routes[i][1];
            
            if(cameraPos<start){
                answer++;
                cameraPos = end;
                
            }
        }
        return answer;
    }
}