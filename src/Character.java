public abstract class Character implements Fighter {
    //наделяем характеристиками, которые будут у всех
    private String name;
    private int health;
    private int strength;
    private int skill;
    private int xp;
    private int gold;

    //конструктор
    public Character(String name, int health, int strength, int skill, int xp, int gold) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.skill = skill;
        this.gold = gold;
        this.xp = xp;
    }

    @Override
    public int attack() {
        if(skill*3>(int)(Math.random()*100)) return strength;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
