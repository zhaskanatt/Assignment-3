import java.util.*;

public class PrimsAlgorithm {

    public static AlgorithmResult findMST(Graph graph) {
        int vertices = graph.nodes.size();
        List<Edge> mstEdges = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int operationsCount = 0;
        long startTime = System.nanoTime();

        visited.add(graph.nodes.get(0));
        for (Edge edge : graph.edges) {
            if (edge.from.equals(graph.nodes.get(0)) || edge.to.equals(graph.nodes.get(0))) {
                pq.offer(edge);
                operationsCount++;
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            operationsCount++;

            if (!visited.contains(edge.to)) {
                visited.add(edge.to);
                mstEdges.add(edge);
                for (Edge e : graph.edges) {
                    if ((e.from.equals(edge.to) || e.to.equals(edge.to)) && !visited.contains(e.to)) {
                        pq.offer(e);
                        operationsCount++;
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        double executionTimeMs = (endTime - startTime) / 1_000_000.0;

        int totalCost = mstEdges.stream().mapToInt(e -> e.weight).sum();
        return new AlgorithmResult(mstEdges, totalCost, operationsCount, executionTimeMs);
    }
}
