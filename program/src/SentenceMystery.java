import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.*;

public class SentenceMystery extends TypeMystery{

    public SentenceMystery() {}

    public void NextMystery() {
        // TODO: 25-10-18 Set the instance variables in game when game is made
        Map test = ChoiceMystery("easy");
        
        System.out.print(test);
    }

    protected Map<String, List<String>> ChoiceMystery(String difficulty) {
        Map response = new HashMap();
        List statement = new ArrayList();
        Random random = new Random();

        try {
            JSONObject db = ReadDatabase("src/database.json");
            JSONArray diff = db.getJSONObject(difficulty).getJSONArray("sentenceMode");

            int randMystery = random.nextInt(diff.length());
            JSONObject mystery = diff.getJSONObject(randMystery);

            statement.add(mystery.get("sentence"));
            response.put(mystery.get("word"), statement);
        }
        catch (Exception e) { System.out.print(e); }

        return response;
    }

    private JSONObject ReadDatabase(String path) {
        try {
            File file = new File(path);
            String content = FileUtils.readFileToString(file, "utf-8");

            return new JSONObject(content);
        }
        catch (Exception e) { System.out.print(e); }

        return new JSONObject();
    }
}
