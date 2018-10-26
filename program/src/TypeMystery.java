import java.util.*;
import javafx.util.*;
import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;

public abstract class TypeMystery {
    public abstract void NextMystery();

    public abstract Pair<String, List<String>> ChoiceMystery(String difficulty);

    /* For players to find the mystery word, it is necessary to mix the letters of the word with mixed letters of the alphabet
     *
     * @param  word  the word to be mixed with random letters
     * @return       a ArrayList which contain the word's characters and a random alphabet's letters
     */
    protected static ArrayList<Character> ChoiceLetters(String word) {
        Random random = new Random();
        ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                                                                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                                                                                'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        ArrayList<Character> wordArray = new ArrayList<Character>();
        ArrayList<Character> response = new ArrayList<Character>();

        //breaks down the word to be found
        for (char c : word.toCharArray()) {
            wordArray.add(c);
        }

        //build response with a random letters and word's letter
        for (int i=0; i<word.length(); i+=1) {
            response.add(wordArray.get(i));

            for (int j=0; j<(14-word.length())/word.length(); j++) {
                int randLetter = random.nextInt(alphabet.size());
                response.add(alphabet.get(randLetter));
            }
        }
        return response;
    }

    /* This method avoids duplicating the database opening code for subclasses
     *
     * @param  path  the path to the database
     * @return       a JSONObject representing the database
     */
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
