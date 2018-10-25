import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class SentenceMystery extends TypeMystery{

    public SentenceMystery() {}

    public void NextMystery() {
        try {
            JSONObject db = ReadDatabase("src/database.json");

            JSONArray easy = db.getJSONArray("easy");

            for (int i=0; i<easy.length(); i++) {
                JSONObject mystery = easy.getJSONObject(i);

                System.out.println(mystery.get("sentence"));
            }
        }
        catch (Exception e) { System.out.print(e); }
    }

    private JSONObject ReadDatabase(String path) {
        try {
            File file = new File(path);
            String content = FileUtils.readFileToString(file, "utf-8");

            return new JSONObject(content);

        }
        catch (Exception e) { System.out.print(e); }
    }
}
