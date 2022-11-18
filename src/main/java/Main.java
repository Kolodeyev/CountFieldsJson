public class Main {

    public static void main(String[] args) {

//        String path = "data.json";
//        String expectedFieldName = "cars";
//        String expectedValue = "Toyota";
        String path = args[0];
        String expectedFieldName = args[1];
        String expectedValue = args[2];

        CheckingConditions checkingConditions = new CheckingConditions(path, expectedFieldName, expectedValue);

        checkingConditions.createResults();

    }
}
