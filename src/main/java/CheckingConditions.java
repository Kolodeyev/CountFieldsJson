import java.util.List;

public class CheckingConditions {

    private static int VALUE_COUNT = 0;

    public static void countSpecificValueInFields(List<Object> foundFields, String expectedValue) {

//        foundFields.stream()

        for (Object currentObject : foundFields) {
            if (currentObject.toString().contains(expectedValue)) {
                VALUE_COUNT += 1;
            }
            System.out.println(currentObject.toString());
        }

    }

    public static int getValueCount() {
        return VALUE_COUNT;
    }
}
