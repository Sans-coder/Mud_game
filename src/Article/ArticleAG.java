package Article;

import Alive.Person;

public class ArticleAG extends Article{
    public ArticleAG(String id,String discribe,int use_times){
        super(id, discribe, use_times);
    }
    public void play_role(Person person)
    {
        person.set_ag_value(100);
        System.out.println("你怒气满了，快上");
        super.play_role(person);
    }
}