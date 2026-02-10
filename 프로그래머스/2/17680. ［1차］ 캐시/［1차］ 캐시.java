// cacheSize 최대 30
// cities 배열 -> 최대 100 000
// 도시 이름 -> 영문자 (대소문자 구분 안함, 최대 20자)
// 입력된 도시 이름 순서대로 처리시, 총 실행시간 출력

// 캐시 교체 알고리즘은 LRU
// hit 시 1
// miss -> 5

// P, S, N
// 15 + 15 + 15
// 선입 선출 -> 선입선출 뿐만 아니라
// hit 발생 시, 해당 데이터를 "가장 최근 사용" 위치로 이동
// 대소문자 구분 안함 -> 그냥 소문자로 변경후 삽입
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐시 사이즈가 0이면 계산할 필요가 없음
        if(cacheSize==0) return cities.length*5;
        int answer = 0;
        
        HashSet<String> set = new LinkedHashSet<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            // 캐시에 존재할 경우, hit 처리 & set 갱신
            if(set.contains(city)) {
                answer++;
                set.remove(city);
            // 존재하지 않을 경우, miss 처리 & set 지우기 (제일 앞에 있는 값 지우기)
            } else {
                answer +=5;
                if(set.size()==cacheSize){
                    // 현재 캐시에 들어있는 것들 중에 가장 오래된거 ㅁ지문
                    set.remove(set.iterator().next());
                }
            }
            
            // 캐시 저장
            set.add(city);
        }
        
        return answer;
    }
}