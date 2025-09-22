// 조건
// 동명이인 있을 수 있음

import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String name:completion){
            hashMap.put(name, hashMap.getOrDefault(name,0)+1);
        }
        
        for(String name:participant){
            if(hashMap.getOrDefault(name,0)==0){
                return name;
            }
            hashMap.put(name, hashMap.get(name)-1);
        }   
        return null;
    }
}