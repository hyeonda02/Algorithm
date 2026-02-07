class Solution {
    // 문자열 최대 크기 200
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isStart = true;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            // 만약에 공백일 경우, 
            if (c == ' ') {
                sb.append(c);
                isStart = true;
                
            } else { // 만약 공백이 아니라면, 첫 문자이거나, 이하 문자이거나
                if(isStart) { // 만약 첫 문자이면
                    sb.append(Character.toUpperCase(c));
                    isStart = false;
                } else { // 만약 첫 문자가 아니면
                    sb.append(Character.toLowerCase(c));
                    isStart = false;
                    
                }
            }
        }
        return sb.toString();
    }
}