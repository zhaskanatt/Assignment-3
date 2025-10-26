import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class OutputWriter {

    public static void writeOutput(List<MSTResult> results, String outputPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(outputPath), results);
    }
}
