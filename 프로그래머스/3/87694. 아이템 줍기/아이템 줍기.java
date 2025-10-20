// 와.. 너무 어려움
// 예제 1번의 경우 각 사각형의 모든 좌표

// (1,1), (1,4), (7,1) (7,4), 
// (3,2), (5,5), (3,5), (5,2)
// (4,3), (6,9), (4,9), (6,3)
// (2,6), (8,8), (2,8), (8,6)



// 다른 사각형 안에 포함된 x.y 좌표를 지우는게 맞나? 
// 좌표의 범위 : 1~50
// 좌표의 범위가 생각보다 크지 않음. -> 각 사각형의 모든 좌표를 넣어두고 BFS?


// board [][] -> 외곽선만 두고, 사각형 내부는 지우기 
// 꼭짓점만 만나는 경우 없음, 변만 겹치는 경우 없음


import java.util.*;

class Solution {
    static final int SIZE = 102; // 좌표 범위 (1~50)*2 

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[SIZE][SIZE];

        // 외곽선을 그리기 (좌표 2배)
        for (int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2;
            int x2 = r[2] * 2, y2 = r[3] * 2;

            // 테두리 부분 1로 채우기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    // 경계면은 1, 내부는 2
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (board[x][y] != 2) board[x][y] = 1;
                    } else {
                        board[x][y] = 2;
                    }
                }
            }
        }

        boolean[][] visited = new boolean[SIZE][SIZE];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (x == itemX * 2 && y == itemY * 2) {
                return d / 2; 
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] != 1) continue; 

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, d + 1});
            }
        }

        return -1; 
    }
}
