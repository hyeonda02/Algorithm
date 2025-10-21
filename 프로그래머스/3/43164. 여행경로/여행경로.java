// 항상 ICN에서 출발
// 공항의 개수는 10000개 이하
// 항공권을 모두 사용해야 하고, 못 사용하는 경우는 없음
// 만익 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 reurn

// 1. 그래프를 만든다.
// 2. 간선을 모두 연결한다.
// 3. 그래프를 탐색할때, 해당 노드에서 갈 수 있는 길이 여러개 일 경우, 알파벳 순서로 넣고 뺀다. 

import java.util.*;

class Solution {
    private static final String START = "ICN";
    
    public String[] solution(String[][] tickets) {
        // 1. 그래프 생성 (출발지 → 도착지 PQ)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }
        
        // 2. 결과 리스트, DFS (Hierholzer)
        List<String> route = new ArrayList<>();
        dfs(START, graph, route);
        
        // 3. 경로 뒤집어서 반환
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    private void dfs(String cur, Map<String, PriorityQueue<String>> graph, List<String> route) {
        PriorityQueue<String> pq = graph.get(cur);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, graph, route);
        }
        
        route.add(cur);
    }
}
