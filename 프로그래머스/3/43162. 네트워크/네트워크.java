class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private static void dfs(int i, boolean[] visited, int n, int[][] computers){
        visited[i] = true;
        for(int j=0;j<n;j++){
            if(i!=j&&!visited[j]&&computers[i][j]==1){
                dfs(j,visited,n,computers);
            }
        }
    }
}