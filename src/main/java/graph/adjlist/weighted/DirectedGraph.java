package graph.adjlist.weighted;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class DirectedGraph {
    ArrayList<Node>[] adjList;
    
    public DirectedGraph(int size) {
    	//TODO : 생성자 구현 -> adjList 초기화
        adjList = new ArrayList[size+1];
        for (int i = 0; i < size + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
     
    }
    public void addEdge(int from, int to, int weight) {
    	//TODO : 간선 추가 메서드 구현
        adjList[from].add(new Node(to, weight)); // nonweighted와 달리, Node를 추가해줌. 노드는 고유 노드넘버와 가중치를 갖고있음

     
    }
    
    // 노드 번호와 weight를 저장하는 클래스 생성
    static class Node {
    	int nodeNumber;
        int weight;
    	
    	public Node() { // default
    		// TODO: 생성자 만들기 -> 파라미터 추가 필요!
    	}

        public Node(int nodeNumber, int weight) {
            this.nodeNumber = nodeNumber;
            this.weight = weight;
        }
    }
}
