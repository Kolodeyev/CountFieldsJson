import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckingConditionsTest {

    @BeforeClass
    public static void beforeClass() {

    }

    @Test
    public void tryToCheckValidValue() {

        JsonNode json = JsonTraverser.readJsonFromFile("data.json");
        System.out.println(json.toString());
    }

    @Test
    public void tryToCheckInvalidValue() {

    }

}
