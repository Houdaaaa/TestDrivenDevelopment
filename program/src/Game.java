import org.json.JSONObject;
import javafx.util.*;

import javax.rmi.CORBA.Util;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private Difficulty difficulty;
    private TypeMystery typeMystery;
    private Pair<String, List<String>> mystery ;
    private ArrayList<Character> letterDisplay;
    private ArrayList<TypeBonus> bonusList = new ArrayList<TypeBonus>();

    public Game(Difficulty difficulty, TypeMystery typeMystery){ //Ajouter Player
        this.difficulty = difficulty;
        this.typeMystery = typeMystery;

        this.bonusList.add(new RemoveLetter());
    }

    /* To play an other gameMystery
     *
     * @param
     * @return void
     */
    public void NextMystery() {
        typeMystery.NextMystery(this);
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

    public void SetMystery(Pair<String, List<String>> mystery){
        this.mystery = mystery;
    }

    public Pair<String, List<String>> GetMystery() { return mystery; }

    public ArrayList<TypeBonus> GetBonusList() { return bonusList; }

    public Player GetPlayer() { return player; }

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
            JSONObject db = Utils.ReadDatabase("src/playerDatabase.json");

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
            JSONObject db = Utils.ReadDatabase("src/playerDatabase.json");
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
