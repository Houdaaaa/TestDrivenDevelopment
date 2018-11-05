import java.util.ArrayList;
import java.util.Random;

public class RemoveLetter extends TypeBonus {

    public RemoveLetter() {}

    @Override
    public void ApplyBonus(Game game) {

        game.GetDifficulty().RetryCoins(game.GetPlayer());

        Random random = new Random();

        String word = game.GetMystery().getKey();
        ArrayList<Character> displayLetters = game.GetLetterDisplay();

        while (true) {
            int randInt = random.nextInt(displayLetters.size());
            char randLetter = displayLetters.get(randInt);

            if (word.indexOf(randLetter) == -1) {
                displayLetters.remove(randInt);
                break;
            }
        }


        used = false;
        game.SetLetterDisplay(displayLetters);
    }
}
