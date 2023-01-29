package graph.adjmatrix.weighted;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DirectedGraphTest {
	static DirectedGraph g;
	
	@BeforeEach
	void beforeEach() {
		g = new DirectedGraph(5);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 5,2 );
		g.addEdge(3, 2, 3);
		g.addEdge(4, 1, 4);
		g.addEdge(4, 5, 5);
	}
	
	@DisplayName("연결된 edge Test")
	@ParameterizedTest(name = "{index}: {2}")
	@MethodSource("correctConnectionParameters")
	void EdgeConnectionTest(int from, int to, String testName) {
		assertThat(isConnected(from, to)).isTrue();
	}
	
	private static Stream<Arguments> correctConnectionParameters() {
		return Stream.of(
				Arguments.of(1, 5, "test1"),
				Arguments.of(3, 2, "test2"),
				Arguments.of(4, 1, "test3"),
				Arguments.of(4, 5, "test4"),
				Arguments.of(1, 2, "test5")
		);
	}
	
	@DisplayName("연결되지 않은 edge Test")
	@ParameterizedTest(name = "{index}: {2}")
	@MethodSource("InvalidConnectionParameters")
	void EdgeInvalidConnectionTest(int from, int to, String testName) {
		assertThat(isConnected(from, to)).isFalse();
	}
	
	private static Stream<Arguments> InvalidConnectionParameters() {
		return Stream.of(
				Arguments.of(5, 1, "test1"),
				Arguments.of(2, 3, "test2"),
				Arguments.of(1, 4, "test3"),
				Arguments.of(5, 4, "test4"),
				Arguments.of(3, 5, "test5"),
				Arguments.of(2, 4, "test5")
		);
	}
	
	private boolean isConnected(int from, int to) {
		return g.adjMatrix[from][to] != 0;
	}
	
	@ParameterizedTest(name = "{index} : {3}")
	@MethodSource("weightTestParameters")
	@DisplayName("가중치 Test")
	void weightTest(int from, int to, int weight, String testName) {
		assertThat(g.adjMatrix[from][to]).isEqualTo(weight);
	}
	
	private static Stream<Arguments> weightTestParameters() {
		return Stream.of(
				Arguments.of(1, 2, 1, "test1"),
				Arguments.of(1, 5, 2, "test2"),
				Arguments.of(3, 2, 3, "test3"),
				Arguments.of(4, 1, 4, "test4"),
				Arguments.of(4, 5, 5, "test5")
		);
	}
}
