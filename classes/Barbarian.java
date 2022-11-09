package classes;

public class Barbarian extends CharacterClass{
    private String perk;

    public Barbarian(){
        this.name = "Barbarian";
        this.dice = 12;
        this.perk = "Battle Rage";
    }

    @Override
    public void printMagika(){
        System.out.println("Class " + name + "can do " + perk);
    }
}
