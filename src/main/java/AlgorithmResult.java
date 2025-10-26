import java.util.List;

class AlgorithmResult {
    public List<Edge> mstEdges;
    public int totalCost;
    public int operationsCount;
    public double executionTimeMs;

    public AlgorithmResult(List<Edge> mstEdges, int totalCost, int operationsCount, double executionTimeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationsCount = operationsCount;
        this.executionTimeMs = executionTimeMs;
    }
}