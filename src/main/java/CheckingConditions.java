import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class CheckingConditions extends JsonTraverser {

    private final String JSON_PATH;
    private final String FIELD_NAME;
    public final String VALUE;
    private final List<String> RESULT_VALUE = new ArrayList<>();

    public CheckingConditions(String jsonPath, String fieldName, String value) {
        super(jsonPath);
        JSON_PATH = jsonPath;
        this.FIELD_NAME = fieldName;
        this.VALUE = value;
    }

    public List<String> reedValue(List<JsonNode> jsonTree) {

        for (JsonNode currentJson : jsonTree) {
            if (currentJson.isArray()) {
                for (JsonNode currentValue : currentJson) {
                    if (currentValue.asText().equalsIgnoreCase(VALUE)) {
                        RESULT_VALUE.add(currentValue.asText());
                    }
                }
            }
            if (currentJson.asText().equalsIgnoreCase(VALUE)) {
                RESULT_VALUE.add(currentJson.asText());
            }
        }
        return RESULT_VALUE;
    }

    public void createResults() {
//        JsonTraverser jsonTraverser = new JsonTraverser(JSON_PATH);
        List<JsonNode> jsonTree = readTree(FIELD_NAME);
//        CheckingConditions checkingConditions = new CheckingConditions(JSON_PATH, FIELD_NAME, VALUE);
        reedValue(jsonTree);

        System.out.println("- found " + jsonTree.size()
                + " objects with field '" + FIELD_NAME + "'");
        System.out.println("- found " + RESULT_VALUE.size()
                + " objects where '"
                + FIELD_NAME + "' equals '" + VALUE + "'");

    }
    public int getFieldSize() {
        return readTree(this.FIELD_NAME).size();
    }

    public int getValueSize() {
        return RESULT_VALUE.size();
    }

}
