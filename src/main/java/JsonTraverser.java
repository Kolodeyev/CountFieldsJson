import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonTraverser {

    private final String JSON_PATH;
    private String FIELD_NAME;


    private final List<JsonNode> FIELD_TREE = new ArrayList<>();

    public JsonTraverser(String jsonPath) {
        this.JSON_PATH = jsonPath;
    }

    public List<JsonNode> readTree(String fieldName) {
        this.FIELD_NAME = fieldName;
        JsonNode jsonNode = readJsonFromFile(JSON_PATH);
        return traverseJsonTree(jsonNode);
    }

    /*

     */
    private JsonNode readJsonFromFile(String path) {
        FileReader file = null;
        try {
            file = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    /*

     */
    private List<JsonNode> traverseJsonTree(JsonNode jsonNode) {

        if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode element = arrayNode.get(i);
                traverseJsonTree(element);
            }
        } else if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> field = jsonNode.fields();
            while (field.hasNext()) {
                Map.Entry<String, JsonNode> currentIterator = field.next();
                if (currentIterator.getKey().equalsIgnoreCase(FIELD_NAME)) {
                    FIELD_TREE.add(currentIterator.getValue());
                    continue;
                }
                traverseJsonTree(currentIterator.getValue());
            }
        }
        return FIELD_TREE;
    }

}
