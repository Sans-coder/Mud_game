package castle;

public class HandlerHelp extends Handler{
    public HandlerHelp(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word){
       game.printHelp();
    }
}