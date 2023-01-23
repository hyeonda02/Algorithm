class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p=0;
        int y=0;
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('p'==c)
                p++;
            if('y'==c)
                y++;
        }
        if(p==y)
            answer = true;
        else answer = false;
        
        return answer;
    }
}