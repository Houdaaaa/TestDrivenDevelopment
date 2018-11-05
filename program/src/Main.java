import java.util.*;
import javafx.util.*;

public class Main {
    public static void main(String [] args) {

        SentenceMystery typeMystery = new SentenceMystery();
        Difficulty difficulty = new Difficulty("easy");

        Game game = new Game(difficulty, typeMystery);
        game.SetTypeMystery(typeMystery);
        game.Login("Houda", "cool");

        game.NextMystery();

        ArrayList<Character> displayLetters = game.GetLetterDisplay();
        System.out.println(displayLetters);

        System.out.println(game.GetBonusList().get(0).IsAvailable());

        game.GetBonusList().get(0).ApplyBonus(game);
        System.out.println(displayLetters);

        System.out.println(game.GetBonusList().get(0).IsAvailable());

        game.Save();
    }
}