package castle;

import java.util.HashMap;
import java.util.Scanner;

import Alive.Monster;
import Alive.MonsterCat;
import Alive.MonsterDog;
import Alive.Person;



public class Game {
    private Room currentRoom;
    private HashMap<String,Handler>handlers = new HashMap<String,Handler>();
    private Person person= new Person("P1","Tony",200,0,30);

    public Game() 
    {
        handlers.put("go",new HandlerGo(this));
        handlers.put("bye",new HandlerBye(this));
        handlers.put("help",new HandlerHelp(this));
        handlers.put("Attack",new HandlerAttack(this));
        handlers.put("A",new HandlerAttack(this));
        handlers.put("Bp",new HandlerBackpack(this));
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        

        outside.setMonster(new MonsterCat("C1", "猫妖", 100, 0,30));
        lobby.setMonster(new MonsterCat("C1", "猫妖", 100, 0,30));
        pub.setMonster(new MonsterDog("D1","狗妖", 200, 0,15));
        study.setMonster(new MonsterDog("D1","狗妖",200,0,15));
        bedroom.setMonster(new MonsterCat("C1", "猫妖", 100, 0,30));
        
        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println("击败所有怪物就算取得胜利");
        System.out.println("怒气满了会自动放技能，提升平a伤害");
        System.out.println("打怪物会获得血瓶（加满学）或者怒气瓶（怒气加满）");
        System.out.println("打开背包Bp来使用道具");
        System.out.println();
        showPrompt();
       
    }

    public void showPrompt(){
        System.out.println("------------------------------------");
        System.out.println(person.base());
        System.out.print("存在的怪物: ");
        System.out.println(currentRoom.getMonsterDesc());
        System.out.println("------------------------------------");
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }

    // 以下为用户命令

    public  void printHelp() 
    {
        System.out.print("迷路了吗？你可以做的命令有：go bye help Attack Backpack(bp)");
        System.out.println("如：\tgo east");
    }


    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if (words.length > 1)
                value = words[1];
            if (handler != null) {
                if (handler.isBye()) {
                    break;
                }else if(handler.isBackpack()){
                    handler.doCmd();
                    
                }
                else{
                    handler.doCmd(value);
                }
            }
            if(Perjudge(person)==0)
            {   
                System.out.println('\n');
                System.out.println("你当前血量为"+person.get_hp());
                System.out.println("GAME OVER!!");
                break;
            }else{
                currentRoom.Monjudge(person);
            }
            if(gameWin()==1)
            {
                break;
            }
            showPrompt();
            
        }
        in.close();
    }

    public int  gameWin(){
        if(Person.get_left_monster()==0)
        {
            System.out.println("\n"+"\n");
            System.out.println("\t"+"You Win!!!!");
            return 1;
        }
        return 0;
    }
    public void goRoom(String direction) {

        Room nextRoom = currentRoom.getRoom(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        } else {
            currentRoom = nextRoom;
           
        }

    }
    public Monster getCuMonster(String monster_id)
    {
        return currentRoom.getMonster(monster_id);
    }
    public void PerAttack(Monster monster)
    {
        person.Attack(monster);
    }
    public Person getPerson(){
        return person;
    }
    public int Perjudge(Person person)
    {
        person.hp_judge();
        if(person.get_status()==0)
        {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();
	}

}
