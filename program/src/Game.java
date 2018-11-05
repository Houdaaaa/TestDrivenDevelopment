import org.json.JSONObject;
import javafx.util.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class Game {

    private Player player;
    private Difficulty difficulty;
    private TypeMystery typeMystery;
    private Pair<String, String[]> mystery ;
    private ArrayList<Character> letterDisplay;

    //private Bonus BonusList[];

    public Game(Difficulty difficulty, TypeMystery typeMystery, Pair<String, String[]> mystery){ //Ajouter Player
        this.difficulty = difficulty;
        this.typeMystery = typeMystery;
        this.mystery = mystery;

    }

    /* To play an other gameMystery
     *
     * @param
     * @return void
     */
    public void NextMystery(){
        //typeMystery.NextMystery(this);
    }


    public void SetLetterDisplay(ArrayList<Character> letterDisplay) {
        this.letterDisplay = letterDisplay;
    }

    public ArrayList<Character> GetLetterDisplay(){
        return this.letterDisplay;
    }

    public void SetTypeMystery(TypeMystery typeMystery){
        this.typeMystery = typeMystery;
    }

    public void SetDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public Difficulty GetDifficulty() {
        return this.difficulty;
    }

    public void SetMystery(Pair<String, String[]> mystery){
        this.mystery = mystery;
    }

    public Pair<String, String[]> GetMystery() {
        return mystery;
    }

    /* Connect and initialize a player
     *
     * @param  pseudo   the pseudo of the player
     * @param  password the password of the player
     * @return void
     */
    public void Login(String pseudo, String password){
        JSONObject playerData = CheckLogin(pseudo,password);

        if(playerData.length() != 0){
            Player player = new Player(pseudo);
            this.player = player;

            try{
                int playerCoins = (int) playerData.get("coins");
                player.SetCoins(playerCoins);

                System.out.print("Connection réussie");

            }catch (Exception e){
                System.out.print("Connection échouée");

            }
        }
        else {
            System.out.print("Connection échouée");
        }
    }


    /* Check the pseudo and the password of a player
     *
     * @param  pseudo   the pseudo of the player
     * @param  password the password of the player
     * @return          a JSONObject representing the player's data
     */
    private JSONObject CheckLogin(String pseudo, String password){
        JSONObject objectNull = new JSONObject();

        try {
            JSONObject db = typeMystery.ReadDatabase("src/playerDatabase.json");

            JSONObject playerData = db.getJSONObject(pseudo);
            String pass = (String) playerData.get("password");

            if(pass.equals(password)){
                return playerData;
            }
            else{
                return objectNull;           //invalid password
            }

        } catch (Exception e) {
            return objectNull;               //invalid pseudo
        }

    }


    /* Update the json which represent the player's data
     *
     * @return void
     */
    public void Save(){
        try{
            JSONObject db = typeMystery.ReadDatabase("src/playerDatabase.json");
            JSONObject playerData = db.getJSONObject(player.GetPseudo());
            playerData.put("coins",player.GetCoins());

            try (FileWriter files = new FileWriter("src/playerDatabase.json"))
            {
                files.write(db.toString());
                System.out.println("\nSuccessfully updated json object to file !");
            }
        } catch (Exception e){
            System.out.print(e);
        }

    }


}
