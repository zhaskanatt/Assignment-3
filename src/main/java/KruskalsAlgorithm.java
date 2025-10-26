import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    public static AlgorithmResult findMST(Graph graph) {
        int vertices = graph.nodes.size();
        List<Edge> mstEdges = new ArrayList<>();
        Collections.sort(graph.edges, Comparator.comparingInt(e -> e.weight));

        UnionFind unionFind = new UnionFind(vertices);
        int operationsCount = 0;
        long startTime = System.nanoTime();

        for (Edge edge : graph.edges) {
            int fromIndex = graph.nodes.indexOf(edge.from);
            int toIndex = graph.nodes.indexOf(edge.to);

            if (unionFind.find(fromIndex) != unionFind.find(toIndex)) {
                mstEdges.add(edge);
                unionFind.union(fromIndex, toIndex);
                operationsCount++;
            }
            operationsCount++;
        }

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1_000_000.0;

        int totalCost = mstEdges.stream().mapToInt(e -> e.weight).sum();
        return new AlgorithmResult(mstEdges, totalCost, operationsCount, executionTimeMs);
    }
}


class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
