
public abstract class TypeBonus {
    protected boolean used = false;

    /* Apply the chosen bonus to the game status
     *
     * @param  game  represents information related to the game
     * @return void
     */
    public abstract void ApplyBonus(Game game);

    /* Returns if the bonus is used or not
     *
     * @return  true: the bonus is used, false: the bonus does not used
     */
    public boolean IsAvalaible() { return used; }
}
