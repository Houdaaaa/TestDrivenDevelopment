import java.util.*;
import javafx.util.*;

public class Main {
    public static void main(String [] args) {
        SentenceMystery test = new SentenceMystery();



        test.NextMystery();


        Difficulty diff = new Difficulty("easy");
        TypeMystery typeMystery = test;

        String[] ok = {"one", "two"};
        Pair<String,String[]> mystery = new Pair<String, String[]>("Hello",ok);
        Game game = new Game(diff, typeMystery,mystery);
        game.Login("Houda", "cool");
        //game.Save();

    }
}