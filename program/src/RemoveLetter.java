import java.util.ArrayList;
import java.util.Random;

public class RemoveLetter extends TypeBonus {

    public RemoveLetter() {}

    @Override
    public void ApplyBonus(Game game) {
        Random random = new Random();

        String word = game.GetMystery().getKey();
        ArrayList<Character> displayLetters = game.GetDisplayLetters();

        while (true) {
            int randInt = random.nextInt(displayLetters.size());
            char randLetter = displayLetters.get(randInt);

            if (word.indexOf(randLetter) == -1) {
                displayLetters.remove(randInt);
                break;
            }
        }

        used = true;
        game.SetDisplayLetters(displayLetters);
    }
}
