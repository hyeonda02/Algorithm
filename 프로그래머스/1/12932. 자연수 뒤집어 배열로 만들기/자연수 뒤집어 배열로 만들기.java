// 조건
// n은 최대 10,000,000,000 
// 배열의 최대 크기는 11

// 의사 코드
// 1. String으로 변환
// 2. String을 잘라서 Char배열로 변환
// 3. 뒤집기
// 4. 배열을 int[]로 변환

class Solution {
    public int[] solution(long n) {
        char[] charArr = String.valueOf(n).toCharArray();
        int[] answer = new int[charArr.length];
        for(int i=0;i<charArr.length;i++){
            answer[i] = charArr[charArr.length-1-i] - '0';
        } 
        return answer;
    }
}