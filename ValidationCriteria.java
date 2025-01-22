import java.util.Map;

public class ValidationCriteria {
    private Map<String, String> fieldValues;

    public ValidationCriteria(Map<String, String> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public Map<String, String> getFieldValues() {
        return fieldValues;
    }
}
