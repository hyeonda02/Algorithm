import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
    //1. 1,2,3번 수포자들 입력값 저장
	 int[][] pattern = {
         {1, 2, 3, 4, 5},
         {2, 1, 2, 3, 2, 4, 2, 5},
         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
	int[] score = new int[3];
	    
	 //2. 각 수포자들마다 몇개 맞췄는지 체크
	 for(int i=0;i<pattern.length;i++){
         for(int j=0;j<numbers.length;j++){
		   if(pattern[i][j%pattern[i].length]==numbers[j]) score[i]++;
	   }
     }
	   
	 //3. 가장 높은 점수를 확인
	 int maxScore = Arrays.stream(score).max().getAsInt();
	   
	 //4. 가장 높은 점수 받은 사람 확인
	 ArrayList<Integer> answ = new ArrayList<Integer>();
     for(int i=0; i<score.length; i++) {
         if(maxScore == score[i]) answ.add(i+1);
     }
     
     return answ.stream().mapToInt(Integer::intValue).toArray();
	    
    }
}