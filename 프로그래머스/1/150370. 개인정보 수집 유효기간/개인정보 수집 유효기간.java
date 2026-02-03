// 1~20 : terms.length -> 약관의 유효 기간을 담음
// 1~100 : privacies.length -> 수집된 개인정보의 정보를 담음 

// 파기해야 하는 개인정보 번호 담아서 리턴
import java.util.*;

class Solution {
    public Map<String, Integer> termMap;
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1. 약관 유효 기간 termMap 정의
        termMap = new HashMap<>();
        for(String s: terms){
            String[] arr = s.split(" ");
            termMap.put(arr[0],Integer.parseInt(arr[1]));
        }
        
        // 2. 오늘 날짜 정리하기
        String[] todayArr = today.split("\\.");
        int[] todayDate = new int[3];
        for(int i=0;i<3;i++){
            todayDate[i] = Integer.parseInt(todayArr[i]);
        }
        
        // 3. 약관 정리하기
        int num = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(String p : privacies){
            String[] temp = p.split(" ");
            String[] startDate = temp[0].split("\\.");
            String t = temp[1];
            
            int[] startDateInt = new int[3];
            for(int i=0;i<3;i++){
                startDateInt[i] = Integer.parseInt(startDate[i]);
            }
            
            // 유효기간 넘었는지 판단
            if(isDelete(startDateInt, todayDate, t)) list.add(num);
            num++;
            
        }
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean isDelete(int[] startDate, int[] todayDate, String term) {
        int validMonth = termMap.get(term);
        
        int year = startDate[0];
        int month = startDate[1] + validMonth;
        int day = startDate[2];
        
        while(month>12){
            month-=12;
            year++;
        }
        
        if (todayDate[0]>year) return true;
        if (todayDate[0]<year) return false;

        if (todayDate[1]>month) return true;
        if (todayDate[1]<month) return false;

        return todayDate[2]>=day;
        
    }
}