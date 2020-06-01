package castle;

import Alive.Monster;

public class HandlerAttack extends Handler {
    public HandlerAttack(Game game){
        super(game);
    }

    @Override
    public void doCmd(String id)
    {
        System.out.println();
        Monster monster = game.getCuMonster(id);
        if(monster ==null)
        {
            System.out.println("不存在该对象");
        }else{
            game.PerAttack(monster);
            game.getCuMonster(id).Attack(game.getPerson());
            System.out.println();
        }
        
    }
}