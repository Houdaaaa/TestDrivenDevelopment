import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;
import javafx.util.*;

public class SentenceMystery extends TypeMystery{

    public SentenceMystery() {}

    @Override
    public void NextMystery(Game game) {
        // TODO: 01-11-18 Regarder si ça fonctionne bien quand game est acquis
        Pair<String, List<String>> mystery = ChoiceMystery("easy");
        ArrayList<Character> displayLetters = TypeMystery.ChoiceLetters(mystery.getKey());

        game.SetMystery(mystery);
        game.SetDisplayLetters(displayLetters);
    }

    @Override
    public Pair<String, List<String>> ChoiceMystery(String difficulty) {
        List statement = new ArrayList<>();
        String word = null;
        Random random = new Random();

        try {
            JSONObject db = Utils.ReadDatabase("src/database.json");
            JSONArray diff = db.getJSONObject(difficulty).getJSONArray("sentenceMode");

            int randMystery = random.nextInt(diff.length());
            JSONObject mystery = diff.getJSONObject(randMystery);

            word = (String) mystery.get("word");
            statement.add(mystery.get("sentence"));
            statement.add(mystery.get("sentence"));

        }
        catch (Exception e) { System.out.print(e); }

        ArrayList<TypeBonus> bonusList = game.GetBonusList();
        for (int i=0; i<bonusList.size(); i++) {
            bonusList.get(i).ResetUsed();
        }

        return new Pair<String, List<String>>(word, statement);
    }
}
