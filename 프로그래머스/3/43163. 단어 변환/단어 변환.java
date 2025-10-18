// begin, target 단어의 집합 words가 있다.
// 최소 몇 단계를 거쳐 변환할 수 있는가?
// words의 개수는 3~50개 사이


// 한번에 한개의 알파벳만 바꿀 수 있음
// -> 현재 단어에서, 어디까지 바꿀 수 있는지 알아야 될 것 같음
// 그리고 배열의 순서도 상관 있는건가?
import java.util.*;


class Solution {
    
     static class Word {
        String word;
        int depth;

        Word(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
    
    public Queue<Word> queue;
    
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0; //일단 없으면 바꿀 수 없음
        queue = new LinkedList<>();
        
        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited,false);
        
        queue.add(new Word(begin,0));
        return bfs(begin, target, words, visited);
    }
    
    public boolean canChange(String start, String end){
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) diff++;
        }
        return diff == 1;
        
    }
    
    public int bfs(String begin, String target, String[] words, boolean[] visited){
                
        while(!queue.isEmpty()){
            Word now = queue.poll();
            
            if(now.word.equals(target)) return now.depth;
            
            for(int i=0;i<words.length;i++){
                if(!visited[i ]&& canChange(now.word, words[i])){
                    visited[i] = true;
                    queue.add(new Word(words[i],now.depth+1));
                }
            }
            
        }
        return 0;
    }
    
}