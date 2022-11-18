import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckingConditionsTest {

    @Test
    public void countExpectedFields() {
        JsonTraverser jsonTraverser = new JsonTraverser("data.json");
        List<JsonNode> jsonTree =  jsonTraverser.readTree("cars");
        Assert.assertEquals(jsonTree.size(), 5, "Actual count of found fields is not valid!");
    }

    @Test
    public void countAbsentFields() {
        JsonTraverser jsonTraverser = new JsonTraverser("data.json");
        List<JsonNode> jsonTree =  jsonTraverser.readTree("qwerty");
        Assert.assertEquals(jsonTree.size(), 0, "Actual count of found fields is not valid!");
    }

    @Test
    public void countExpectedValue() {
        JsonTraverser jsonTraverser = new JsonTraverser("data.json");
        List<JsonNode> jsonTree =  jsonTraverser.readTree("cars");
        CheckingConditions checkingConditions = new CheckingConditions("data.json", "cars", "bmw");
        List<String> expectedValue = checkingConditions.reedValue(jsonTree);
        Assert.assertEquals(expectedValue.size(), 3, "Actual count of value is not valid!");
    }

    @Test
    public void countAbsentValue() {
        JsonTraverser jsonTraverser = new JsonTraverser("data.json");
        List<JsonNode> jsonTree =  jsonTraverser.readTree("cars");
        CheckingConditions checkingConditions = new CheckingConditions("data.json", "cars", "qwerty");
        List<String> expectedValue = checkingConditions.reedValue(jsonTree);
        Assert.assertEquals(expectedValue.size(), 0, "Actual count of value is not valid!");
    }

}
