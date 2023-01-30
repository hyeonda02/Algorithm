import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int count=0;
        for(int i=0;i<arr.length;i++){
            char temp =arr[i];
            if(temp==' '){
                sb.append(' ');
                count=0;
                continue;
            }
            
            if(count%2==0){
                if(Character.isLowerCase(temp))
                    temp = Character.toUpperCase(temp);
                    sb.append(temp);
                    count++;
                    continue;
                
            }else{
                if(Character.isUpperCase(temp))
                    temp = Character.toLowerCase(temp);
                    sb.append(temp);
                    count++;
                    continue;
            }
        }
        return sb.toString();
    }
}