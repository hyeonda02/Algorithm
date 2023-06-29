import java.util.PriorityQueue;

class Solution {
    public static int[] solution(int k, int[] score){
        int[] answer=new int[score.length];
        int min = score[0];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            pQueue.add(score[i]);
             while(pQueue.size()>k){
                pQueue.poll();
            }
            answer[i] = pQueue.peek();
        }
        return answer;
    }
}