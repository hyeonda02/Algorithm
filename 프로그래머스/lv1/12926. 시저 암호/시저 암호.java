class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char  temp = s.charAt(i);
            if(temp==' ') sb.append(temp);
            else {
                if(temp>='a'&&temp<='z')
                    if(temp+n>'z') sb.append((char)(temp-26+n));
                    else sb.append((char)(temp+n));
                else if(temp>='A'&&temp<='Z')
                    if(temp+n>'Z') sb.append((char)(temp-26+n));
                    else sb.append((char)(temp+n));
                
            }
        }
        return sb.toString();
    }
}