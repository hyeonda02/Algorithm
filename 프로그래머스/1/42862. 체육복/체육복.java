// 바로 앞이나 뒤 번호 학생한테 체육복 전달 가능
// 한명은 딱 한명만 빌려줄 수 있음
// 총 수업을 들을 수 있는 학생의 수를 리턴

// 최대한 근처에 여벌을 적게 가지고 있는 사람 먼저 고려
// 예를 들어
// lost가 2,4이고
// reserve가 3,5이면
// 2-3, 4-5가 되어야 함

// 도난 당한 학생이.. 여벌옷 있을 수 있음
// 이 옷이 누구를 위한 옷일까 고민, 다른 도난당한 사람 주변의 여벌 옷을 고려 해야됨
import java.util.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        
        // 1. 여벌옷 존재여부를 빠르게 확인하기 위해 set 사용
        HashSet<Integer> sets = new HashSet<>();
        for(int i=0;i<reserve.length;i++){
            sets.add(reserve[i]);
        }
        List<Integer> need = new ArrayList<>();
        
        // 2. 자기가 도난 당함 & 자기 여벌옷 있음 일 경우, set에서 제거
        // 여벌옷 없으면 아직 체육복 못받은 사람 -> need 에 넣음
        for (int l : lost) {
            if (sets.contains(l)) {
                sets.remove(l);
            } else {
                need.add(l);
            }
        }
        // 3. 정답 정의 (총 학생수 - 체육복 없는 사람)
        int answer = n - need.size();
        for (int l : need) {
            // 체육복 없으면 왼쪽 부터 확인 (오른쪽 사람들 중에서 아직 체육복 없는 사람 존재)
            if (sets.contains(l - 1)) {
                sets.remove(l - 1);
                answer++;
            } else if (sets.contains(l + 1)) {
                sets.remove(l + 1);
                answer++;
            }
        }

        
        return answer;
    }
}