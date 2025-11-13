// 일단 왜 순서가 저런거지.. 이해가 안감.... 

class Solution {
    public char[] words = {'A','E','I','O','U'};
    public int answer;
    public boolean found;
    
    
    public int solution(String word) {
        answer = 0;
        found = false;
        dfs("", word);
        return answer;
    }
    
    public void dfs(String current, String target){
        // 똑같으면 중지..
        if(found) return;
        // 빈 문자가 아니면 순서 증가, 그리고 똑같으면 중지..
        if(!current.isEmpty()){
            answer++;
            if(current.equals(target)){
                found = true;
                return;
            }
        }
        // 길이가 5이면 멈춤
        if (current.length() == 5) {
            return;
        }
        
        for(char c : words){
            dfs(current+c, target);
            if(found) return;
        }
        
    }
}