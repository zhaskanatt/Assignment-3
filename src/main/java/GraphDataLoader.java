import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GraphDataLoader {

    public List<Graph> loadGraphs(String filePath) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);


        if (inputStream == null) {
            throw new IOException("File not found: " + filePath);
        }


        ObjectMapper objectMapper = new ObjectMapper();
        GraphsWrapper wrapper = objectMapper.readValue(inputStream, GraphsWrapper.class);

        return wrapper.graphs;
    }
}
