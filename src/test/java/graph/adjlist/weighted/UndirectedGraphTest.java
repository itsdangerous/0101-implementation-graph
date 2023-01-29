package graph.adjlist.weighted;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UndirectedGraphTest {
	static UndirectedGraph g;
	
	@BeforeEach
	void beforeEach() {
		g = new UndirectedGraph(5);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 5,2 );
		g.addEdge(3, 2, 3);
		g.addEdge(4, 1, 4);
		g.addEdge(4, 5, 5);
	}
	
	@DisplayName("연결된 edge Test")
	@ParameterizedTest(name = "{index}: {2}")
	@MethodSource("correctConnectionParameters")
	void EdgeConnectionTest(int v1, int v2, String testName) {
		assertThat(isConnected(v1, v2)).isTrue();
	}
	
	private static Stream<Arguments> correctConnectionParameters() {
		return Stream.of(
				Arguments.of(1, 5, "test1"),
				Arguments.of(5, 1, "test2"),
				Arguments.of(3, 2, "test3"),
				Arguments.of(2, 3, "test4"),
				Arguments.of(4, 1, "test5"),
				Arguments.of(1, 4, "test6")
		);
	}
	
	@DisplayName("연결되지 않은 edge Test")
	@ParameterizedTest(name = "{index}: {2}")
	@MethodSource("InvalidConnectionParameters")
	void EdgeInvalidConnectionTest(int v1, int v2, String testName) {
		assertThat(isConnected(v1, v2)).isFalse();
	}
	
	private static Stream<Arguments> InvalidConnectionParameters() {
		return Stream.of(
				Arguments.of(1, 3, "test1"),
				Arguments.of(2, 4, "test2"),
				Arguments.of(2, 5, "test3"),
				Arguments.of(3, 5, "test4"),
				Arguments.of(3, 1, "test5")
		);
	}
	
	private boolean isConnected(int v1, int v2) {
		return g.adjList[v1].stream().anyMatch(node -> node.nodeNumber == v2);
	}
	
	@ParameterizedTest(name = "{index} : {3}")
	@MethodSource("weightTestParameters")
	@DisplayName("가중치 Test")
	void weightTest(int from, int to, int weight, String testName) {
		assertThat(findWeight(from, to)).isEqualTo(weight);
	}
	
	private int findWeight(int v1, int v2) {
		return g.adjList[v1].stream().filter(node -> node.nodeNumber == v2)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("해당 간선 없음"))
				.weight;
	}
	
	private static Stream<Arguments> weightTestParameters() {
		return Stream.of(
				Arguments.of(1, 2, 1, "test1"),
				Arguments.of(2, 1, 1, "test2"),
				Arguments.of(1, 5, 2, "test3"),
				Arguments.of(5, 1, 2, "test4"),
				Arguments.of(3, 2, 3, "test5"),
				Arguments.of(2, 3, 3, "test6"),
				Arguments.of(4, 1, 4, "test7"),
				Arguments.of(1, 4, 4, "test8"),
				Arguments.of(4, 5, 5, "test9"),
				Arguments.of(5, 4, 5, "test10")
		);
	}
}