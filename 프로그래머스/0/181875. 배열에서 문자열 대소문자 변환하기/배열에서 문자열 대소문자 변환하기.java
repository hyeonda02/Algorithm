// 조건
// strArr 배열의 크기는 최대 20
// 시간복잡도 O(N) 최악의 경우 20

// 의사 코드
// for문 돌리면서 소문자로 바꾸기
class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        for(int i=0;i<strArr.length;i++){
            if(i%2==0){
                answer[i] = strArr[i].toLowerCase();
            }else{
                answer[i] = strArr[i].toUpperCase();
            }
        }
        return answer;
    }
}