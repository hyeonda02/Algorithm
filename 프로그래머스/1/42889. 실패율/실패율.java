import java.util.*;


class Solution {
       public static int[] solution(int N, int[] stages) {

        int[] currentStage = new int[N + 1];//도달한 사람
        int[] clearStage = new int[N + 2]; //도달했지만 클리어 못한 사람
        HashMap<Integer, Double> map = new HashMap<>();

        for (int stage : stages) {
            clearStage[stage]++;
        }
        currentStage[N] = clearStage[N] + clearStage[N + 1];
        for (int i = N-1; i >= 1; i--) {
            currentStage[i] = currentStage[i+1] + clearStage[i];
        }
        for (int i = 1; i < currentStage.length; i++) {
            if (clearStage[i] == 0 || currentStage[i] == 0) {
                map.put(i, 0.0);

            }else{
                map.put(i, (double) clearStage[i] / currentStage[i]);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(Integer::intValue).toArray();





    }

}