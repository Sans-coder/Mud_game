package Alive;

import java.util.Random;

import Article.ArticleAG;
import Article.ArticleHp;

public class Monster extends Creature{
    
    private int lucky_value=0;

    Monster(String id,String discribe,int hp,int anger_value,int attack_value){
        super(id,discribe,hp,anger_value,attack_value);
        Random random = new Random();
        lucky_value = random.nextInt(2);
    }
    @Override
    public void Nirvana(){

    }
    public void Attack(Person person){
        int damage = get_attack_value();
        if(anger_value>=100)
        {
            System.out.println(get_dis()+"爆发");
            damage = get_attack_value()*2;
            anger_value =0;
        }
        System.out.print(get_base());
        System.out.print("对你造成了");
        System.out.print(damage);
        System.out.println("伤害");
        int now_hp = person.get_hp() - damage;
        int now_ag_value = person.get_ag_value() + get_attack_value();
        person.set_hp(now_hp);
        person.set_ag_value(now_ag_value);
    }

    public String get_base(){
        StringBuffer sb = new StringBuffer();
        sb.append(get_id());
        sb.append('(');
        sb.append(get_dis());
        sb.append(')');
        return sb.toString();
    }
    public void hp_judge(){
        if(hp <= 0){
            set_status(0);
        }
    }
    public void Article_judge(Person person){
        if(lucky_value==0)
        {
           person.addArticle(new ArticleHp("hp1","加血" , 2));
        }else if(lucky_value==1)
        {
            person.addArticle(new ArticleAG("AG1","满怒" , 2));
        }
    }
}