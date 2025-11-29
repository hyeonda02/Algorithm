// {{4,2,3},{3},{2,3,4,1},{2,3}}

// {3} ->3
// {2,3} ->2
// {4,2,3} -> 4 
// {2,3,4,1} -> 1

// 최종 답 3,2,4,1

// 길이순으로 정렬하고 아직 안나온 숫자를 뽑아서 넣기

import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 파싱하기
        List<int[]> list = new ArrayList<>();
        
        String innerStr = s.substring(2, s.length()-2); // 2},{2,1},{2,1,3},{2,1,3,4
        String[] inner = innerStr.split("\\},\\{");
        
        for(int i=0;i<inner.length;i++){
            String[] nums = inner[i].split(",");
            int[] intarr = new int[nums.length];
            for(int j=0;j<nums.length;j++){
                intarr[j] = Integer.parseInt(nums[j]);
            }
            list.add(intarr);
        }
        
        // 길이 기준으로 정렬하기
        list.sort(Comparator.comparingInt(a->a.length));
        
        // 안나온 숫자 확인후 넣기
        List<Integer> answer = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int[] arr: list){
            for(int num : arr){
                if(seen.add(num)){
                     answer.add(num);
                    break;   
                }
            }
        }
          
        return answer.stream().mapToInt(Integer::intValue).toArray();
        
    }
}