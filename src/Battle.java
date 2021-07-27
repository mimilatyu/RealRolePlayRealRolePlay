import java.io.IOException;
import java.sql.SQLOutput;

public class Battle {
    public void fight (Character hero, Character monster, LetsPlay.FightCallback fcb) {
        Runnable runnable = () -> {


                for(int i=1; hero.getHealth()>0&&monster.getHealth()>0; i++){
                    int heroHit = hero.attack();
                    int monsterHit = monster.attack();
                    if((i+1)%2==0){
                        if(heroHit!=0){
                            monster.setHealth(monster.getHealth()-heroHit);
                            System.out.printf("%s нанес %d урона%n", hero.getName(), heroHit);
                            System.out.printf("%s получил затрещину, его здоровье оценивается на %d баллов%n", monster.getName(), monster.getHealth());
                        } else {System.out.printf("%s не попаааал%n", hero.getName());}
                    } else {
                        if(monsterHit!=0){
                            hero.setHealth(hero.getHealth()-monsterHit);
                            System.out.printf("%s нанес %d урона%n", monster.getName(), monsterHit);
                            System.out.printf("%s получил затрещину, его здоровье оценивается на %d баллов%n", hero.getName(), hero.getHealth());
                        } else {System.out.printf("%s не попаааал%n", monster.getName());}
                    }
                }

                if(hero.getHealth()<=0){
                System.out.println("Вы умер. F!");
                fcb.fightLost();
                } else if(monster.getHealth()<=0){
                    System.out.printf("Враг повержен! Вы получаете %d опыт и %d золота на карту сбера%n", monster.getXp(), monster.getGold());
                    hero.setXp(hero.getXp() + monster.getXp());
                    hero.setGold(hero.getGold() + monster.getGold());
                    fcb.fightWin();
            }

        };

        Thread thread = new Thread(runnable);
        thread.start();


    }

}
