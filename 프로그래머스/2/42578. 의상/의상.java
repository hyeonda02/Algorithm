// 의상의 수 = 1개 이상, 30개 이하, 의상 중복 없음
// 예시 
// [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
// headear - 2, eyewear - 1 (종류 - 개수)
// (2개+안입을 경우)*(1개+안입을 경우) = 3*2 = 6 -1(암것도 안입을 경우) = 5
// [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
// face - 3
// (3개 +안입을 경우)-1(암것도 안입을 경우) = 2

// 1. 의상 종류와, 종류의 개수를 hashMap에 넣기
// 2. 의상 종류만큼 루프
//      

import java.util.HashMap;
import java.util.Map;  

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수 세기
        HashMap<String, Integer> closet = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            closet.put(clothes[i][1], closet.getOrDefault(clothes[i][1], 0) + 1);
        }

        // 2. 경우의 수 계산
        int answer = 1;
        for (Map.Entry<String, Integer> e : closet.entrySet()) {
            int count = e.getValue();
            answer *= (count + 1);  
        }

        // 3. 모두 안 입는 경우 한 가지 빼기
        return answer - 1;
    }
}
