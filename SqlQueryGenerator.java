import java.lang.reflect.Field;
import java.util.Map;
import java.util.StringJoiner;

public class SqlQueryGenerator {

    public String generateSelectQuery(Class<?> clazz) {
        String tableName = "test_table"; // Fixed table name
        Field[] fields = clazz.getDeclaredFields();
        StringJoiner columns = new StringJoiner(", ");

        for (Field field : fields) {
            columns.add(field.getName());
        }

        return String.format("SELECT %s FROM %s", columns.toString(), tableName);
    }
}
