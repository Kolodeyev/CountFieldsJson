import com.fasterxml.jackson.databind.JsonNode;

public class Main {

    public static void main(String[] args) {

//        String path = "data.json";
//        String expectedName = "cars";
//        String expectedValue = "bmw";

        String path = args[0];
        String expectedName = args[1];
        String expectedValue = args[2];

        JsonNode jsonNode = JsonBuilderAndParser.readJsonFromFile(path);
        JsonBuilderAndParser.findRepeatingFields(jsonNode);
        CheckingConditions.countSpecificValueInFields(JsonBuilderAndParser.foundFields, expectedValue);

        System.out.println("- found " + JsonBuilderAndParser.foundFields.size()
                + " objects with field '" + expectedName + "'");
        System.out.println("- found " + CheckingConditions.getValueCount()
                + " objects where '"
                + expectedName + "' equals '" + expectedValue + "'");

    }
}
