import java.util.*;

public class MSTCalculator {

    public static void main(String[] args) throws Exception {
        // Load graph data
        GraphDataLoader loader = new GraphDataLoader();
        List<Graph> graphs = loader.loadGraphs("input.json");

        List<MSTResult> results = new ArrayList<>();
        for (Graph graph : graphs) {
            MSTResult result = new MSTResult();
            result.graphId = graph.id;
            result.inputStats = new InputStats();
            result.inputStats.vertices = graph.nodes.size();
            result.inputStats.edges = graph.edges.size();

            // Run Prim's algorithm
            result.prim = PrimsAlgorithm.findMST(graph);

            // Run Kruskal's algorithm
            result.kruskal = KruskalsAlgorithm.findMST(graph);

            results.add(result);
        }

        // Write the results to output.json
        OutputWriter.writeOutput(results, "output.json");
    }
}
