package graph.adjmatrix.nonweighted;

public class UndirectedGraph {
    int[][] adjMatrix;
    
    public UndirectedGraph(int size) {
    	//TODO : 생성자 구현 -> adjMatrix 초기화
        adjMatrix = new int[size + 1][size + 1];
    }
    
    public void addEdge(int v1, int v2) {
    	//TODO : 간선 추가 메서드 구현
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }
}
