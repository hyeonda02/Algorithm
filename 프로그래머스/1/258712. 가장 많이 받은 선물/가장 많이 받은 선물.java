// 이번달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을 지 예측
// 1. 두 사람이 주고 받음 -> 더 많이 준 사람이 하나 받음 (A:2, B:3) ->B가 A에게 하나 줌
// 2. 같거나, 기록이 없다면 -> 선물 지수가 더 큰 사람이 적은 사람에게 하나 받음
    // 선물 지수 : 이번달 까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
// 3. 선물지수도 같다면 선물 아예 주고받지 않음

// 선물을 가장 많이 받는 사람의 선물 수
// friends : 친구의 이름 2~50
// gifts : 주고 받은 선물 기록 1~10000 "선물 준 사람이름, 선물 받은 사람 이름"
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 1. 사람 이름 빛 번호 기록
        Map<String,Integer> idx = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            idx.put(friends[i],i);
        }
        
        
        // 2. 선물 주고 받은 개수 기록, 선물 지수 계산
        int len = friends.length;
        int[][] friendsGift = new int[len][len];
        int[] totalGifts = new int[len];
        
        for(int i=0;i<gifts.length;i++){
            String[] relation = gifts[i].split(" ");
            int a = idx.get(relation[0]);
            int b = idx.get(relation[1]);
            
            friendsGift[a][b]++;
            totalGifts[a]++;
            totalGifts[b]--;
            
        }
        
        // 3. 누가 많이 받을지 예측
        int[] answer = new int[len];
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(friendsGift[i][j]>friendsGift[j][i]) answer[i] += 1;
                else if (friendsGift[i][j]<friendsGift[j][i]) answer[j] += 1;
                else{
                    if(totalGifts[i]>totalGifts[j]) answer[i] += 1;
                    else if (totalGifts[i]<totalGifts[j]) answer[j] +=1;
                }
            }
        }
        
        int max = 0;
        for(int a :answer) max = Math.max(max,a);
        return max;
    }
}