package Main;

import Visitor.DataElement;
import Visitor.DataElementsVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Stats implements DataElement {

    protected Map<String, Integer> stats;

    public Stats(int st, int dex, int con, int intel, int wis, int ch){
        this.stats = new HashMap<String, Integer>();

        this.stats.put("Strength", st);
        this.stats.put("Dexterity", dex);
        this.stats.put("Constitution", con);
        this.stats.put("Intelligence", intel);
        this.stats.put("Wisdom", wis);
        this.stats.put("Charisma", ch);
    }

    public Map<String, Integer> getAttrib(){

        return stats;
    }

    public void setStats(Map<String, Integer> stats){

        this.stats = stats;
    }

    public static Stats generate(){
        Dice dice = new Dice();

        return new Stats(dice.roll(), dice.roll(), dice.roll(), dice.roll(),
                dice.roll(), dice.roll());
    }

    public void print(){
        System.out.println();
        System.out.println("Strength: " + this.stats.get("Strength"));
        System.out.println("Dexterity: " + this.stats.get("Dexterity"));
        System.out.println("Constitution: " + this.stats.get("Constitution"));
        System.out.println("Intelligence: " + this.stats.get("Intelligence"));
        System.out.println("Wisdom: " + this.stats.get("Wisdom"));
        System.out.println("Charisma: " + this.stats.get("Charisma"));
    }

    @Override
    public TreeMap accept(DataElementsVisitor visitor){
        return visitor.visit(this);
    }

    public Memento save(){
        return  new Memento(stats);
    }

    public void undoToLastSave(Object object){
        Memento memento = (Memento) object;
        this.stats = memento.stats;
    }

    private class Memento{
        private Map<String, Integer> stats;

        Memento(Map<String, Integer> stats){
            this.stats = stats;
        }
    }
}
