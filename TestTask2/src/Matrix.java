import static java.lang.Math.min;
import static java.util.Arrays.fill;

public class Matrix {
    private final int INFINITY = 10001;
    // Adjacency matrix
    private int[][] cost;

    public Matrix(int vertices) {
        cost = new int[vertices][vertices];
    }

    public void setEdge(int i, int j, int weight) {
        cost[i][j] = weight;
    }

    private int getCost(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (cost[i][j] == 0) {
            return INFINITY;
        }
        return cost[i][j];
    }

    private int getUntaggedVertex(Integer[] result, boolean[] visited) {
        int best = -1;
        for (int i = 0; i < cost.length; i++) { // Sort out the vertices
            if (!visited[i] && ((best < 0) || (result[i] < result[best]))) { // Select the closest untagged vertex
                best = i;
            }
        }
        return best;
    }

    public Integer[] waysOfMinimumCostBetweenPairsOfCities(int startIndex) {
        boolean[] visited = new boolean[cost.length];// visit the city
        Integer[] result = new Integer[cost.length]; // distance array
        fill(result, INFINITY);                      // set the distance to all vertices INFINITY
        result[startIndex] = startIndex;             // initial vertex

        for (int[] aCost : cost) {
            int city = getUntaggedVertex(result, visited);
            visited[city] = true;
            for (int j = 0; j < cost.length; j++) {
                result[j] = min(result[j], result[city] + getCost(city, j));
            }
        }
        return result;
    }
}
