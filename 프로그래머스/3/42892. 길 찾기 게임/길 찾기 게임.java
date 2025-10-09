// 전위 순회, 후위 순회한 결과를 리턴
// nodeinfo의 길이는 1~10000
// 트리의 깊이는 1000 이하

// 좌표를 가지고 이진 트리 구현..?
// 루트 노드는 y값이 가장 큰 노드 -> y 값을 내림차순 수 이진 트리 구현, 노드는 좌표값을 가지고 있음

// 1. 이진 트리를 구현한다.
//      -> 루트 노드는 y값이 가장 큰 노드, y값을 내림차순 후 트리 만들기
// 2. 트리를 전위, 후위 순회를 한다.
//      -> 전위 순회 메서드, 후위 순회 메서드 생성
import java.util.ArrayList;
import java.util.Arrays;



class Solution {
    public static class Node{
        int x, y, number;
        Node left, right;
        
        public Node(int x, int y, int number){
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }

    // 트리 생성
    private Node makeTree(int[][] nodeList){
        //  Node 배열로 만듬
        Node[] nodes = new Node[nodeList.length];
        for(int i=0;i<nodeList.length;i++){
            nodes[i] = new Node(nodeList[i][0],nodeList[i][1],i+1);
            
        }
        // Node 배열을 y값을 내림차순으로 정렬, y값 같다면 x는 오룸차순
        Arrays.sort(nodes,(o1,o2)->{
            if(o1.y==o2.y) return Integer.compare(o1.x,o2.x);
            return Integer.compare(o2.y,o1.y);
            
        });
        // 루트 노드는 0번, 나머지는 x값 비교 후 트리 생성
        Node rootNode = nodes[0];
        for(int i=1;i<nodes.length;i++){
            insertNode(rootNode, nodes[i]);  
        }
        return rootNode;
        
        
    }
        // 노드 insert
    private void insertNode(Node parent, Node child){
        while(true){
            if(child.x<parent.x){
                if(parent.left==null){
                    parent.left = child;
                    break;
                }else{
                    parent = parent.left;
                }
            }else{
                if(parent.right==null){
                    parent.right=child;
                    break;
                }else{
                    parent = parent.right;
                }
                
            }
        }
    }
    
    // 전위 순회 (루트->왼->오)
    private void preOrder(Node root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        
        list.add(root.number);
        preOrder(root.left,list);
        preOrder(root.right,list);
        
    }
    
    // 후위 순회 (왼->오->루트)
    private void postOrder(Node root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.number);
        
    }
    
    public int[][] solution(int[][] nodeinfo) {
        Node root = makeTree(nodeinfo);
        ArrayList<Integer> preList = new ArrayList<>();
        preOrder(root, preList);
        ArrayList<Integer> postList = new ArrayList<>();
        postOrder(root, postList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
        
    }
}