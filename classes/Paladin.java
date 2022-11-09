package classes;

import java.util.ArrayList;
import java.util.List;

public class Paladin extends CharacterClass{
    private List<String> spells;

    public Paladin(){
        this.name = "Paladin";
        this.dice = 10;

        this.spells = new ArrayList<>();
        spells.add("Bless");
        spells.add("Aura of Life");
    }

    @Override
    public void printMagika(){
        System.out.println("\nClass " + name + " uses spells:");

        for(String spell : spells){
            System.out.println(spell);
        }
    }
}
