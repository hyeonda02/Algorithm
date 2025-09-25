// 조건
// 들어오고 나갈때 이름이 출력된다.
// 닉네임 변경 방법 -> 1. 나간 후 새로 다시 들어감, 2. 그 방에서 변경함
// 이름 바꾸면 채팅방 출력 이름도 바뀜
// record -> 1이상, 10 000 이하
// 유저 아이디로 구분, 들어올때 : Enter uid123 Muzi
// 나갈 때 , Leave
// 바꿀 때, Change

// 입출력 예
// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
// 아이디 - 닉네임 매칭 (최신 변경)


// 의사 코드
// 1. 확인하면서 아이디-닉네임 매칭
// 2. 그리고 아이디-들어왓는지 안왔는지 알아야됨
// 3. Enter 배열 돌면서 누가 들어오고 나갔는지 작성하기
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private final String ENTER_PREFIX = "님이 들어왔습니다.";
    private final String LEAVE_PREFIX = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        
        ArrayList<String> answer = new ArrayList<String>();
        HashMap<String,String> userInfo = new HashMap<String,String>();
        
        for (String rec : record) {
            String[] user = rec.split(" ");
            String userDo = user[0];
            String userId = user[1];

            if (userDo.equals("Enter") || userDo.equals("Change")) {
                userInfo.put(userId, user[2]);
            }
        }
        
                
        for(int i=0;i<record.length;i++){
            String[] user = record[i].split(" ");      
            String userDo = user[0];
            String userId = user[1];
   
            if(!userDo.equals("Change")){
                if(userDo.equals("Enter")){
                    answer.add(userInfo.get(userId)+ENTER_PREFIX);
                }else{
                    answer.add(userInfo.get(userId)+LEAVE_PREFIX);
                }

            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}