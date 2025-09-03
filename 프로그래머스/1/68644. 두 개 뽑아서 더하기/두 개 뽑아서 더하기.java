import java.util.HashSet;
class Solution {
    public int[] solution(int[] numbers) {
	    HashSet<Integer> set = new HashSet<>();
	    //1. 두개의 수 뽑기
	    for(int i=0; i<numbers.length-1; i++){
		    for(int j = i+1;j<numbers.length;j++){
		//2. 셋에 추가
			    set.add(numbers[i]+numbers[j]);
		    }
        }
        //3. 정렬 & 변환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}