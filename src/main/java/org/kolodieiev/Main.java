package org.kolodieiev;

import com.fasterxml.jackson.databind.JsonNode;

import static org.kolodieiev.JsonBuilderAndParser.foundFields;

public class Main {

    public static void main(String[] args) {

        String expectedName = "cars";
        String expectedValue = "bmw";

        JsonNode jsonNode = JsonBuilderAndParser.readJsonFromFile("data.json");
        JsonBuilderAndParser.findRepeatingFields(jsonNode);
        CheckingConditions.countSpecificValueInFields(
                foundFields, expectedName, expectedValue);

        System.out.println("- found " + foundFields.size() + " objects with field '" + expectedName + "'");

    }
}
