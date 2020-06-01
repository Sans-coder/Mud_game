package castle;

import java.util.Scanner;

public class HandlerBackpack extends Handler{
    public HandlerBackpack(Game game)
    {
        super(game);
    }
    @Override
    public boolean isBackpack(){
        return true;
    }
    public void doCmd(){
        System.out.print("道具有:"+"  "+"(输入‘back’退出)");
        System.out.println(game.getPerson().getArticleDes());
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(" ");
        if(words[0].equals("back")||words[0].equals(""))
        {
           
        }else{
            game.getPerson().getArticle(words[0]).play_role(game.getPerson());
            game.getPerson().ArticleJudge();
        }
        
    }
}