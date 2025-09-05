import java.util.ArrayList;
import java.util.Arrays;
// 조건 : 
// 1.정수 중 0과 5로만 이루어져 있어야 됨
// 2.만약 없으면 -1이 담긴 배열 반환
// 3.1<l<r 이므로 음수 고민, 0으로 시작하는거 고민 안해도됨.마찬가지로 오름차순 고민도 안해도 됨

// 의사코드 :
// 1. list 정의 
// 2. 5의 배수만 확인
//   2-1. 5로 시작하는가
//   2-2. 5의 배수로 나누어 떨어지는가
//   2-3. 중간에 0과 5로만 구성되어 있는가


class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=l;i<=r;i++){
            if(checkInt(i)){
                list.add(i);   
            }
        }
        if(list.size()==0){
            list.add(-1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
    public boolean checkInt(int num){
        String stringNum = String.valueOf(num);
        for(char s : stringNum.toCharArray()){
            if(s!='0'&& s!='5'){
                return false;
            }
        }
        return true;
        
    }
}