import com.fasterxml.jackson.databind.JsonNode;

public class Main {

    public static void main(String[] args) {

        String path = "data.json";
        JsonTraverser.EXPECTED_NAME = "cars";
        CheckingConditions.EXPECTED_VALUE = "bmw";

//        String path = args[0];
//        JsonTraverser.EXPECTED_NAME = args[1];
//        CheckingConditions.EXPECTED_VALUE = args[2];

        JsonNode jsonNode = JsonTraverser.readJsonFromFile(path);
        JsonTraverser.traverseTree(jsonNode);

        System.out.println("- found " + JsonTraverser.foundFields.size()
                + " objects with field '" + JsonTraverser.EXPECTED_NAME + "'");
        System.out.println("- found " + CheckingConditions.valueSize()
                + " objects where '"
                + JsonTraverser.EXPECTED_NAME + "' equals '" + CheckingConditions.EXPECTED_VALUE + "'");

    }
}
