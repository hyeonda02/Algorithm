import java.util.ArrayList;
// 조건
// 1. k의 배수를 오름차순으로 저장해서 배열 리턴

// 의사코드
// 1. k의 배수를 늘려가며 list에 저장
// 2. list 반환하여 리턴
class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=k;i<=n;i+=k){
            list.add(i);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}