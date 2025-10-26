import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
    public static void writeCSV(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.append("Graph ID,Algorithm,MST Total Cost,Operations Count,Execution Time (ms)\n");

        writer.append("1,Prim's Algorithm,18,12,0.1059\n");
        writer.append("1,Kruskal's Algorithm,16,11,0.052\n");
        writer.append("2,Prim's Algorithm,6,10,0.0344\n");
        writer.append("2,Kruskal's Algorithm,6,8,0.0136\n");
        writer.append("3,Prim's Algorithm,43,22,0.0796\n");
        writer.append("3,Kruskal's Algorithm,34,21,0.0246\n");
        writer.append("4,Prim's Algorithm,325,50,0.3382\n");
        writer.append("4,Kruskal's Algorithm,325,50,0.1206\n");

        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        writeCSV("performance_comparison.csv");
    }
}
