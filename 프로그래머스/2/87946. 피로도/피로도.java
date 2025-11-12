// 최소 필요 피로도
// 던전 탐험 후 소모 피로도

// 던전 여러개 존재, 최대한 많이 탐험
// 유저가 탐험할 수 있는 최대 던전의 수
// 1,2,3 -> (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), (3,2,1)

// 1. 순열 경우의 수 생성?
// 2. 탐색 (DFS)
// 3. (이미 방문한 곳, 최소 필요 피로도 만족 x -> 백트래킹)

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
        
    }
    
    public void dfs(int k, int[][] dungeons, int count){
        answer = Math.max(answer, count);
        
        for(int i=0;i<dungeons.length;i++){
            int need = dungeons[i][0];
            int consume = dungeons[i][1];
            
            // 이미 방문한 곳 아니고, 최소 필요 피로도 만족하면 진행
            if(!visited[i] && k>=need){
                visited[i] = true;
                dfs(k-consume, dungeons, count+1);
                visited[i] = false;
                
            }
        } 
        
    }
}