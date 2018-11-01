import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import javafx.util.*;

public class SentenceMystery extends TypeMystery{

    public SentenceMystery() {}

    @Override
    public void NextMystery() {
        // TODO: 25-10-18 Set the instance variables in game when game is made
        Pair<String, List<String>> test = ChoiceMystery("easy");
        ArrayList<Character> displayLetters = TypeMystery.ChoiceLetters(test.getKey());

        System.out.print(test.getKey());
        System.out.print(displayLetters);
    }

    @Override
    public Pair<String, List<String>> ChoiceMystery(String difficulty) {
        List<String> statement = new ArrayList<String>();
        String word = null;
        Random random = new Random();

        try {
            JSONObject db = ReadDatabase("src/database.json");
            JSONArray diff = db.getJSONObject(difficulty).getJSONArray("sentenceMode");

            int randMystery = random.nextInt(diff.length());
            JSONObject mystery = diff.getJSONObject(randMystery);

            word = (String) mystery.get("word");
            statement.add(mystery.get("sentence"));
            statement.add(mystery.get("sentence"));

        }
        catch (Exception e) { System.out.print(e); }

        return new Pair<String, List<String>>(word, statement);
    }
}
