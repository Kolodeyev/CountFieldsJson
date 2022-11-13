import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadFromJsonFile {

    public static void readFromJsonFile(String path) {

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {

            jsonArray = (JSONArray) parser.parse(new FileReader(path));

//            JSONObject data = (JSONObject) parser.parse(new FileReader(path));
//            String json = data.toJSONString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;

            String strName = (String) person.get("name");
            System.out.println("Name::::" + strName);

            String strCity = (String) person.get("city");
            System.out.println("City::::" + strCity);

            JSONArray arrays = (JSONArray) person.get("cars");
            for (Object object : arrays) {
                System.out.println("cars::::" + object);
            }
            String strJob = (String) person.get("job");
            System.out.println("Job::::" + strJob);
            System.out.println();

        }

    }

}
