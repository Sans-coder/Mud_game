package castle;

public class Handler {
    protected Game game;
    public Handler(Game game){
        this.game = game;
    }
    public void doCmd(String word){}
    public void doCmd(){}
    public boolean isBye(){return false;}
    public boolean isBackpack(){return false;}
}