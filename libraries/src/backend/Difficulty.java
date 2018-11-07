import java.util.*;
public class Difficulty {


    private String name;
    private int levelCoin;
    private Map<String, Integer> coinConfiguration = new HashMap<String, Integer>(){{       // + verification programmeur
        put("easy", 10);
        put("intermediate", 20);
        put("advanced", 30);
    }};

    public Difficulty(String name) {
        this.name = name;
        this.levelCoin = coinConfiguration.get(name);
    }

    public String GetName(){
        return this.name;
    }

    public int GetLevelCoin() { return this.levelCoin; }

    public void SetName(String name){
        this.name = name;
    }

    /* Remove coins of a player
     *
     * @param  player   the player who spent his coins
     * @return void
     */
    public void RetryCoins(Player player){
        int currentCoins = player.GetCoins();
        int newCoins = currentCoins - levelCoin;
        player.SetCoins(newCoins);

    }

    /* Add coins of a player
     *
     * @param  player   the player who won his coins
     * @return void
     */
    public void AddCoins(Player player) {
        int currentCoins = player.GetCoins();
        int newCoins = currentCoins + levelCoin;
        player.SetCoins(newCoins);

    }


}
