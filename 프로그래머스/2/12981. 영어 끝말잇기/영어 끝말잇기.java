// 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어짐.
// 가장 먼저 탈락하는 사람의 번호와 그 사람이 몇번째 차례에 탈락하는지 
// 2<=단어의 개수<=50
// 만약 탈락자가 생기지 않는다면 0,0 리턴

// 탈락자의 조건
// 1. 끝말잇기 룰 자체를 지키지 않았을 경우
// 2. 이미 말한 단어를 말했을 경우

// 반환값의 조건
// 1. 탈락자의 번호
// 2. 몇번째에 탈락하는지
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int [] answer = {0,0};
        HashSet<String> wordList = new HashSet<>();
        
        wordList.add(words[0]);
        int index = 0;
        char lastChar = words[0].charAt(words[0].length()-1);
 
        while(words.length-1>index){
            if(!wordList.contains(words[++index])&&(words[index].charAt(0))==lastChar){
                wordList.add(words[index]);
                lastChar= words[index].charAt(words[index].length()-1);
            }else{
                answer[0] = index%n+1;
                answer[1] = (index+n)/n;
                return answer;
            }
        }
        
        return answer;
    }
}