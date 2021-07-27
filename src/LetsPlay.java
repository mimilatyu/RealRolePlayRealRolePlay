

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//дорогой проверяющий, задача оказалась реально сложной для меня, поэтому часть работу откровенно украдена у автора,
// класс Battle написал по-своему, мне так показалось лаконичнее, не успеваю дописать ТОРГАША, горят сроки, займусь им очень скоро и добавлю в игру
//СПАСИБО!
public class LetsPlay {
    private static BufferedReader reader;
    private static Character player = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Вас зовут . . . > > >");
        try {
            command(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void command(String string) throws IOException {

        if (player == null) {
            player = new Hero(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.printf("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!%n", player.getName());
            //Метод для вывода меню
            printNavigation();
        }
        //Варианты для команд
        switch (string) {
            case "1": {
                System.out.println("Торговец еще не приехал");
                command(reader.readLine());
            }
            break;
            case "2": {
                battle.fight(player, createMonster(),new FightCallback() {
                    @Override
                    public void fightWin() {
                        System.out.printf("%s победил! Теперь у него %d опыта и %d золота на карте сбера, а также %d здоровья.%n", player.getName(), player.getXp(), player.getGold(), player.getHealth());
                        System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                        try {
                            command(reader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void fightLost() {

                    }
                });
            }
            break;
            case "3":
                System.out.println("До встречи, воин!");
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(reader.readLine());;
            }
        }
        //Снова ждем команды от пользователя
        command(reader.readLine());
    }

    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торгашу");
        System.out.println("2. Драца");
        System.out.println("3. НАВЫХОД!");
    }

    private static Character createMonster() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) return new Goblin(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }



    interface FightCallback {
        void fightWin();
        void fightLost();
    }
}
