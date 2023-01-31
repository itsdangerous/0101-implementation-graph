package graph.adjlist.nonweighted;
import java.util.ArrayList;

public class DirectedGraph {
    ArrayList<Integer>[] adjList;
    
    public DirectedGraph(int size) {
    	//TODO : 생성자 구현 -> adjList 초기화
        adjList = new ArrayList[size+1]; // 리스트 선언

        for (int i = 0; i < size + 1; i++) {
            adjList[i] = new ArrayList<>(); // 2차원 배열 생성 및 초기화
        }
    }

    
    public void addEdge(int from, int to) {
    	//TODO : 간선 추가 메서드 구현
        adjList[from].add(to); // 간선 추가
    	
    }
}
