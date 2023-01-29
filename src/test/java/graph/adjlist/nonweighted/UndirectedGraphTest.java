package graph.adjlist.nonweighted;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UndirectedGraphTest {
	
	static UndirectedGraph g;
	
	@BeforeEach
	void beforeEach() {
		g = new UndirectedGraph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(3, 2);
		g.addEdge(4, 1);
		g.addEdge(4, 5);
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
		return g.adjList[v1].stream().anyMatch(node -> node == v2);
	}

}
