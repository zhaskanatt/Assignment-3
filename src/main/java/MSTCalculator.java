import java.util.ArrayList;
import java.util.List;

public class MSTCalculator {

    public static void main(String[] args) throws Exception {
        GraphDataLoader loader = new GraphDataLoader();
        List<Graph> graphs = loader.loadGraphs("input.json");

        List<MSTResult> results = new ArrayList<>();
        for (Graph graph : graphs) {
            MSTResult result = new MSTResult();
            result.graphId = graph.id;
            result.inputStats = new InputStats();
            result.inputStats.vertices = graph.nodes.size();
            result.inputStats.edges = graph.edges.size();

            result.prim = PrimsAlgorithm.findMST(graph);

            result.kruskal = KruskalsAlgorithm.findMST(graph);

            results.add(result);
        }

        OutputWriter.writeOutput(results, "output.json");
    }
}
