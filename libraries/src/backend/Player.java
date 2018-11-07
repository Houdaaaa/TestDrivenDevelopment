package backend;

public class Player {

    private String pseudo;
    private int coins;

    public Player(String pseudo){
        this.pseudo = pseudo;
    }

    public String GetPseudo() {
        return pseudo;
    }

    public void SetPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int GetCoins() {
        return coins;
    }

    public void SetCoins(int coins) {
        this.coins = coins;
    }
}
