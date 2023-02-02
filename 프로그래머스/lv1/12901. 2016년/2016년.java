class Solution {
    public String solution(int a, int b) {
        String[] answer = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] date = {31,29,31,30,31,30,31,31,30,31,30};
        int day=0;
        for(int i=1;i<a;i++){
            day+=date[i-1];
        }
        day+=(b-1);        
        return answer[day%7];
    }
}