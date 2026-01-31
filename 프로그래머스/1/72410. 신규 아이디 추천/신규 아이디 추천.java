// 아이디의 길이 -> 3~15
// 소문자, 숫자, -, _, . 문자만 사용 가능
// .는 처음과 끝에만 사용 불가, 연속 사용 불가
import java.util.*;

class Solution {
    public String solution(String new_id) {
        return step1(new_id);
    }
    
    // step1.모든 대문자를 대응되는 소문자로 치환합니다.
    private String step1(String id){
        return step2(id.toLowerCase());
        
    }
    // step2.알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    private String step2(String id){
        StringBuilder sb = new StringBuilder();
        
        for(char c : id.toCharArray()){
            if((c >='a'&& c<='z')||(c>='0'&&c<='9')||c=='-'||c=='_'||c=='.') sb.append(c);
        }
        return step3(sb.toString());
        
    }
    // step3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    private String step3(String id){
       while(id.contains("..")){
           id = id.replace("..",".");
       }
        return step4(id);
        
    }
    // step4. 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    private String step4(String id){
        while(id.startsWith(".")||id.endsWith(".")){
            if(id.startsWith(".")){
                id = id.substring(1,id.length());    
            }
            if(id.endsWith(".")){
                id = id.substring(0,id.length()-1);
            }
        }
        return step5(id);
    }
    // step5. 빈 문자열이라면, new_id에 "a"를 대입합니다.
    private String step5(String id){
        if(id.isEmpty()){
            id = id+"a";
        }
        return step6(id);
        
    }
    // step 6. new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다. 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    private String step6(String id){
        if(id.length()>15){
            id = id.substring(0,15);
        }
        if (id.endsWith(".")) {
            id = id.substring(0, id.length() - 1);
        }
        return step7(id);
        
    }
    // 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    private String step7(String id){
        char last = id.charAt(id.length()-1);
        while(id.length()<=2){
            id = id+last;
        }
        return id;
        
    }
}