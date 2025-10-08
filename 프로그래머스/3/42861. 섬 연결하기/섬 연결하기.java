// 최소의 비용으로 모든 섬에 다리를 만들어라
// 섬의 개수 n = 1~100
// costs의 길이 = ((n-1) * n) / 2이하

// 배열의 원소 의미, 0,1번 ->두 섬의 번호, 2 ->다리 건설시 드는 비용

// 입출력 예시를 보면 그래프를 전부 만들고, 최소 거리를 생각하는데 그렇게 하면 안될 것 같음
// 일단 그때그때 최선의 선택으로 최소 비용을 만족하는 길을 만들어야 될 것 같다.


// 루트노드가 하나 일때 -> 최소 비용
// 1. 섬의 개수(n)만큼의 배열 생성,
// 2. 해당 배열을 돌면서, 루트 노드가 하나만 생성되도록 하기&이때 따로 비용은 따로 저장
// 3. 배열이 다찼다는 것은 하나의 루트 노드를 갖는 그래프가 생성되었다는 것이므로 멈추고 비용 리턴 

// 루트 노드는 일단 배열을 각자 번호로 초기화 한뒤
// 유니온-파인드 알고리즘을 적용하면 합쳐질 것 같은..
// 파인드 구현할떄 경로압축 포함
import java.util.Arrays;


class Solution {
    public static int[] parent;
    
    public static int find(int idx){
        if(parent[idx]==idx) return idx;
        else return parent[idx] = find(parent[idx]);
        
    }
    
    public static void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        parent[root1] = root2;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        int answer = 0;
        int edge = 0;
        
        for(int[]cost : costs){
            if(edge==n-1) break;
            
            int node1 = cost[0];
            int node2 = cost[1];
            
            if(find(node1) != find(node2)){
                union(node1,node2);
                answer+=cost[2];
                edge++;
            }
        }
        
        return answer;
    }
}