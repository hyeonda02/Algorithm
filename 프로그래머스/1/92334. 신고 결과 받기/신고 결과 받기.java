// 신고 -> 처리 -> 결과를 메일로 발송
// 1. 각 유저는 한 번에 한 명의 유저를 신고할 수 있다
//      서로 다른 유저들을 여러번 신고할 수 있다.
//      한 유저를 여러번 신고 가능(동일한 유저에 대한 신고횟수는 1번)
// 2. k번 이상 신고된 유저는 게시판 이용이 정지. 
//      해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
//      유저가 신고한 내용들을 모두 취합하여 한꺼번에 게시판 이용 정지


// 1. 누가 몇 번 신고 당했는지 저장
// 2. 누가 누굴 신고 했는지 저장
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;





class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> userInfo = new HashMap<String,Integer>();
        HashMap<String,Set<String>> reportResult = new HashMap<String,Set<String>>();
        HashMap<String,Set<String>> reporters = new HashMap<String,Set<String>>();
        // 유저 정보 저장 (최대 1000)
        for(int i=0;i<id_list.length;i++){
            userInfo.put(id_list[i],i);
        }
        
        for(int i=0;i<report.length;i++){
            String[] result = report[i].split(" ") ;
            
            String key = result[1]; //신고 당한 사람
            String value = result[0]; //신고한 사람
            
            // 신고 몇번 당했는지 알기 위함
            reportResult.putIfAbsent(key, new HashSet<>());
            reportResult.get(key).add(value);
            
            // 누굴 신고 했는지 알기 위함
            reporters.putIfAbsent(value, new HashSet<>());
            reporters.get(value).add(key);
            
        }
        //해시맵에서 벨류 값이 k 이상이면 정지된 회원     
        int[] answer = new int[id_list.length];
        List<String> reportedList = new ArrayList<>(reportResult.keySet());
        
        for(int i=0;i<reportedList.size();i++){
            // 정지 대상일 경우
            Set<String> reporterSet = reportResult.get(reportedList.get(i));
            if(reporterSet.size()>=k){
                for (String reporter : reporterSet) {
                    Integer userId = userInfo.get(reporter);
                    answer[userId]++;
                }
            }    
        }
        
        
        
        return answer;
    }
}