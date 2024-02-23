class Solution {
    public static int solution(String s) {
        int answer = 0;
        int start = 0;
        int other = 0;
        char startChar = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == startChar) {
                start++;
            }else{
                other++;
            }

            if (start == other && i!=s.length()-1) {
                answer++;
                startChar = s.charAt(i + 1);
            }


        }
        return ++answer;
    }
}