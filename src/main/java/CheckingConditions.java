import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class CheckingConditions {

    public static String EXPECTED_VALUE;

    public static int valueSize() {

        List<String> foundValue = new ArrayList<>();

        for (JsonNode currentJson : JsonTraverser.foundFields) {
            if (currentJson.isArray()) {
                for (JsonNode currentValue : currentJson) {
                    if (currentValue.asText().equalsIgnoreCase(EXPECTED_VALUE)) {
                        foundValue.add(currentValue.asText());
                    }
                }
            }
            if (currentJson.asText().equalsIgnoreCase(EXPECTED_VALUE)) {
                foundValue.add(currentJson.asText());
            }
        }
        return foundValue.size();
    }

}
