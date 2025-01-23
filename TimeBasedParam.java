import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeBasedParam {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmSSS");
        String timestamp = dateFormat.format(new Date());
        String param = "A" + timestamp;
        System.out.println(param);
    }
}
