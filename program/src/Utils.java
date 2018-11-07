import org.json.JSONObject;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

class Utils {

    /* This method avoids duplicating the database opening code for subclasses
     *
     * @param  path  the path to the database
     * @return       a JSONObject representing the database
     */
    public static JSONObject ReadDatabase(String path) {
        try {
            File file = new File(path);
            String content = FileUtils.readFileToString(file, "utf-8");

            return new JSONObject(content);
        }
        catch (Exception e) { System.out.print(e); }

        return new JSONObject();
    }

    /* Check if the player ase enough coins for using bonus
     *
     * @param  player      the game's player
     * @param  difficulty  the game's difficulty
     * @return boolean     true: if the player can use; false: if the user can not use
     */
    public static boolean CheckCoins (Player player, Difficulty difficulty) {
        int playerCoins = player.GetCoins();
        int levelCoin = difficulty.GetLevelCoin();

        return playerCoins > levelCoin;
    }

    /* Mix an array (Fisher-Yates algorithm)
     *
     * @param  array                the initial array of char
     * @return ArrayList<Character> the array mixed
     */
    public static ArrayList<Character> MixArray(ArrayList<Character> array) {
        Random random = new Random();

        for (int i=array.size()-1; i>0; i--) {
            int randPos = random.nextInt(i);
            char temp = array.get(i);
            array.set(i, array.get(randPos));
            array.set(randPos, temp);
        }

        return array;
    }
}
