// 조건
// 실패율 = 스테이지 도달함 근데 아직 클리어하지 못한 플레이어 수 / 스테이지 도달한 플레이어 수
// 스테이지 개수를 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열을 stages
// 실패율이 높은 스테이지 부터 내립차순으로 스테이지의 번호가 담긴 배열을 리턴

// N의 크기는 1이상 200 이하
// stages의 길이는 1이상, 20 0000 이하
// N+1은 마지막 스테이지까지 클리어한 사용자를 나타낸다.
// 만약 실패율이 같은 스테이지가 있다면 작은 번호가 먼저
// 스테이지에 도달한 유저가 없는 경우 실패율은 0

// 의사코드
// 1. 실패율 구하기 (N크기의 배열에 저장.)
//    각 스테이지에 멈춰있는 사람 수 구하기
// 2. 헤당 배열을 내림차순으로 정리 (새로운 배열에 저장)
// 3. 내림차순으로 정리한거랑 1번에서 정리한거랑 비교해서 스테이지 번호 넣기
import java.util.HashMap;


class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 각 스테이지에 멈춰있는 사람 수 구하기 : 배열 범위 1~N+1
        int[] failList = new int[N+2]; 
        for(int stage : stages){
            failList[stage]++;
        }
        // 2. 실패율 구하기
        HashMap<Integer, Double> result = new HashMap<>();
        double total = stages.length;
        for(int i=1;i<failList.length-1;i++){
            // 만약 도달한 사람없을 경우엔 실패율 0
            if(failList[i]==0){
                result.put(i,0.0);
            }else {
                result.put(i,failList[i]/total);
                total-=failList[i];
            }
        }
        
        // 3. 실패율이 높은 스테이지부터 내림차순 정렬하기
        return result.entrySet().stream()
            .sorted((a,b) -> 
                a.getValue().equals(b.getValue())? Integer.compare(a.getKey(),b.getKey()) : Double.compare(b.getValue(), a.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
    }
}