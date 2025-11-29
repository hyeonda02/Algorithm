// HEAD : 일단 기본 사전순
// NUM : 숫자순 -> 9,10 > 0011 > 012 > 13 > 014
// TAIL : 앞에 두 부분이 같을 경우, 먼저 들어온 순으로


// 1. 리스트에  files안의 요소들을 번호+원본 넣음
// 2. 각 요소들을 확인하면서 대문자 -> 소문자로 변경, 숫자의 경우 0빼기
// 3. 위 정렬 조건에 따라 정렬하기

import java.util.*;


class Solution {
    class File{
        int index;
        String head;
        int num;
        String fullname;
        
        File(String head, int num, String fullname, int index) {
            this.head = head;
            this.num = num;
            this.fullname = fullname;
            this.index = index;
        }
    }
    
    public String[] solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();
        for(int i=0;i<files.length;i++){
            String file = files[i];
            int idx = 0;
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            String head = file.substring(0, idx).toLowerCase();
            // 여기까지 HEAD 찾기 & 소문자로 변경
            
            // 숫자 찾기 (최대 5글자)
            int numStart = idx;
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                idx++;
                if (idx - numStart == 5) break;
            }
            int num = Integer.parseInt(file.substring(numStart, idx));
            list.add(new File(head,num,file,i+1));  
        }
        // 정렬하기
        Collections.sort(list,(a,b)->{
            // 1. HEAD 비교 (사전 순서)
            if(a.head.compareTo(b.head)!=0) return a.head.compareTo(b.head);
            // 2. 숫자 비교
            if(a.num!=b.num) return a.num-b.num;
            // 3. 인덱스 비교
            return a.index-b.index;
            
        });
            
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i).fullname;
        }
        return answer;
        
        
        
    }
}