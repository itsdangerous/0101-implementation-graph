package graph.adjmatrix.nonweighted;

public class DirectedGraph {
    int[][] adjMatrix;
    
    public DirectedGraph(int size) {
    	//TODO : 생성자 구현 -> adjMatrix 초기화
        adjMatrix = new int[size + 1][size + 1];
    }
    
    public void addEdge(int from, int to) {
    	//TODO : 간선 추가 메서드 구현
        adjMatrix[from][to] = 1;
    }
}
