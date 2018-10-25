import java.util.*;
import javafx.util.*;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;

public abstract class TypeMystery {
    public abstract void NextMystery();

    public abstract Pair<String, List<String>> ChoiceMystery(String difficulty);

    public JSONObject ReadDatabase(String path) {
        try {
            File file = new File(path);
            String content = FileUtils.readFileToString(file, "utf-8");

            return new JSONObject(content);
        }
        catch (Exception e) { System.out.print(e); }

        return new JSONObject();
    }
}
