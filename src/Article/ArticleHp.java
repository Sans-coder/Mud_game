package Article;

import Alive.Person;

public class ArticleHp extends Article{
    public ArticleHp(String id,String discribe,int use_times)
    {
        super(id, discribe, use_times);
    }
    public void play_role(Person person){
         person.set_hp(200);
         System.out.println("你满血了");
         super.play_role(person);
    }
}