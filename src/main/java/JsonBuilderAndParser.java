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

public class JsonBuilderAndParser {

    public static List<Object> foundFields = new ArrayList<>();

    /*

     */
    public static JsonNode readJsonFromFile(String path) {
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
    public static void findRepeatingFields(JsonNode jsonNode) {

        if (jsonNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) jsonNode;
            for (int i = 0; i < arrayNode.size(); i++) {
                JsonNode element = arrayNode.get(i);
                findRepeatingFields(element);
            }
        } else if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> field = jsonNode.fields();
            while (field.hasNext()) {
                Map.Entry<String, JsonNode> currentIterator = field.next();
                if (currentIterator.getKey().equalsIgnoreCase("cars")) {
                    foundFields.add(currentIterator.getValue());
                } else if (currentIterator.getValue().isContainerNode()) {
                    findRepeatingFields(currentIterator.getValue());
                }
            }
        }
    }

}
