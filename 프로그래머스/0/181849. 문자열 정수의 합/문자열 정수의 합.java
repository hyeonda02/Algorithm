class Solution {
    public int solution(String num_str) {
        char[] charArr = num_str.toCharArray();
        int answer = 0;
        for(char c : charArr){
            answer += Character.getNumericValue(c);
        }
        return answer;
    }
}