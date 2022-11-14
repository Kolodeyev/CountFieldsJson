package org.kolodieiev;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    }

}
