// 왼손 : * 1 4 7 
// 오른손 : # 3 6 9

// 가까운 손이 이동 : 2 5 8 0
// 만약 거리가 같다면 오른손 잡이는 오른손, 왼손잡이는 왼손

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int curR = 12;
        int curL = 10;
        
        for(int num : numbers){
            int target = (num == 0) ? 11 : num;
            
            if(target==1||target==4||target==7){
                answer+="L";
                curL = target;
            } else if(target==3||target==6||target==9){
                answer+="R";
                curR = target;
            } else {
                String result = findHand(target, curL, curR, hand);
                if(result.equals("R")) {
                    curR = target;
                }else{
                    curL = target;
                }
                answer+=result;
                
                
            }
        } 
        return answer;
    }
    
    private String findHand(int num, int curL, int curR, String hand) {
        int leftDist = getDistance(curL, num);
        int rightDist = getDistance(curR, num);

        if (leftDist == rightDist) {
            return hand.equals("right") ? "R" : "L";
        }

        return leftDist < rightDist ? "L" : "R";
    }
    
    private int getDistance(int from, int to) {
        // 세로 위치
        int fromRow = (from - 1) / 3;
        int toRow   = (to - 1) / 3;

        // 가로 위치
        int fromCol = (from - 1) % 3;
        int toCol   = (to - 1) % 3;

        // 세로 차이 + 가로 차이
        return Math.abs(fromRow - toRow) + Math.abs(fromCol - toCol);
    }

}