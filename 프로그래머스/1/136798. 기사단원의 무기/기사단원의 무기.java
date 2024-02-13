import java.util.ArrayList;

class Solution {
        public int solution(int number, int limit, int power) {
        int answer =0;
        int[] numList = returnFactor(number);
        for (int target :numList) {
            if (target > limit) {
                answer += power;
            }else{
                answer += target;
            }
        }
        return answer;
    }
    public int[] returnFactor(int number) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i <= number; i++) {
            int num =0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    num++;
                    if (j != i / j) {
                        num++;
                    }
                }
            }
            list.add(num);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();


    }

}