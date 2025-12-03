// 갈색 10, 노랑 2
// 노랑 2개를 갈색으로 채우려면 최소 6개 필요 + 꼭짓점 4개 

// 갈색 8, 노랑 1
// 노랑 1개를 갈색으로 채우려면 최소 4개 필요 + 꼭짓점 4개 

// 갈색 24, 노랑 24
// 노랑 4*6 = 24
// 노랑 가로 24로 해도 됨
// 근데 가로의 길이가 길어질 수록 갈색 테두리의 개수가 줄어듬

// 노랑의 가로 세로를 미리 정하고, 필요한 갈색의 수를 계산해서 확인 
// 노랑의 가로 세로는 나머지가 생기지 않는 길이
import java.util.*;


class Solution {
    public int[] solution(int brown, int yellow) {

        for (int yellowHight = 1; yellowHight <= yellow; yellowHight++) {
            if (yellow % yellowHight != 0) continue;
            
            int yellowWidth = yellow / yellowHight;
            int brownCount = (yellowHight + yellowWidth)*2 + 4;

            if (brownCount == brown) {
                return new int[] {yellowWidth + 2, yellowHight + 2};
            }
        }
        return null;
    }
}
