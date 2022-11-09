package Race;

import Main.Stats;

public class Elf extends CharacterRace{

    Elf(String name, Stats stats){
        this.name = name;
        this.bonuses = stats;
    }

    public Elf(Stats stats) {
        super();
    }

    @Override
    public int getRaceBonuses(String type){
        if(type == "Wisdom")
            return 1;
        else if(type == "Dexterity")
            return 2;

        return 0;
    }

    @Override
    public void battleCry(){
        System.out.println("To the Light and Moon!");
    }
}
