import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GraphDataLoader {

    public List<Graph> loadGraphs(String filePath) throws IOException {
        // Load the file from the resources folder using the class loader
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

        // Check if the file exists in the resources
        if (inputStream == null) {
            throw new IOException("File not found: " + filePath);
        }

        // Use Jackson to read the JSON into the GraphsWrapper class
        ObjectMapper objectMapper = new ObjectMapper();
        GraphsWrapper wrapper = objectMapper.readValue(inputStream, GraphsWrapper.class);

        return wrapper.graphs; // Return the list of graphs
    }
}
