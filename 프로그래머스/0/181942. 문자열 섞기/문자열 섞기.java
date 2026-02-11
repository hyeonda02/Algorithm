class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        for(int i=0;i<str1.length();i++){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            
            answer += char1;
            answer += char2;
        }
        return answer;
    }
}