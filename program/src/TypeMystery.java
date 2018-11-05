import java.util.*;
import javafx.util.*;

public abstract class TypeMystery {

    /* Set the necessary information to launch a game tour
     *
     * @param  game  represents information related to the game
     * @return void
     */
    public abstract void NextMystery(Game game);

    /* Chooses a mystery at random depending on the difficulty and mode of play
     *
     * @param  difficulty  easy, intermediate, advanced
     * @return             key: the word to find; value: a clue list to find the word
     */
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

            for (int j=0; j<(12-word.length())/word.length(); j++) {
                int randLetter = random.nextInt(alphabet.size());
                response.add(alphabet.get(randLetter));
            }
        }
        return response;
    }

}
