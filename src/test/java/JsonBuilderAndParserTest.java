import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class JsonBuilderAndParserTest {

    private static final Logger LOG = Logger.getLogger(JsonBuilderAndParserTest.class);

    @BeforeClass
    public static void beforeClass() {

    }

    @Test
    public void tryToReadFromAbsentFile() {
        JsonNode json =  JsonBuilderAndParser.readJsonFromFile("data000.json");
        System.out.println("File is absent, json is null:" + json.isNull());

    }

    @Test
    public void tryToReadFromValidFile() {

        JsonNode json = JsonBuilderAndParser.readJsonFromFile("data.json");
        System.out.println(json.toString());

    }

}
