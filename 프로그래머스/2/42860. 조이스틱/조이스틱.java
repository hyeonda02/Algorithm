// 이름에 A가 들어가는 경우를 잘 생각해야 됨
// A를 만나면 왼쪽, 
// *A* -> 일 경우 첫 자리에서 바로 왼쪽 & 뒤로 가는게 최소
// *A**, *AA* 일 경우도 첫 자리에서 바로 왼쪽으로 가는게 최소
// **A*일 경우 왼쪽으로 가는게 최소가 아니라 바로 그냥 오른쪽으로 넘어가는게 최소
// name의 길이는 1이상 20이하

// 각 문자에서 name의 알파벳으로 변경하는 값은 동일 (여기서도 최소값 고려)
// 여기서 이동할때 소요되는 조작 횟수가 더해짐
class Solution {
    public int solution(String name) {       
        int answer  =0;
        // 1. 각 문자에서 name의 알파벳으로 변경하는 값
        for(int i=0;i<name.length();i++){
            char nameAlpha = name.charAt(i);
            int count = nameAlpha - 'A';
            answer += Math.min(count, 26-count); // 최소값 고려
            System.out.println(answer);
        }
        
        // 2. 이동할때 소요되는 조작 횟수
        // A의 구간을 세야됨 (A가 얼만큼 반복 되냐에 따라 돌아갈지 직진할지 알 수 있음)
        int moveCount = name.length()-1; // 그냥 쭉 이동했을때의 거리
        for(int i=0;i<name.length();i++){
            // A를 만날때까지 이동 & A인 경우 해당 구간을 셈
            int next = i+1;
            while(next<name.length()&&name.charAt(next)=='A'){
                next++;
            }
            // 돌아가는 경우와, 직진하는 경우
            moveCount = Math.min(moveCount, i*2+(name.length() - next));
            moveCount = Math.min(moveCount, i+2*(name.length()-next));
            
        }
        



        return answer+moveCount;
    }
}