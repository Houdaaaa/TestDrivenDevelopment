package backend;

public abstract class TypeBonus {
    protected boolean used = true;

    /* Apply the chosen bonus to the game status
     *
     * @param  game  represents information related to the game
     * @return void
     */
    public abstract void ApplyBonus(Game game);

    /* Returns if the bonus is used or not
     *
     * @return  true: the bonus does not used, false: the bonus is used
     */
    public boolean IsAvailable() { return used; }

    /* When we choose a new mystery, we reset the usage value
     *
     * @return void
     */
    public void ResetUsed() { used = true; }
}
