import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class SqlValidator {

    public boolean validate(String url, String user, String password, String query, Map<String, String> expectedValues) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                for (Map.Entry<String, String> entry : expectedValues.entrySet()) {
                    String columnName = entry.getKey();
                    String expectedValue = entry.getValue();
                    String actualValue = rs.getString(columnName);

                    if (!expectedValue.equals(actualValue)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
