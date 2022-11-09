package Race;

import Main.Stats;

public class Halfling extends CharacterRace{

    Halfling(String name, Stats stats){
        this.name = name;
        this.bonuses = stats;
    }

    public Halfling(Stats stats) {
        super();
    }

    @Override
    public int getRaceBonuses(String type){
        if(type == "Charisma")
            return 1;
        else if(type == "Dexterity")
            return 2;

        return 0;
    }

    @Override
    public void battleCry(){
        System.out.println("Tendo banshyo!");
    }
}
