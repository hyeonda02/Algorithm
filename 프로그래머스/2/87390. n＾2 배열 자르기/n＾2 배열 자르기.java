// 조건
// 행렬의 크기를 결정하는 n의 크기가 최대 10^7
// 최악의 경우 n이 10^7이고, left=0, right = 10^7-1 일 수도 있음 그러면 right-left = 100만 정도?..
// 아 근데 right - left는 최대 10^5라는 조건이 있긴 함. 그래도 최악의 경우 10만

// 의사 코드
// 1. 일단 nxn의 행렬에 숫자를 넣어야 됨 (이것도 고민인게 10^7이니까 하나하나 넣으면 시간 복잡도가 10^7x10^7) <- 시간복잡도 때문에 안될거 같은
// 2. 행별로 잘라서 배열로 만들기
// 3. 해당 배열에서 left~right 부분만 자르기
// 4. 반환하기

// 고민
// 행렬을 굳이 만들어야 할까? for 문으로 만들면 n^2 이고, n은 최대 10^7
// 결국에 정답으로 반환하는 건 left ~ right니까 여기 부분만 딱 구하면 안되나
// left -> left%n -> left%n은 열의 위치, left/n은 행의 위치 (right도 마찬가지)
// 1. left의 x,y right의 x,y의 위치를 정확하게 구하기
// 2. 범위에 맞춰서 값 구하기
// 2-1. 만약 y의 값이 같다면, leftX~rightX의 값만 구하면 됨.
// 2-2. 만약 y의 값이 다르다면 2중 for문..leftY~rightY까지
//      (1) 만약 i==leftY일 경우, leftX부터 n-1까지
//      (2) 만약 i!=rightY&&i!=leftY가 아닐 경우일 경우, 0부터 n-1까지
//      (3) 만약 i==rightY일 경우, 0부터 rightX까지


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<Integer>();
        
        int leftX = (int)(left%n); int leftY = (int)(left/n);
        int rightX = (int)(right%n); int rightY = (int)(right/n);
        
        if(leftY==rightY){
            for(int i=leftX;i<=rightX;i++){
                answer.add(Math.max(leftY, i)+1);
            }
        }else{
            for(int i=leftY;i<=rightY;i++){
                if(i==leftY){
                    for(int j=leftX;j<n;j++){
                        answer.add(Math.max(j,i)+1);
                    }
                }else if(i!=leftY&&i!=rightY){
                    for(int j=0;j<n;j++){
                        answer.add(Math.max(j,i)+1);
                    }
                    
                }else if(i==rightY){
                    for(int j=0;j<=rightX;j++){
                        answer.add(Math.max(j,i)+1);
                    }
                    
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray(); 
    }
}